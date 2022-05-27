package com.xh.seata.service;

import com.xh.seata.vo.ResultJSON;

public interface StorageService {

    /**
     * 减少库存
     * @param productId 产品id
     * @param count 数量
     * @return json
     */
    ResultJSON deduct(Long productId, Integer count);
}
