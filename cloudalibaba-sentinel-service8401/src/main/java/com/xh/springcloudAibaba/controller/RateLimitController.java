package com.xh.springcloudAibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.xh.springcloudAibaba.handler.CustomerBlockHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class RateLimitController {

    @GetMapping("/rateLimit/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler",
            //去CustomerBlockHandler下找handlerException方法进行限流处理
            blockHandlerClass = CustomerBlockHandler.class,
            blockHandler = "handlerException")
    public String customerBlockHandler(Integer id) {
        return "自定义限流测试";
    }

    @GetMapping("/byResource")
    @SentinelResource(value = "byResource",blockHandler = "handleException")
    public String byResource() {
        return "按资源名称限流测试OK";
    }

    @GetMapping("/rateLimit/byUrl")
    @SentinelResource(value = "byUrl",blockHandler = "handleException")
    public String byUrl() {
        return "按URL限流测试OK";
    }

    public String handleException(BlockException exception) {
        return exception.getClass().getCanonicalName()+"\t 服务不可用";
    }
}
