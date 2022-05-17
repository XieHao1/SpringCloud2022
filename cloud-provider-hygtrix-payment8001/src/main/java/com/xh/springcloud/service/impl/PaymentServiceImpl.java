package com.xh.springcloud.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.xh.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;


@Service
@Slf4j
public class PaymentServiceImpl implements PaymentService {

    @Override
    public String paymentInfoOK(Integer id) {
        return "线程名称:" + Thread.currentThread().getName() + "   paymentInfoOK,id: " + id;
    }

    @Override
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler"/*指定善后的方法*/,commandProperties = {
            //指定该方法的用时为3秒钟，若超过三秒或者出现异常，则直接调用善后的方法
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="3000")
    })
    public String paymentTimeout(Integer id) {
       // int age = 10/0;
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程名称:" + Thread.currentThread().getName() + "   paymentInfoOK,id: " + id +"   睡眠3秒";
    }

    public String paymentInfo_TimeOutHandler(Integer id){
        //Hystrix会自动将方法的参数传递,所以在写善后方法时主要要带上方法的参数
        return "线程名称:" + Thread.currentThread().getName() +"系统繁忙或者出现异常错误,请稍后再试";
    }
}
