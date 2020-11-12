package com.jwt.controller;



import com.baomidou.mybatisplus.plugins.Page;
import com.jwt.domain.User;
import com.jwt.mapper.UserMapper;
import com.jwt.utils.JwtUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
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


    @GetMapping("login")
    public String login(User user){
        String realPassword = userMapper.getPassword(user.getName());
        if (realPassword == null) {
            return "用户名错误";
        } else if (!realPassword.equals(user.getPassword())) {
            return "密码错误";
        } else {
            return JwtUtils.sign(user.getName(),"123");
        }

    }



}
