package com.ams.auth.security.details.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * @ClassName : { user }
 * @Author : {whisper}
 * @Date : {Created in 15:23 2022/1/29}
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SysUserDetails implements UserDetails {

    private  Long userId;//扩展字段
    private String username;//用户名
    private String password;//密码
    private Boolean enabled;//是否启用
    private Collection<SimpleGrantedAuthority> authorities;//用户角色权限

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }
}
