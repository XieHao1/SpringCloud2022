package com.xh.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
//@EnableBinding(Sink.class)
@Slf4j
public class ReceiveMessageListener{

    @Value("${server.port}")
    private String serverPort;

//    @StreamListener(Sink.INPUT)
//    public void input(Message<String> message){
//      log.info("消费者:{},接收到的消息:{}",serverPort,message.getPayload());
//    }

    @Bean
    public Consumer<String> myChannel(){
        return message -> log.info("消费者:{},接收到的消息:{}",serverPort,message);
    }
}
