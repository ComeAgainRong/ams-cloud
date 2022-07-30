package com.ams.admin.service;

import com.ams.admin.pojo.entity.SysPermission;
import com.ams.admin.pojo.req.CommonReq;
import com.ams.admin.pojo.req.SavePermissionReq;
import com.ams.admin.pojo.vo.SysPermissionVO;
import com.ams.admin.pojo.vo.SysServiceVO;
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
public interface ISysPermissionService extends IService<SysPermission> {
    /**
     * 刷新Redis缓存中角色菜单的权限规则，角色和菜单信息变更调用
     */
    boolean refreshPermRolesRules();

    List<SysPermission> listPermRoles();

    /**
     * 获取权限列表
     * @param menuId
     * @return
     */
    List<SysPermissionVO> listByMenuId(Long menuId);

    /**
     * 创建权限
     * @param req
     */
    void createPermission(SavePermissionReq req);

    /**
     * 更新权限信息
     * @param req
     */
    void updatePermission(SavePermissionReq req);

    /**
     * 获取所有服务
     * @return
     */
    List<SysServiceVO> getService();

    /**
     * 删除权限
     * @param ids
     */
    void detelePermission(List<Long> ids);

    /**
     * 查询角色绑定的权限
     * @param roleId
     * @return
     */
    List<Long> listRolePermission(Long roleId);


}
