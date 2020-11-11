package com.jwt.domain;


import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

@TableName("sys_user")
public class User implements Serializable {


    private static final long serialVersionUID = -715047719112967273L;
    private String name;
    private String password;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
