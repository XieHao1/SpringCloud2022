package com.xh.springcloud.Dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xh.springcloud.domain.Payment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaymentDao extends BaseMapper<Payment> {

}
