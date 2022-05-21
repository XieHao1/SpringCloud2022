package com.xh.springcloud.controller;

import com.xh.springcloud.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class SendMessageController {

    @Resource
    private IMessageProvider iMessageProvider;

    @GetMapping("/send")
    public String sendMassage(){
       return iMessageProvider.send();
    }
}
