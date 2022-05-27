package com.xh.seata;

import io.seata.spring.annotation.datasource.EnableAutoDataSourceProxy;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableAutoDataSourceProxy
@MapperScan("com.xh.seata.dao")
public class Storage2002 {
    public static void main(String[] args) {
        SpringApplication.run(Storage2002.class);
    }
}
