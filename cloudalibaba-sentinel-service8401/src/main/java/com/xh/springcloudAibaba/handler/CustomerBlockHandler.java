package com.xh.springcloudAibaba.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;

//统一限流处理类
public class CustomerBlockHandler {

    //统一限流处理类中的方法必须为静态方法
    public static String handlerException(Integer id,BlockException exception) {
        return "按客戶自定义,global handlerException----1";
    }

    public static String handlerException2(BlockException exception) {
        return "按客戶自定义,global handlerException----1";
    }

}
