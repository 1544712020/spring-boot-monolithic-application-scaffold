package com.lwz.scaffold.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lwz.scaffold.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Mapper接口类要继承BaseMapper
 * @author Lw中
 * @date 2020/8/26 13:54
 */

@Mapper
public interface RoleMapper extends BaseMapper<Role> {

    /**
     * 通过中间表给用户添加角色
     * @param roles
     * @param uid
     * @return
     */
    public int addUserRole(@Param("uid") int uid, @Param("roles") String[] roles);

    /**
     * 给角色表添加角色信息
     * @param role
     * @return
     */
    public int addRoles(Role role);

    /**
     * 通过用户id获取用户的角色
     * @param uid
     * @return
     */
    List<Role> getRolesByUid(int uid);



}
