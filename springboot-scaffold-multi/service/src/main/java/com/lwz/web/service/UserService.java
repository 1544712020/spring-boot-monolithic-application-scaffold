package com.lwz.web.service;

import com.lwz.web.config.PasswordConfig;
import com.lwz.web.dao.RoleMapper;
import com.lwz.web.dao.UserMapper;
import com.lwz.web.entity.Role;
import com.lwz.web.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Lw中
 * @date 2020/9/11 17:44
 * @CacheConfig：缓存公共配置
 */

@CacheConfig(cacheNames = "users")
@Service
public class UserService implements UserDetailsService {

    @Autowired(required = false)
    UserMapper userMapper;

    @Autowired(required = false)
    RoleMapper roleMapper;

    // 密码配置器
    @Autowired
    PasswordConfig passwordConfig;

    /**
     * 该方法被configure方法里面auth.userDetailsService(userService)的参数
     * 会将用户传入的用户名获取
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 查询用户信息
        User user = userMapper.findUserByUsername(username);

        if (user.getAccountNonLocked1() ==1) {
            user.setAccountNonLocked(true);
        }
        if (user.getAccountNonExpired1() ==1) {
            user.setAccountNonExpired(true);
        }
        if (user.getEnabled1() ==1) {
            user.setEnabled(true);
        }
        if (user.getCredentialsNonExpired1() ==1) {
            user.setCredentialsNonExpired(true);
        }
        System.out.println(user.getUsername());
        if (user == null) {
            throw new UsernameNotFoundException("用户不存在");
        }

        // 获取用户的角色信息
        List<Role> roles = roleMapper.getRolesByUid(user.getId());
        user.setRoles(roles);

        // 返回用户信息
        return user;
    }

    /**
     * @Cacheable：表示该方法的返回结果需要缓存起来
     * #p0：表示传入的第一个参数作为redis的key（使用el表达式来指定key）
     * @param username
     * @return
     */
    @Cacheable(key = "#p0")
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
        User userByUsername = userMapper.findUserByUsername(user.getUsername());
        if (userByUsername != null) {
            return 0;
        }
        user.setPassword(passwordConfig.encode(user.getPassword()));
        user.setAccountNonExpired1(1);
        user.setAccountNonLocked1(1);
        user.setCredentialsNonExpired1(1);
        user.setEnabled1(1);
        int i = userMapper.addUser(user);
        System.out.println(user.getId()+user.getUsername());
        String[] str = {"1"};
        int i1 = roleMapper.addUserRole(user.getId(), str);
        if (i1 == i) {
            return i;
        } else {
            return 2;
        }
    }

    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
    public List<User> findAll() {
        List<User> users = userMapper.findAll();
        return users;
    }



}
