package com.xh.springcloud.service;


import org.springframework.stereotype.Component;

@Component
public class FeignServiceImpl implements FeignService {

    @Override
    public String paymentInfo_OK(Integer id) {
        //在这里进行服务降级
        return "-----PaymentFallbackService fall back-paymentInfo_OK ,o(╥﹏╥)o";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "-----PaymentFallbackService fall back-paymentInfo_TimeOut ,o(╥﹏╥)o";
    }
}
