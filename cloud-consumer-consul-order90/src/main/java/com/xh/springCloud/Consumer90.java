package com.xh.springCloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Consumer90 {
    public static void main(String[] args) {
        SpringApplication.run(Consumer90.class);
    }
}
