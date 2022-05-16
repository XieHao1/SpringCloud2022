package com.xh.springcloud.service;

import com.xh.springcloud.domain.Payment;
import com.xh.springcloud.util.ResultJSON;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
//指定微服务的名称
public interface PaymentFeignService {

    String REQUEST_PREFIX = "/payment";

    @GetMapping(REQUEST_PREFIX+"/getPayment/{id}")
    ResultJSON<Payment> getPaymentById(@PathVariable("id") Long id);

    @GetMapping(REQUEST_PREFIX+"/feign/timeout")
    String paymentTimeout();
}
