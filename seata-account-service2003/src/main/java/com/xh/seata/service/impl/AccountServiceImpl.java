package com.xh.seata.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.xh.seata.dao.AccountDao;
import com.xh.seata.domain.Account;
import com.xh.seata.service.AccountService;
import com.xh.seata.vo.ResultJSON;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

@Service
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountDao accountDao;

    @Override
    public ResultJSON deduct(Long userId, BigDecimal money) {
        //模拟支付超时，触发全局事务
//        try {
//            TimeUnit.SECONDS.sleep(20);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        LambdaQueryWrapper<Account> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Account::getUserId,userId);
        Account account = accountDao.selectOne(lambdaQueryWrapper);
        Integer residue = account.getResidue();
        Integer used = account.getUsed();
        if(money.intValue() > residue){
            return ResultJSON.fail(20000,"余额不足");
        }
        Account accountUpdate = new Account();
        accountUpdate.setResidue(residue- money.intValue());
        accountUpdate.setUsed(used + money.intValue());
        accountDao.update(accountUpdate,lambdaQueryWrapper);
        return ResultJSON.success("支付成功");
    }
}
