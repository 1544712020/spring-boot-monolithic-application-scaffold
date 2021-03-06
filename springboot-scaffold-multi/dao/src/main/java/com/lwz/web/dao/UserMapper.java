package com.lwz.web.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lwz.web.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Mapper接口类要继承BaseMapper
 * @author Lw中
 * @date 2020/8/26 13:24
 */

@Mapper
public interface UserMapper extends BaseMapper<User> {

    /**
     * 通过名字查询用户名称
     * @param username
     * @return
     */
    public User findUserByUsername(@Param("username") String username);

    /**
     * 添加用户
     * 当传入的参数是对象时，不用@Param注解
     * @param user
     * @return
     */
    public int addUser(User user);

    /**
     * 查询所有用户
     * @return
     */
    public List<User> findAll();

}
