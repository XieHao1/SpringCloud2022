package com.xh.seata.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.xh.seata.dao.OrderDao;
import com.xh.seata.domain.Order;
import com.xh.seata.service.AccountFeignService;
import com.xh.seata.service.OrderService;
import com.xh.seata.service.StorageFeignService;
import com.xh.seata.vo.ResultJSON;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;

    @Resource
    private StorageFeignService storageFeignService;

    @Resource
    private AccountFeignService accountFeignService;

    @Override
    //进行全局事务回滚
    @GlobalTransactional
    public void creat(Order order) {

        log.info("------->开始创建订单");
        order.setStatus(0);
        orderDao.insert(order);

        log.info("------->订单微服务开始调用库存，做扣减");
        ResultJSON resultStorage = storageFeignService.deduct(order.getProductId(), order.getCount());
        if (!resultStorage.isSuccess()){
            log.info("减少库存失败");
            return;
        }
        log.info("支付微服务开始调用，开始减余额");
        ResultJSON resultAccount = accountFeignService.payDeduct(order.getUserId(),
                BigDecimal.valueOf(order.getMoney()));
        if(!resultAccount.isSuccess()){
            log.info("支付失败");
            return;
        }
        log.info("修改订单的状态");
        update(order.getUserId(),0);
        log.info("新建订单结束");
    }

    public void update(Long userId, Integer status) {
        LambdaQueryWrapper<Order> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Order::getUserId,userId);
        lambdaQueryWrapper.eq(Order::getStatus,status);
        Order order = new Order();
        order.setStatus(1);
        orderDao.update(order,lambdaQueryWrapper);
    }
}
