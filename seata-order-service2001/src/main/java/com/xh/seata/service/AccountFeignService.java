package com.xh.seata.service;

import com.xh.seata.vo.ResultJSON;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@FeignClient(value = "seata-account-service",path = "/account")
public interface AccountFeignService {

    /**
     * 调用支付接口减少余额
     * @param userId 用户的id
     * @param money 支付金额
     * @return json
     */
    @PostMapping("/deduct")
    ResultJSON payDeduct(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);
}
