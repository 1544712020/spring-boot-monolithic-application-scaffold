package com.lwz.scaffold.entity;

import com.lwz.scaffold.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 用户表继承了UserDetails
 * @author Lw中
 * @date 2020/8/26 11:48
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable, UserDetails {

    private Integer id;
    private String username;
    private String password;
    private boolean accountNonExpired;
    private int accountNonExpired1;
    private boolean accountNonLocked;
    private int accountNonLocked1;
    private boolean credentialsNonExpired;
    private int credentialsNonExpired1;
    private boolean enabled;
    private int enabled1;
    private String token;
    private List<Role> roles;

    /**
     * 返回用户角色信息
     * @return
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        // 循环遍历用户角色
        for (Role role : getRoles()) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        /** 账户是否没有过期 */
        return accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        /** 账户是否没有被锁定 */
        return accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        /** 密码是否没有过期 */
        return credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        /** 该账户是否可用 */
        return enabled;
    }
}
