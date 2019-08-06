package com.qianfeng.v15productweb;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
public class V15ProductWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(V15ProductWebApplication.class, args);
    }

}
