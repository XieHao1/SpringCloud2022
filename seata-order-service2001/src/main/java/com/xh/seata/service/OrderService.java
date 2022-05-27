package com.xh.seata.service;

import com.xh.seata.domain.Order;

public interface OrderService {
    /**
     * 创建订单
     * @param order 订单数据
     */
    void creat(Order order);
}
