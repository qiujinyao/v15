package com.qianfeng.v15productservice;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
@MapperScan("com.qianfeng.mapper")
public class V15ProductServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(V15ProductServiceApplication.class, args);
    }

}
