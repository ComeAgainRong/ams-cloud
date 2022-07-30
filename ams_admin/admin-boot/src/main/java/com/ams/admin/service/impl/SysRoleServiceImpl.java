package com.ams.admin.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.ams.admin.config.AdminMapStruct;
import com.ams.admin.dto.UserAuthDTO;
import com.ams.admin.mapper.SysRoleMapper;
import com.ams.admin.mapper.SysUserMapper;
import com.ams.admin.pojo.entity.SysRole;
import com.ams.admin.pojo.entity.SysRoleMenu;
import com.ams.admin.pojo.entity.SysRolePermission;
import com.ams.admin.pojo.entity.SysUser;
import com.ams.admin.pojo.req.RoleListPageReq;
import com.ams.admin.pojo.req.SaveSysRoleReq;
import com.ams.admin.pojo.vo.SysRoleSelectVO;
import com.ams.admin.pojo.vo.SysRoleVO;
import com.ams.admin.pojo.vo.SysUserVO;
import com.ams.admin.service.ISysRoleMenuService;
import com.ams.admin.service.ISysRolePermissionService;
import com.ams.admin.service.ISysRoleService;
import com.ams.admin.service.ISysUserService;
import com.ams.admin.utils.PageUtils;
import com.ams.common.constan.GlobalConstants;
import com.ams.common.entity.APage;
import com.ams.common.result.ResultCode;
import com.ams.common.utils.AssertUtil;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author： whisper
 * @date： 2021/11/24
 * @description：
 * @modifiedBy：
 * @version: 1.0
 */
@Service
@RequiredArgsConstructor
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole > implements ISysRoleService {

    private final AdminMapStruct adminMapStruct;

    private final ISysRolePermissionService rolePermissionService;

    private final ISysRoleMenuService roleMenuService;
    @Override
    public List<SysRoleSelectVO> roleSelect() {
        List<SysRole> list = lambdaQuery().eq(SysRole::getStatus, GlobalConstants.STATUS_ON).select(SysRole::getId, SysRole::getName).list();
        if(CollectionUtil.isNotEmpty(list)){
            return  adminMapStruct.sysRoleToSysRoleSelectVO(list);
        }
        return Collections.EMPTY_LIST;
    }

    @Override
    public APage<SysRoleVO> listPage(RoleListPageReq req) {
        Page<SysRole> page = new Page<>();
        page.setCurrent(req.getPageNo());
        page.setSize(req.getPageSize());
        LambdaQueryChainWrapper<SysRole> lambdaQuery = lambdaQuery();
        lambdaQuery.orderByAsc(SysRole::getSort);
        if (StringUtils.isNoneBlank(req.getKeyword())) {
            lambdaQuery.like(SysRole::getName, req.getKeyword());
        }
        baseMapper.selectPage(page, lambdaQuery.getWrapper());
        List<SysRole> records = page.getRecords();
        List<SysRoleVO> sysRoleVOS = adminMapStruct.sysRoleToSysRoleVO(records);
        return PageUtils.flush(page, sysRoleVOS);
    }

    @Override
    public void createRole(SaveSysRoleReq req) {
        SysRole sysRole=new SysRole();
        BeanUtils.copyProperties(req,sysRole);
        save(sysRole);

    }

    @Override
    public void updateRole(SaveSysRoleReq req) {
        AssertUtil.notEmpty(req.getId(), ResultCode.PARAM_VALID_FAIL);
        SysRole sysRole=new SysRole();
        BeanUtils.copyProperties(req,sysRole);
        updateById(sysRole);
    }

    @Override
    public void deleteRole(List<Long> ids) {
        lambdaUpdate().in(SysRole::getId,ids).set(SysRole::getDeleted,GlobalConstants.STATUS_ON).update();
        //清除关联的的权限信息
        rolePermissionService.getBaseMapper().delete(rolePermissionService.lambdaQuery().in(SysRolePermission::getRoleId,ids).getWrapper());
        //清除关联的菜单信息
        roleMenuService.getBaseMapper().delete(roleMenuService.lambdaQuery().in(SysRoleMenu::getRoleId,ids).getWrapper());


    }

    @Override
    public void updateRoleStatus(Long id, Long status) {
        lambdaUpdate().set(SysRole::getStatus,status).eq(SysRole::getId,id).update();
    }

}
