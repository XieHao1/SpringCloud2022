package com.xh.springcloud.service;

public interface PaymentService {
    /**
     * 请求成功的方法
     * @param id id
     * @return 请求成功后的信息
     */
    String paymentInfoOK(Integer id);

    /**
     * 请求超时的方法
     * @param id id
     * @return 请求信息
     */
    String paymentTimeout(Integer id);

    /**
     * 服务熔断
     * @param id id
     * @return 返回信息
     */
    String paymentCircuitBreaker(Integer id);
}
