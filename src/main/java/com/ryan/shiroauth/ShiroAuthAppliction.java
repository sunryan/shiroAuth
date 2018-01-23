package com.ryan.shiroauth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author lr
 * @date 2018/1/23
 */
@SpringBootApplication
@MapperScan(basePackages = "com.ryan.shiroauth.mapper")
public class ShiroAuthAppliction {
    
    public static void main(String[] args) {
        SpringApplication.run(ShiroAuthAppliction.class, args);
    }
}
