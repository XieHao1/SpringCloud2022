package com.xh.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
//声明该模块为eureka的服务注册中心
@EnableEurekaServer
public class CloudEurekaServer7001 {

    public static void main(String[] args) {
        SpringApplication.run(CloudEurekaServer7001.class);
    }
}
