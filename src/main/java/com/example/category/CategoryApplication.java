package com.example.category;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.category.mapper")
public class CategoryApplication {

    public static void main(String[] args) {
        SpringApplication.run( CategoryApplication.class, args );
    }

}
