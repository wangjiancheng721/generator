package com.wjc.generator;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = "com.wms.basic")
@MapperScan("com.wms.basic.mapper")
public class GenertorApplication {

    public static void main(String[] args) {
        SpringApplication.run(GenertorApplication.class, args);
    }

}
