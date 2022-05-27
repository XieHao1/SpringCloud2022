package com.xh.seata.service;

import com.xh.seata.vo.ResultJSON;

import java.math.BigDecimal;

public interface AccountService{

    /**
     * 支付减少余额
     * @param userId 用户id
     * @param money 钱
     * @return json
     */
    ResultJSON deduct(Long userId, BigDecimal money);
}
