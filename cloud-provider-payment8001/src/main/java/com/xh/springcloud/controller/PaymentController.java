package com.xh.springcloud.controller;

import com.xh.springcloud.domain.Payment;
import com.xh.springcloud.service.PaymentService;
import com.xh.springcloud.util.ResultJSON;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @GetMapping("/getPayment/{id}")
    public ResultJSON<Payment> getPayment(@PathVariable("id") Long id){
        return paymentService.findPaymentById(id);
    }

    @PostMapping("/create")
    public ResultJSON<Payment> createPayment(@RequestBody Payment payment){
        return paymentService.insertPayment(payment);
    }
}
