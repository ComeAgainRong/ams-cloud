package com.ams.admin.service;


import com.ams.admin.pojo.entity.SysRoleMenu;
import com.ams.admin.pojo.entity.SysRolePermission;
import com.ams.admin.pojo.req.CommonReq;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * Created with IntelliJ IDEA.
 *
 * @author： whisper
 * @date： 2021/11/24
 * @description：
 * @modifiedBy：
 * @version: 1.0
 */
public interface ISysRolePermissionService extends IService<SysRolePermission> {


    /**
     * 更新角色绑定的权限
     * @param roleId
     * @param req
     */
    void updateRolePermission(Long roleId, CommonReq req);
}
