package com.jwt.controller;



import com.baomidou.mybatisplus.plugins.Page;
import com.jwt.domain.User;
import com.jwt.mapper.UserMapper;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @RequiresAuthentication
    @GetMapping("test")
    public List<User> test(){
        User user = new User();
        List<User> users = userMapper.selectPage(new Page<User>(1, 2), null);
        return users;
    }



}
