package com.xh.seata.controller;

import com.xh.seata.service.AccountService;
import com.xh.seata.vo.ResultJSON;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Resource
    private AccountService accountService;

    @PostMapping("/deduct")
    public ResultJSON deduct(Long userId, BigDecimal money){
        return accountService.deduct(userId,money);
    }
}
