package com.xh.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;


@SpringBootApplication
//开启Hystrix可视化界面注解
@EnableHystrixDashboard
public class DashBoard9001 {
    public static void main(String[] args) {
        SpringApplication.run(DashBoard9001.class);
    }
}
