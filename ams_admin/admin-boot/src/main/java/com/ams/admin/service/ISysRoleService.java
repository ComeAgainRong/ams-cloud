package com.ams.admin.service;


import com.ams.admin.dto.UserAuthDTO;
import com.ams.admin.pojo.entity.SysRole;
import com.ams.admin.pojo.entity.SysUser;
import com.ams.admin.pojo.req.RoleListPageReq;
import com.ams.admin.pojo.req.SaveSysRoleReq;
import com.ams.admin.pojo.vo.SysRoleSelectVO;
import com.ams.admin.pojo.vo.SysRoleVO;
import com.ams.common.entity.APage;
import com.baomidou.mybatisplus.extension.service.IService;

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
public interface ISysRoleService extends IService<SysRole> {


    /**
     * 角色列表
     * @return
     */
    List<SysRoleSelectVO> roleSelect();


    /**
     * 列表分页
     * @param req
     * @return
     */
    APage<SysRoleVO> listPage(RoleListPageReq req);

    /**
     * 创建角色
     * @param req
     */
    void createRole(SaveSysRoleReq req);

    /**
     * 更新角色
     * @param req
     */
    void updateRole(SaveSysRoleReq req);

    /**
     * 删除角色
     * @param ids
     */
    void deleteRole(List<Long> ids);

    /**
     * 更新用户状态
     * @param id
     * @param status
     */
    void updateRoleStatus(Long id, Long status);

}
