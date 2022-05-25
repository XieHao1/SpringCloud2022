package com.xh.springcloudAibaba.service.impl;

import com.xh.springcloudAibaba.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class PaymentServiceImpl implements PaymentService {

    @Override
    public String paymentSQL(Long id) {
        log.info("openFeign服务降级");
        return null;
    }
}
