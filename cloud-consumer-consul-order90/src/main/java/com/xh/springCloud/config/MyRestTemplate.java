package com.xh.springCloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
//在这里配置我们自定义的LoadBalancer策略 如果想自己扩展算法 需要实现ReactorServiceInstanceLoadBalancer接口
//@LoadBalancerClients(defaultConfiguration = {name = "CLOUD-PAYMENT-SERVICE", configuration = LoadBalanceConfig.class})
//注意这里的name属性需要和Rest中的服务提供者名字一直 此时Rest中是大写
@LoadBalancerClient(name = "CLOUD-PAYMENT-SERVICE",configuration = LoadBalanceConfig.class)
public class MyRestTemplate {

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
