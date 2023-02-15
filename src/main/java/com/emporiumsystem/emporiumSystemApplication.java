package com.emporiumsystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableCaching
@EnableTransactionManagement
@MapperScan("com.emporiumsystem.dao")
public class emporiumSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(emporiumSystemApplication.class, args);
    }

}
