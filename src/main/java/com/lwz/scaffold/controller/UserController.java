package com.lwz.scaffold.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lwz.scaffold.entity.User;
import com.lwz.scaffold.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Lw中
 * @date 2020/9/11 19:56
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/getAllUsers")
    public List<User> getAllUsers() {
        //  创建Page对象，将page，limit参数传入，必须位于从数据库查询数据的语句之前，否则不生效
        Page page= PageHelper.startPage(2, 2);
        //  ASC是根据id 正向排序，DESC是反向排序
        PageHelper.orderBy("id ASC");
        // 从数据库查询，这里返回的的allUser就已经分页成功了
        List<User> allUser = userService.findAll();
        // 获取查询记录总数，必须位于从数据库查询数据的语句之后，否则不生效
        long total = page.getTotal();
        System.out.println(total);
        return allUser;
    }

}
