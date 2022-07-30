package com.ams.admin.service;


import com.ams.admin.dto.UserAuthDTO;
import com.ams.admin.pojo.entity.SysUser;
import com.ams.admin.pojo.req.SaveUserReq;
import com.ams.admin.pojo.req.UserListPageReq;
import com.ams.admin.pojo.vo.SysUserVO;
import com.ams.common.entity.APage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
public interface ISysUserService extends IService<SysUser> {


    /**
     * 根据用户名获取认证用户信息，携带角色和密码
     *
     * @param username
     * @return
     */
    UserAuthDTO getByUsername(String username);

    /**
     * 创建用户
     * @param req
     */
    void createUser(SaveUserReq req);

    /**
     * 用户详情
     * @param userId
     * @return
     */
    SysUserVO userDetail(Long userId);

    /**
     * 更新用户信息
     * @param userReq
     * @param userId
     */
    void updateUserInfo(SaveUserReq userReq, Long userId);

    /**
     * 批量删除用户
     * @param userIds
     */
    void mulDeleteUsers(List<Long> userIds);

    /**
     * 用户列表分页
     * @param req
     */
    APage<SysUserVO> listPage(UserListPageReq req);



    /**
     * 更新用户状态
     */
    void updateStatus(Long userId, Integer status);

    /**
     * 获取当前用户信息
     * @return
     */
    SysUserVO currentInfocurrentInfo();

    /**
     * 查询用户绑定的角色
     * @param userId 角色id
     * @return long
     */
    List<Long> selectUserRole(Long userId);



}
