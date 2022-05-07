package com.xh.springcloud.service.impl;

import com.xh.springcloud.Dao.PaymentDao;
import com.xh.springcloud.domain.Payment;
import com.xh.springcloud.service.PaymentService;
import com.xh.springcloud.util.ResultJSON;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public ResultJSON<Payment> findPaymentById(Long id) {
        Payment payment = paymentDao.selectById(id);
        if(payment != null){
            return new ResultJSON<Payment>().success(payment);
        }
        return new ResultJSON<Payment>().fail(10001,"未查询到相关信息");
    }

    @Override
    public ResultJSON<Payment> insertPayment(Payment payment) {
        int insert = paymentDao.insert(payment);
        if(insert == 1){
            return new ResultJSON<Payment>().success(payment);
        }
        return new ResultJSON<Payment>().fail(10002,"添加失败");
    }
}
