package com.jwt.config;


import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@Configuration
public class MybatisPageConfig {



    @Bean
    public PaginationInterceptor paginationInterceptor() {

          return new PaginationInterceptor();

    }
}
