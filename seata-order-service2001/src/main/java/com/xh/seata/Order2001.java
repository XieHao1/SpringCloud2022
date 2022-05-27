package com.xh.seata;

import io.seata.spring.annotation.datasource.EnableAutoDataSourceProxy;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@MapperScan("com.xh.seata.dao")
//seata1.1版本后使用注解开启DataSourceProxy,
//之前版本需要手动写DataSourceProxy配置使seata管理数据库
@EnableAutoDataSourceProxy
public class Order2001 {
    public static void main(String[] args) {
        SpringApplication.run(Order2001.class);
    }
}
