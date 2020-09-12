package com.lwz.scaffold;

//import com.baomidou.mybatisplus.core.metadata.IPage;
//import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lwz.scaffold.entity.Role;
import com.lwz.scaffold.entity.RoleVo;
import com.lwz.scaffold.service.RoleService;
import com.lwz.scaffold.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

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

//    @Test
//    public void testUser() {
//        User lwz = userService.findUserByUsername("lwz");
//        System.out.println(lwz.getUsername());
//    }

    @Test
    public void testRole() {
        List<Role> roles = roleService.getRolesByUid(10);
        System.out.println(roles.get(0));
//        // 测试mybatisPlus提供的删除方法
//        int i = roleService.deleteRoleById(3);
//        System.out.println(i);
//        // 测试mybatisPlus提供的分页查询方法
//        RoleVo roleVo = roleService.queryList(0, 2);
//        List<Role> roleList = roleVo.getRoleList();
//        for (int j = 0; j < roleList.size(); j++) {
//            System.out.println(roleList.get(j));
//        }
    }

}
