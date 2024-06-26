package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.dapeng.dao.mapper")
@MapperScan("com.cjh.mqtt.mapper")
@SpringBootApplication
public class DaPengApplication {
    public static void main(String[] args) {
        SpringApplication.run(DaPengApplication.class, args);
    }
}
