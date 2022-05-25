package com.xh.springcloudAibaba.service;

import com.xh.springcloudAibaba.service.impl.PaymentServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "nacos-payment-provider",fallback = PaymentServiceImpl.class)
public interface PaymentService {

    @GetMapping("/paymentSQL/{id}")
    String paymentSQL(@PathVariable("id") Long id);

}
