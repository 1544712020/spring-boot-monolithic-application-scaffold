package com.lwz.scaffold.service;

import com.lwz.scaffold.dao.RoleMapper;
import com.lwz.scaffold.dao.UserMapper;
import com.lwz.scaffold.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Lw中
 * @date 2020/9/11 17:44
 */

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    RoleMapper roleMapper;

    /**
     * @Cacheable：表示该方法的返回结果需要缓存起来
     * #p0：表示传入的第一个参数作为redis的key
     * @param username
     * @return
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
    public User findUserByUsername(String username) {
        User user = userMapper.findUserByUsername(username);
        return user;
    }

    /**
     * @CachePut：无论结果是否已经缓存，都会在方法执行结束插入缓存
     * @param user
     * @return
     */
    public int addUser(User user) {
        String[] str = {"1"};
        int i1 = roleMapper.addUserRole(user.getId(), str);
        int i2 = userMapper.addUser(user);
        return i2;
    }

    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
    public List<User> findAll() {
        List<User> users = userMapper.findAll();
        return users;
    }

}
