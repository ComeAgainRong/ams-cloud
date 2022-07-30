package com.ams.admin.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import com.ams.admin.config.AdminMapStruct;
import com.ams.admin.dto.UserAuthDTO;
import com.ams.admin.mapper.SysMenuMapper;
import com.ams.admin.mapper.SysUserMapper;
import com.ams.admin.pojo.entity.SysMenu;
import com.ams.admin.pojo.entity.SysRoleMenu;
import com.ams.admin.pojo.entity.SysUser;
import com.ams.admin.pojo.entity.SysUserRole;
import com.ams.admin.pojo.req.CommonReq;
import com.ams.admin.pojo.req.SaveMenuReq;
import com.ams.admin.pojo.req.SaveUserReq;
import com.ams.admin.pojo.req.UserListPageReq;
import com.ams.admin.pojo.vo.SysMenuSelectVO;
import com.ams.admin.pojo.vo.SysMenuVO;
import com.ams.admin.pojo.vo.SysUserVO;
import com.ams.admin.service.ISysMenuService;
import com.ams.admin.service.ISysRoleMenuService;
import com.ams.admin.service.ISysUserRoleService;
import com.ams.admin.service.ISysUserService;
import com.ams.admin.utils.PageUtils;
import com.ams.common.constan.GlobalConstants;
import com.ams.common.entity.APage;
import com.ams.common.result.ResultCode;
import com.ams.common.utils.AssertUtil;
import com.ams.common.web.utils.UserContext;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
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
@RequiredArgsConstructor
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements ISysMenuService {

    private final ISysRoleMenuService roleMenuService;

    private final ISysUserRoleService userRoleService;
    @Override
    public List<SysMenuVO> loadMenus() {
        List<SysMenu> menus = lambdaQuery().orderByAsc(SysMenu::getSort).list();
        if (CollectionUtil.isNotEmpty(menus)) {
            List<SysMenuVO> menuVOS = flushMenuVOs(menus, GlobalConstants.ROOT_MENU_ID);
            return menuVOS;
        }
        return Collections.emptyList();
    }

    @Override
    public void createMenu(SaveMenuReq req) {
        SysMenu sysmenu = new SysMenu();
        BeanUtils.copyProperties(req, sysmenu);
        save(sysmenu);
    }

    @Override
    public List<SysMenuVO> lisTree() {
        List<SysMenu> menus = lambdaQuery().orderByAsc(SysMenu::getSort).list();
        if (CollectionUtil.isNotEmpty(menus)) {
            List<SysMenuVO> menuVOS = flushMenuVOs(menus, GlobalConstants.ROOT_MENU_ID);
            return menuVOS;
        }
        return Collections.emptyList();
    }

    @Override
    public void updateMenu(SaveMenuReq req) {
        AssertUtil.notEmpty(req.getId(),ResultCode.PARAM_VALID_FAIL);
        SysMenu sysMenu = new SysMenu();
        BeanUtils.copyProperties(req, sysMenu);
        updateById(sysMenu);
    }

    @Override
    public void deletes(List<Long> ids) {
        while (CollectionUtil.isNotEmpty(ids)) {
            this.baseMapper.deleteBatchIds(ids);
            List<SysMenu> sysMenus = lambdaQuery().in(SysMenu::getParentId, ids).select(SysMenu::getId).list();
            if(CollectionUtil.isNotEmpty(sysMenus)){
                ids =sysMenus.stream().map(SysMenu::getId).collect(Collectors.toList());
            }else{
                ids = null;
            }
        }

    }

    @Override
    public List<SysMenuSelectVO> select(int status) {
        List<SysMenu> menus = lambdaQuery()
                .eq(status != -1, SysMenu::getVisible, status)
                .orderByAsc(SysMenu::getSort).list();
        if (CollectionUtil.isNotEmpty(menus)) {
            List<SysMenuSelectVO> menuVOS = flushMenuSelectVOs(menus, GlobalConstants.ROOT_MENU_ID);
            return menuVOS;
        }
        return Collections.emptyList();
    }

    @Override
    public SysMenuVO getDetail(Long id) {
        SysMenu sysMenu = getById(id);
        AssertUtil.notEmpty(sysMenu,ResultCode.DATE_NOT_FOUND);
        SysMenuVO sysMenuVO=new SysMenuVO();
        BeanUtils.copyProperties(sysMenu,sysMenuVO);
        return sysMenuVO;
    }

    @Override
    public List<Long> listRoleMenu(Long roleId) {
        List<SysRoleMenu> list = roleMenuService.lambdaQuery().eq(SysRoleMenu::getRoleId, roleId).list();
        if(CollectionUtil.isNotEmpty(list)){
            return  list.stream().map(SysRoleMenu::getMenuId).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    @Override
    public void updateRoleMenu(Long roleId, CommonReq req) {

        if(CollectionUtil.isNotEmpty(req.getIds())){
            //删除之前绑定的信息
            roleMenuService.getBaseMapper().delete(roleMenuService.lambdaQuery().eq(SysRoleMenu::getRoleId,roleId).getWrapper());
            //添加新的绑定信息
            List<SysRoleMenu> roleMenus = req.getIds().stream().map(meunId -> new SysRoleMenu(roleId, meunId)).collect(Collectors.toList());
            roleMenuService.saveBatch(roleMenus);
        }

    }

    @Override
    public List<Long> currentUser() {
        List<SysMenu> menus = lambdaQuery().orderByAsc(SysMenu::getSort).list();
        if (CollectionUtil.isNotEmpty(menus)) {
            // 过滤当前用户角色绑定菜单
            Long currentUserId = UserContext.getCurrentUserId();
            List<Long> roleIds = userRoleService.selectRoleIds(currentUserId);
            if (CollectionUtil.isNotEmpty(roleIds)) {
                List<SysRoleMenu> list = roleMenuService.lambdaQuery().in(SysRoleMenu::getRoleId, roleIds).list();
                if (CollectionUtil.isNotEmpty(list)) {
                    return list.stream().map(SysRoleMenu::getMenuId).collect(Collectors.toList());
                }
            }
        }
        return Collections.emptyList();
    }

    /**
     * 组装菜单
     *
     * @param menus
     * @param parentId
     * @return
     */
    private List<SysMenuVO> flushMenuVOs(List<SysMenu> menus, Long parentId) {
        List<SysMenuVO> childMenus = new ArrayList<>();
        for (SysMenu sysMenu : menus) {
            if (parentId.equals(sysMenu.getParentId())) {
                SysMenuVO sysMenuVO = new SysMenuVO();
                BeanUtils.copyProperties(sysMenu, sysMenuVO);
                System.out.println(sysMenuVO);
                childMenus.add(sysMenuVO);
            }
        }
        if (CollectionUtil.isNotEmpty(childMenus)) {
            for (SysMenuVO sysMenuVO : childMenus) {
                List<SysMenuVO> childChildMenus = flushMenuVOs(menus, sysMenuVO.getId());
                sysMenuVO.setChildren(childChildMenus);
            }
            return childMenus;
        }
        return Collections.emptyList();
    }

    /**
     * 组装菜单 select
     *
     * @param menus
     * @param parentId
     * @return
     */
    private List<SysMenuSelectVO> flushMenuSelectVOs(List<SysMenu> menus, Long parentId) {
        List<SysMenuSelectVO> childMenus = new ArrayList<>();
        for (SysMenu sysMenu : menus) {
            if (parentId.equals(sysMenu.getParentId())) {
                SysMenuSelectVO sysMenuVO = new SysMenuSelectVO();
                sysMenuVO.setId(sysMenu.getId());
                sysMenuVO.setLabel(sysMenu.getName());
                childMenus.add(sysMenuVO);
            }
        }
        if (CollectionUtil.isNotEmpty(childMenus)) {
            for (SysMenuSelectVO sysMenuVO : childMenus) {
                List<SysMenuSelectVO> childChildMenus = flushMenuSelectVOs(menus, sysMenuVO.getId());
                sysMenuVO.setChildren(childChildMenus);
            }
            return childMenus;
        }
        return Collections.emptyList();
    }

}
