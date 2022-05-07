package com.xh.springcloud.service;

import com.xh.springcloud.domain.Payment;
import com.xh.springcloud.util.ResultJSON;

public interface PaymentService {
    /**
     *
     * @param id 支付id
     * @return 支付订单流水号
     */
    ResultJSON<Payment> findPaymentById(Long id);

    /**
     *
     * @param payment 流水号信息
     * @return 插入后的流水
     */
    ResultJSON<Payment> insertPayment(Payment payment);
}
