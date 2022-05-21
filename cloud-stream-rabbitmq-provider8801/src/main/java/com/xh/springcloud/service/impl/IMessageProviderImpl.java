package com.xh.springcloud.service.impl;

import com.xh.springcloud.service.IMessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.UUID;

//@EnableBinding(Source.class)
//生产放使用Source
//定义消息的推送管道
@Slf4j
@Component
public class IMessageProviderImpl implements IMessageProvider {

//    @Resource
//    //output为yml文件中bindings的通道名字
//    private MessageChannel output;//消息发送管道

    @Resource
    private StreamBridge streamBridge;

    @Override
    public String send() {
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        //发送消息  messaging.support.MessageBuilder
        //output.send(MessageBuilder.withPayload(uuid).build());

        //StreamBridge的send方法第一个参数是binding的名字，第二个参数是想要发送的消息
        streamBridge.send("myChannel-out-1",MessageBuilder.withPayload(uuid).build());
        log.info("uuid:{}",uuid);
        return uuid;
    }
}
