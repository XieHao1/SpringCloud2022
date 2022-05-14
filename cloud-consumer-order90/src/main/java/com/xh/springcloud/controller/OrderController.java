package com.xh.springcloud.controller;

import com.xh.springcloud.domain.Payment;
import com.xh.springcloud.util.ResultJSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping("/consumer")
public class OrderController {

    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/payment/get/{id}")
    public ResultJSON<Payment> getPayment(@PathVariable("id") Long id) {
        log.info("id:{}",id);
        return restTemplate.getForObject(PAYMENT_URL+"/payment/getPayment/"+id,ResultJSON.class);
    }

    @GetMapping("/payment/create")
    public ResultJSON<Payment> create(Payment payment){
        log.info("id:{},serial:{}",payment.getId(),payment.getSerial());
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,ResultJSON.class);
    }
}
