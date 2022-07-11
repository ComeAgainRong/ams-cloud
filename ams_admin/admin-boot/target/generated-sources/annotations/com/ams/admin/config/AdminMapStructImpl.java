package com.ams.admin.config;

import com.ams.admin.pojo.entity.SysRole;
import com.ams.admin.pojo.entity.SysUser;
import com.ams.admin.pojo.vo.SysRoleVO;
import com.ams.admin.pojo.vo.SysUserVO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-11T00:42:21+0800",
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

    protected SysRoleVO sysRoleToSysRoleVO1(SysRole sysRole) {
        if ( sysRole == null ) {
            return null;
        }

        SysRoleVO sysRoleVO = new SysRoleVO();

        sysRoleVO.setId( sysRole.getId() );
        sysRoleVO.setName( sysRole.getName() );

        return sysRoleVO;
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
}
