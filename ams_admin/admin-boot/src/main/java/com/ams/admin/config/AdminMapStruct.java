package com.ams.admin.config;

import com.ams.admin.pojo.entity.SysPermission;
import com.ams.admin.pojo.entity.SysRole;
import com.ams.admin.pojo.entity.SysUser;
import com.ams.admin.pojo.vo.SysPermissionVO;
import com.ams.admin.pojo.vo.SysRoleSelectVO;
import com.ams.admin.pojo.vo.SysRoleVO;
import com.ams.admin.pojo.vo.SysUserVO;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @Author: xr
 * @Date: 2022-07-10-14:10
 * @Description:
 */
@Mapper(componentModel = "spring")
public interface AdminMapStruct {
    List<SysRoleVO> sysRoleToSysRoleVO(List<SysRole> sysRole) ;
    List<SysRoleSelectVO> sysRoleToSysRoleSelectVO(List<SysRole> sysRole) ;
    List<SysUserVO> sysUserToSysUserVO(List<SysUser> sysUsers) ;
    List<SysPermissionVO> sysPermissionToPermissionVO(List<SysPermission> sysPermissions);
}
