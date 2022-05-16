package com.xh.springcloud.controller;

import com.xh.springcloud.domain.Payment;
import com.xh.springcloud.service.PaymentFeignService;
import com.xh.springcloud.util.ResultJSON;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("/payment/get/{id}")
    public ResultJSON<Payment> getPaymentById(@PathVariable("id") Long id){
        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping("/payment/timeout")
    public String paymentTimeout(){
        //openFeign默认等待1秒钟,超过1秒后报错
        return paymentFeignService.paymentTimeout();
    }
}
