package com.xh.springcloud.controller;

import com.xh.springcloud.domain.Payment;
import com.xh.springcloud.service.PaymentService;
import com.xh.springcloud.util.ResultJSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private PaymentService paymentService;

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
