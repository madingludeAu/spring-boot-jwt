package com.jwt;


import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication

public class JwtAutoApplication {

    private static Logger logger = LoggerFactory.getLogger(JwtAutoApplication.class);

    public static void main(String[] args) {
        logger.info("正在启动。。。。。");
        SpringApplication.run(JwtAutoApplication.class);
        logger.info("===================运行中===================");
    }
}
