package com.lwz.scaffold.service;

import com.lwz.scaffold.dao.RoleMapper;
import com.lwz.scaffold.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Lw中
 * @date 2020/9/2 11:15
 */

@Service("roleService")
public class RoleService {

    @Autowired
    RoleMapper roleMapper;

    /**
     *
     * @param role
     * @return
     */
    public int addRoles(Role role) {
        int i = roleMapper.addRoles(role);
        return i;
    }

    /**
     *
     * @param uid
     * @return
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
    public List<Role> getRolesByUid(int uid) {
        List<Role> roles = roleMapper.getRolesByUid(uid);
        return roles;
    }

    /**
     *
     * @param uid
     * @param roles
     * @return
     */
    public int addUserRole(int uid, String[] roles) {
        int i = roleMapper.addUserRole(uid, roles);
        return i;
    }

}
