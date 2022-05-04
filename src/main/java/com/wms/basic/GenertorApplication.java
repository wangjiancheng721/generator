package com.wms.basic;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.wms.basic")
@MapperScan("com.wms.basic.mapper")
public class GenertorApplication {

    public static void main(String[] args) {
        SpringApplication.run(GenertorApplication.class, args);
    }

}
