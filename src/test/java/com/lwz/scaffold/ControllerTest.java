package com.lwz.scaffold;

import com.lwz.scaffold.dao.UserMapper;
import com.lwz.scaffold.entity.User;
import com.lwz.scaffold.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Lw中
 * @date 2020/9/13 17:26
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class ControllerTest {

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserService userService;

    @Test
    public void testAddUser() {
//        User user = new User();
//        user.setUsername("李清照");
//        user.setPassword("123");
//        int i = userService.addUser(user);
//        System.out.println(i);
        User user = userService.findUserByUsername("李清照");
        System.out.println(user.getUsername());
    }

}
