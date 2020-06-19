package com.xkcoding.spring.security.componet;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * @ClassName Users
 * @Description TODO
 * @Author 钱进
 * @Date 2020/6/18 18:18
 * @Version 1.0
 **/
@Data
public class User implements UserDetails {

    private Long id;
    private String username;
    private String password;
    private String roles;
    private Boolean disabled;

    private List<GrantedAuthority> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
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
        return !this.disabled;
    }
}
