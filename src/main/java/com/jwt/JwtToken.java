package com.jwt;

import org.apache.shiro.authc.AuthenticationToken;


public class JwtToken implements AuthenticationToken {


    // 密钥
    private String token;

    public JwtToken(String token) {
        this.token = token;
    }


    public Object getPrincipal() {
        return null;
    }

    public Object getCredentials() {
        return null;
    }
}
