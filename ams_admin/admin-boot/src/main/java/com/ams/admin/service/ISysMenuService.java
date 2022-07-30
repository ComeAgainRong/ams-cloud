package com.ams.admin.service;


import com.ams.admin.dto.UserAuthDTO;
import com.ams.admin.pojo.entity.SysMenu;
import com.ams.admin.pojo.entity.SysUser;
import com.ams.admin.pojo.req.CommonReq;
import com.ams.admin.pojo.req.SaveMenuReq;
import com.ams.admin.pojo.req.SaveUserReq;
import com.ams.admin.pojo.req.UserListPageReq;
import com.ams.admin.pojo.vo.SysMenuSelectVO;
import com.ams.admin.pojo.vo.SysMenuVO;
import com.ams.admin.pojo.vo.SysUserVO;
import com.ams.common.entity.APage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author：whisper
 * @date： 2021/11/24
 * @description：
 * @modifiedBy：
 * @version: 1.0
 */
public interface ISysMenuService extends IService<SysMenu> {


    /**
     * 获取菜单列表
     * @return
     */
    List<SysMenuVO> loadMenus();

    /**
     * 创建菜单
     * @param req
     */
    void createMenu(SaveMenuReq req);

    /**
     * 菜单树
     * @return
     */
    List<SysMenuVO> lisTree();

    /**
     * 更新菜单
     * @param req
     */
    void updateMenu(SaveMenuReq req);

    /**
     * 批量删除菜单
     * @param ids
     */
    void deletes(List<Long> ids);

    /**
     * 获取菜单select
     * @return
     */
    List<SysMenuSelectVO> select(int status);

    /**
     * 查询菜单详情
     * @param id
     * @return
     */
    SysMenuVO getDetail(Long id);

    /**
     * 查询角色绑定的菜单
     * @param roleId
     * @return
     */
    List<Long> listRoleMenu(Long roleId);

    /**
     * 更新角色绑定的菜单
     * @param roleId
     * @param req
     */
    void updateRoleMenu(Long roleId, CommonReq req);

    /**
     * 获取当前用户绑定的菜单
     * @return
     */
    List<Long> currentUser();
}
