package com.hxscpro.controller;

import com.hxscpro.bean.User;
import com.hxscpro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Scope("prototype")
public class UserController {
    @Autowired
    private UserService userService;

    @ResponseBody
    @GetMapping("/test")
    public User hello() {
        System.out.printf("test");
        User user = this.userService.queryById(1);
        return user;
    }

    @GetMapping("/all")
    @ResponseBody
    public List<User> all(ModelMap model) {
        System.out.printf("all");
        // 查询用户
        List<User> users = this.userService.queryUsers();
        // 放入模型
        model.addAttribute("users", users);
        // 返回模板名称（就是classpath:/templates/目录下的html文件名）
        return users;
    }
}
