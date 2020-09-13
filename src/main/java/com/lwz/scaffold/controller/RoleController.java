package com.lwz.scaffold.controller;

import com.lwz.scaffold.entity.Role;
import com.lwz.scaffold.entity.RoleVo;
import com.lwz.scaffold.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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

@Api("用户角色接口")
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
    @ApiOperation(value = "添加角色类型")
    @ApiImplicitParam(name = "role", value = "角色实体类")
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
    @ApiOperation(value = "删除角色类型")
    @ApiImplicitParam(name = "uid", value = "用户id")
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
    @ApiOperation(value = "为用户添加角色类型")
    @ApiImplicitParam(name = "uid", value = "用户id")
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
    @ApiOperation(value = "删除角色类型", notes = "mybatisPlus提供的删除角色方法接口")
    @ApiImplicitParam(name = "rid", value = "角色id")
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
    @ApiOperation(value = "分页查询角色类型", notes = "mybatisPlus提供的分页查询方法接口")
    @ApiImplicitParams({@ApiImplicitParam(name = "current", value = "当前页数"), @ApiImplicitParam(name = "size", value = "每页显示信息条数")})
    @RequestMapping(value = "/roleList/{current}/{size}", method = RequestMethod.GET)
    public List<Role> queryListRole(@PathVariable("current") int current, @PathVariable("size") int size) {
        RoleVo roleVo = roleService.queryList(current, size);
        List<Role> roleList = roleVo.getRoleList();
        return roleList;
    }

}
