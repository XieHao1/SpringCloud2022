package com.xh.seata.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.xh.seata.dao.StorageDao;
import com.xh.seata.domain.Storage;
import com.xh.seata.service.StorageService;
import com.xh.seata.vo.ResultJSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class StorageServiceImpl implements StorageService {

    @Resource
    private StorageDao storageDao;

    @Override
    public ResultJSON deduct(Long productId, Integer count) {
        log.info("执行减少库存方法");
        LambdaQueryWrapper<Storage> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Storage::getProductId,productId);
        Storage storage = storageDao.selectOne(lambdaQueryWrapper);
        Integer used = storage.getUsed();
        Integer residue = storage.getResidue();
        if(count > residue){
            return ResultJSON.fail(1000,"库存不足");
        }
        Storage storageUpdate = new Storage();
        storageUpdate.setUsed(used + count);
        storageUpdate.setResidue(residue - count);
        storageDao.update(storageUpdate, lambdaQueryWrapper);
        log.info("减少库存方法结束");
        return ResultJSON.success(null);
    }
}
