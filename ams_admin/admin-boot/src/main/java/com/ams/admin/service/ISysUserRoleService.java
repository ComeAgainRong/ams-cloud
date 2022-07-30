package com.ams.admin.service;


import com.ams.admin.pojo.entity.SysRole;
import com.ams.admin.pojo.entity.SysUserRole;
import com.ams.admin.pojo.vo.SysRoleVO;
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
public interface ISysUserRoleService extends IService<SysUserRole> {


    /**
     * 获取用户绑定的角色Id
     * @param userId
     * @return
     */
    List<Long> selectRoleIds(Long userId);


    /**
     * 删除该用户绑定的角色
     */
     void  deleteByUserId(Long userId);
}
