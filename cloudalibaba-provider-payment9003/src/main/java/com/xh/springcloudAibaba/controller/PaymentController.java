package com.xh.springcloudAibaba.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    //模拟数据库
    public static HashMap<Long,String> hashMap = new HashMap<>();

    static {
        hashMap.put(1L,"28a8c1e3bc2742d8848569891fb42181");
        hashMap.put(2L,"bba8c1e3bc2742d8848569891ac32182");
        hashMap.put(3L,"6ua8c1e3bc2742d8848569891xt92183");
    }

    @GetMapping(value = "/paymentSQL/{id}")
    public String paymentSQL(@PathVariable("id") Long id) {
        return hashMap.get(id) +"端口号："+ serverPort;
    }
}
