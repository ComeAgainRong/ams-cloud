package com.ams.admin.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import com.ams.admin.config.AdminConfig;
import com.ams.admin.config.AdminMapStruct;
import com.ams.admin.mapper.SysPermissionMapper;
import com.ams.admin.pojo.entity.SysPermission;
import com.ams.admin.pojo.entity.SysRolePermission;
import com.ams.admin.pojo.req.CommonReq;
import com.ams.admin.pojo.req.SavePermissionReq;
import com.ams.admin.pojo.vo.SysPermissionVO;
import com.ams.admin.pojo.vo.SysServiceVO;
import com.ams.admin.service.ISysPermissionService;
import com.ams.admin.service.ISysRolePermissionService;
import com.ams.common.constan.GlobalConstants;
import com.ams.common.result.ResultCode;
import com.ams.common.utils.AssertUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;


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
public class SysPermissionServiceImpl extends ServiceImpl<SysPermissionMapper, SysPermission> implements ISysPermissionService {

    @Autowired
    private  RedisTemplate redisTemplate;

    @Autowired
    private  AdminMapStruct adminMapStruct;

    @Autowired
    private  AdminConfig adminConfig;

    @Autowired
    private  ISysRolePermissionService rolePermissionService;

    /**
     * 首先 先删除redis中本用户角色权限
     * 从数据库中获取用户角色权限 放入redis中
     * @return
     */
    @Override
    public boolean refreshPermRolesRules() {
        redisTemplate.delete(Arrays.asList(GlobalConstants.URL_PERM_ROLES_KEY));
        List<SysPermission> permissions = this.listPermRoles();
        if (CollectionUtil.isNotEmpty(permissions)) {
            // 初始化URL- 角色规则
            List<SysPermission> urlPermList = permissions.stream()
                    .filter(item -> StrUtil.isNotBlank(item.getUrlPerm()))
                    .collect(Collectors.toList());
            if (CollectionUtil.isNotEmpty(urlPermList)) {
                Map<String, List<String>> urlPermRoles = new HashMap<>();
                urlPermList.stream().forEach(item -> {
                    String perm = item.getUrlPerm();
                    List<String> roles = item.getRoles();
                    urlPermRoles.put(perm, roles);
                });
                redisTemplate.opsForHash().putAll(GlobalConstants.URL_PERM_ROLES_KEY, urlPermRoles);
            }
        }
        return true;
    }

    @Override
    public List<SysPermission> listPermRoles() {
        return this.baseMapper.listPermRoles();
    }

    @Override
    public List<SysPermissionVO> listByMenuId(Long menuId) {
        List<SysPermission> list = lambdaQuery().eq(SysPermission::getMenuId, menuId).list();
        if(CollectionUtil.isNotEmpty(list)){
            return adminMapStruct.sysPermissionToPermissionVO(list);
        }
        return Collections.EMPTY_LIST;
    }

    @Override
    public void createPermission(SavePermissionReq req) {
        SysPermission sysPermission = new SysPermission();
        BeanUtils.copyProperties(req, sysPermission);
        String urlPerm= String.format(GlobalConstants.ADMIN_URL_PERM, req.getMethod(),req.getServiceName(),req.getUrl());
        sysPermission.setUrlPerm(urlPerm);
        save(sysPermission);
    }

    @Override
    public void updatePermission(SavePermissionReq req) {
        AssertUtil.notEmpty(req.getId(), ResultCode.PARAM_VALID_FAIL);
        SysPermission sysPermission = new SysPermission();
        BeanUtils.copyProperties(req, sysPermission);
        String urlPerm= String.format(GlobalConstants.ADMIN_URL_PERM, req.getMethod(),req.getServiceName(),req.getUrl());
        sysPermission.setUrlPerm(urlPerm);
        updateById(sysPermission);
    }

    @Override
    public List<SysServiceVO> getService() {
        List<String> services = adminConfig.getServices();
        if (CollectionUtil.isNotEmpty(services)) {
            List<String> validServices = services.stream().filter(service -> service.split(",").length == 2).collect(Collectors.toList());
            return validServices.stream().map(service -> {
                String[] nameCode = service.split(",");
                SysServiceVO sysServiceVO = new SysServiceVO();
                sysServiceVO.setServiceCode(nameCode[0]);
                sysServiceVO.setServiceName(nameCode[1]);
                return sysServiceVO;
            }).collect(Collectors.toList());
        }
        return Collections.EMPTY_LIST;
    }

    @Override
    public void detelePermission(List<Long> ids) {
        this.baseMapper.deleteBatchIds(ids);
    }

    @Override
    public List<Long> listRolePermission(Long roleId) {
        List<SysRolePermission> list = rolePermissionService.lambdaQuery().eq(SysRolePermission::getRoleId, roleId).list();
        if(CollectionUtil.isNotEmpty(list)){
            return  list.stream().map(SysRolePermission::getPermissionId).collect(Collectors.toList());
        }
        return Collections.EMPTY_LIST;
    }


}
