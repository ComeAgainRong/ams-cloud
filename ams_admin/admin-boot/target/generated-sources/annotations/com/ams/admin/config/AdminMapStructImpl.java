package com.ams.admin.config;

import com.ams.admin.pojo.entity.SysPermission;
import com.ams.admin.pojo.entity.SysRole;
import com.ams.admin.pojo.entity.SysUser;
import com.ams.admin.pojo.vo.SysPermissionVO;
import com.ams.admin.pojo.vo.SysRoleSelectVO;
import com.ams.admin.pojo.vo.SysRoleVO;
import com.ams.admin.pojo.vo.SysUserVO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-28T18:35:59+0800",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 1.8.0_202 (Oracle Corporation)"
)
@Component
public class AdminMapStructImpl implements AdminMapStruct {

    @Override
    public List<SysRoleVO> sysRoleToSysRoleVO(List<SysRole> sysRole) {
        if ( sysRole == null ) {
            return null;
        }

        List<SysRoleVO> list = new ArrayList<SysRoleVO>( sysRole.size() );
        for ( SysRole sysRole1 : sysRole ) {
            list.add( sysRoleToSysRoleVO1( sysRole1 ) );
        }

        return list;
    }

    @Override
    public List<SysRoleSelectVO> sysRoleToSysRoleSelectVO(List<SysRole> sysRole) {
        if ( sysRole == null ) {
            return null;
        }

        List<SysRoleSelectVO> list = new ArrayList<SysRoleSelectVO>( sysRole.size() );
        for ( SysRole sysRole1 : sysRole ) {
            list.add( sysRoleToSysRoleSelectVO1( sysRole1 ) );
        }

        return list;
    }

    @Override
    public List<SysUserVO> sysUserToSysUserVO(List<SysUser> sysUsers) {
        if ( sysUsers == null ) {
            return null;
        }

        List<SysUserVO> list = new ArrayList<SysUserVO>( sysUsers.size() );
        for ( SysUser sysUser : sysUsers ) {
            list.add( sysUserToSysUserVO1( sysUser ) );
        }

        return list;
    }

    @Override
    public List<SysPermissionVO> sysPermissionToPermissionVO(List<SysPermission> sysPermissions) {
        if ( sysPermissions == null ) {
            return null;
        }

        List<SysPermissionVO> list = new ArrayList<SysPermissionVO>( sysPermissions.size() );
        for ( SysPermission sysPermission : sysPermissions ) {
            list.add( sysPermissionToSysPermissionVO( sysPermission ) );
        }

        return list;
    }

    protected SysRoleVO sysRoleToSysRoleVO1(SysRole sysRole) {
        if ( sysRole == null ) {
            return null;
        }

        SysRoleVO sysRoleVO = new SysRoleVO();

        sysRoleVO.setId( sysRole.getId() );
        sysRoleVO.setName( sysRole.getName() );
        sysRoleVO.setCode( sysRole.getCode() );
        sysRoleVO.setSort( sysRole.getSort() );
        sysRoleVO.setStatus( sysRole.getStatus() );
        sysRoleVO.setDeleted( sysRole.getDeleted() );

        return sysRoleVO;
    }

    protected SysRoleSelectVO sysRoleToSysRoleSelectVO1(SysRole sysRole) {
        if ( sysRole == null ) {
            return null;
        }

        SysRoleSelectVO sysRoleSelectVO = new SysRoleSelectVO();

        sysRoleSelectVO.setId( sysRole.getId() );
        sysRoleSelectVO.setName( sysRole.getName() );

        return sysRoleSelectVO;
    }

    protected SysUserVO sysUserToSysUserVO1(SysUser sysUser) {
        if ( sysUser == null ) {
            return null;
        }

        SysUserVO sysUserVO = new SysUserVO();

        sysUserVO.setId( sysUser.getId() );
        sysUserVO.setUsername( sysUser.getUsername() );
        sysUserVO.setNickname( sysUser.getNickname() );
        sysUserVO.setMobile( sysUser.getMobile() );
        sysUserVO.setGender( sysUser.getGender() );
        sysUserVO.setAvatar( sysUser.getAvatar() );
        sysUserVO.setEmail( sysUser.getEmail() );
        sysUserVO.setStatus( sysUser.getStatus() );
        List<Long> list = sysUser.getRoleIds();
        if ( list != null ) {
            sysUserVO.setRoleIds( new ArrayList<Long>( list ) );
        }

        return sysUserVO;
    }

    protected SysPermissionVO sysPermissionToSysPermissionVO(SysPermission sysPermission) {
        if ( sysPermission == null ) {
            return null;
        }

        SysPermissionVO sysPermissionVO = new SysPermissionVO();

        sysPermissionVO.setId( sysPermission.getId() );
        sysPermissionVO.setName( sysPermission.getName() );
        sysPermissionVO.setMenuId( sysPermission.getMenuId() );
        sysPermissionVO.setUrlPerm( sysPermission.getUrlPerm() );
        sysPermissionVO.setBtnSign( sysPermission.getBtnSign() );

        return sysPermissionVO;
    }
}
