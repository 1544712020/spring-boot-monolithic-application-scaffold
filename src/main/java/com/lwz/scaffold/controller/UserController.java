package com.lwz.scaffold.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lwz.scaffold.entity.User;
import com.lwz.scaffold.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Lw中
 * @date 2020/9/11 19:56
 */

@Api("用户接口")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 分页插件分页查询接口
     * @return
     */
    @ApiOperation(value = "分页查询用户数据", notes = "使用PageHelper插件完成分页程查询")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<User> getAllUsers() {
        //  创建Page对象，将page，limit参数传入，必须位于从数据库查询数据的语句之前，否则不生效
        Page page= PageHelper.startPage(1, 2);
        //  ASC是根据id 正向排序，DESC是反向排序
        PageHelper.orderBy("id ASC");
        // 从数据库查询，这里返回的的allUser就已经分页成功了
        List<User> allUser = userService.findAll();
        // 获取查询记录总数，必须位于从数据库查询数据的语句之后，否则不生效
        long total = page.getTotal();
        System.out.println(total);
        /**
         * LWZ TODO : 2020/9/13 pageHelper
         * 分页查询返回时报错
         */
        return allUser;
    }

    /**
     * 通过用户名查询用户信息
     * @param username
     * @return
     */
    @ApiOperation(value = "查询用户信息")
    @ApiImplicitParam(name = "username", value = "用户姓名")
    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public User findUser(@PathVariable("username") String username) {
        User user = userService.findUserByUsername(username);
        return user;
    }

    /**
     * 添加用户
     * @param user
     * @return
     */
    @ApiOperation(value = "添加用户")
    @ApiImplicitParam(name = "user", value = "用户实体类")
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public int addUser(User user) {
        int i = userService.addUser(user);
        return i;
    }

}
