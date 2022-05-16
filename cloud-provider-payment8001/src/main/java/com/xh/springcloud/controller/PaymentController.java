package com.xh.springcloud.controller;

import com.xh.springcloud.domain.Payment;
import com.xh.springcloud.service.PaymentService;
import com.xh.springcloud.util.ResultJSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @Resource
    private PaymentService paymentService;

    @GetMapping("/feign/timeout")
    public String paymentTimeout(){
        //设置该接口睡眠3秒
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }

    @GetMapping("/discovery")
    public Object discovery(){
        //获取服务列表信息
        List<String> services = discoveryClient.getServices();
        for (String msg : services){
            log.info("service:{}",msg);
        }
        //通过微服务的名称获取
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance serviceInstance:instances){
            log.info(serviceInstance.getServiceId()+"\t"+serviceInstance.getHost()+"\t"+serviceInstance.getPort()+"\t"+serviceInstance.getUri());
        }
        return this.discoveryClient;
    }

    @GetMapping("/getPayment/{id}")
    public ResultJSON<Payment> getPayment(@PathVariable("id") Long id){
        log.info("serverPort:{}",serverPort);
        return paymentService.findPaymentById(id);
    }

    @PostMapping("/create")
    public ResultJSON<Payment> createPayment(@RequestBody Payment payment){
        return paymentService.insertPayment(payment);
    }
}
