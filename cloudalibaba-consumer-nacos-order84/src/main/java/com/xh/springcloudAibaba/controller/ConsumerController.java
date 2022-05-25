package com.xh.springcloudAibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.xh.springcloudAibaba.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class ConsumerController {

    private static final String URL_PREFIX = "http://nacos-payment-provider";

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private PaymentService paymentService;

    @GetMapping("/consumer/openFeign/{id}")
    @SentinelResource(value = "fallback",fallback = "handlerFallback",blockHandler = "blockHandler")
    public String openFeign(@PathVariable("id") Long id){
        String result =paymentService.paymentSQL(id);
        if (id == 4) {
            throw new IllegalArgumentException ("IllegalArgumentException,非法参数异常....");
        }else if (result == null || result.contains("null")) {
            throw new NullPointerException ("NullPointerException,该ID没有对应记录,空指针异常");
        }
        return result;
    }

    @RequestMapping("/consumer/fallback/{id}")
    @SentinelResource(value = "fallback",fallback = "handlerFallback",blockHandler = "blockHandler",
            //忽略空指针异常，既空指针异常保持不走fallback方法
            exceptionsToIgnore = NullPointerException.class)
    public String fallback(@PathVariable Long id) {
        String result = restTemplate.getForObject(URL_PREFIX + "/paymentSQL/"+id,String.class,id);
        if (id == 4) {
            throw new IllegalArgumentException ("IllegalArgumentException,非法参数异常....");
        }else if (result == null || result.contains("null")) {
            throw new NullPointerException ("NullPointerException,该ID没有对应记录,空指针异常");
        }
        return result;
    }


    //处理异常的方法，必须和原方法有相同的返回值类型，参数列表，处理方法可以多加一个Throwable
    public String handlerFallback(Long id,Throwable e) {
        log.info(id+"  兜底异常handlerFallback,exception内容  "+e.getMessage());
        return id+"  兜底异常handlerFallback,exception内容  "+e.getMessage();
    }

    //处理流控的方法，必须和原方法有相同的返回值类型，参数列表，处理方法可以多加一个 BlockException
    public String blockHandler(Long id, BlockException e) {
        log.info(id+"  不满足流控配置 blockHandler,exception内容  "+e.getMessage());
        return id+"  不满足流控配置 blockHandler,exception内容  "+e.getMessage();
    }
}
