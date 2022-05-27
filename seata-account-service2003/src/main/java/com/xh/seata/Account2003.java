package com.xh.seata;

import io.seata.spring.annotation.datasource.EnableAutoDataSourceProxy;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.xh.seata.dao")
@EnableAutoDataSourceProxy
public class Account2003 {
    public static void main(String[] args) {
        SpringApplication.run(Account2003.class);
    }
}
