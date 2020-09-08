package com.lwz.scaffold;

import com.lwz.scaffold.entity.User;
import com.lwz.scaffold.service.RoleService;
import com.lwz.scaffold.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * service层的单元测试
 * @author Lw中
 * @date 2020/9/8 20:36
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class ServiceTest {

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @Test
    public void testUser() {
        User lwz = userService.findUserByUsername("lwz");
        System.out.println(lwz.getUsername());
    }

//    @Test
//    public void testRole() {
//
//    }

}
