package com.ams.admin.service;


import com.ams.admin.dto.UserAuthDTO;
import com.ams.admin.pojo.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;
/**
 * Created with IntelliJ IDEA.
 *
 * @author： AI码师 关注公众号"AI码师"获取完整源码
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

}
