package com.lwz.scaffold.entity;

import com.lwz.scaffold.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 用户表继承了UserDetails
 * @author Lw中
 * @date 2020/8/26 11:48
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

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

}
