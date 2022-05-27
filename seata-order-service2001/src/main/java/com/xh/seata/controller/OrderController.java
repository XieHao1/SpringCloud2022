package com.xh.seata.controller;

import com.xh.seata.domain.Order;
import com.xh.seata.service.OrderService;
import com.xh.seata.vo.ResultJSON;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Resource
    private OrderService orderService;

    @PostMapping("/creat")
    public ResultJSON creat(@RequestBody Order order){
        orderService.creat(order);
        return ResultJSON.success("创建订单成功");
    }
}
