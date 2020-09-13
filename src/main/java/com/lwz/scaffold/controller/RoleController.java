package com.lwz.scaffold.controller;

import com.lwz.scaffold.entity.Role;
import com.lwz.scaffold.entity.RoleVo;
import com.lwz.scaffold.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Lw中
 * @date 2020/9/13 16:10
 */

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    RoleService roleService;

    /**
     * 新增角色种类
     * @param role
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public int addRole(Role role) {
        int i = roleService.addRoles(role);
        return i;
    }

    /**
     * 根据用户id获取用户角色
     * @param uid
     * @return
     */
    @RequestMapping(value = "/{uid}", method = RequestMethod.GET)
    public List<Role> getRolesByUid(@PathVariable("uid") int uid) {
        List<Role> roles = roleService.getRolesByUid(uid);
        return roles;
    }

    /**
     * 根据用户id为用户添加角色
     * @param uid
     * @param roles
     * @return
     */
    @RequestMapping(value = "/{uid}", method = RequestMethod.POST)
    public int addRolesByUid(@PathVariable("uid") int uid, String[] roles) {
        int i = roleService.addUserRole(uid, roles);
        return i;
    }

    /**
     * mybatisPlus提供的删除角色方法接口
     * @param rid
     * @return
     */
    @RequestMapping(value = "/{rid}", method = RequestMethod.DELETE)
    public int deleteRole(@PathVariable("rid") int rid) {
        int i = roleService.deleteRoleById(rid);
        return i;
    }

    /**
     * mybatisPlus提供的分页查询方法接口
     * @param current
     * @param size
     * @return
     */
    @RequestMapping(value = "/roleList/{current}/{size}", method = RequestMethod.GET)
    public List<Role> queryListRole(@PathVariable("current") int current, @PathVariable("size") int size) {
        RoleVo roleVo = roleService.queryList(current, size);
        List<Role> roleList = roleVo.getRoleList();
        return roleList;
    }

}
