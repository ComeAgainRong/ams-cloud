package com.ams.admin.service;


import com.ams.admin.dto.UserAuthDTO;
import com.ams.admin.pojo.entity.SysRole;
import com.ams.admin.pojo.entity.SysUser;
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
public interface ISysRoleService extends IService<SysRole> {


    /**
     * 角色列表
     * @return
     */
    List<SysRoleVO> roleSelect();
}
