package com.xh.seata.service;

import com.xh.seata.vo.ResultJSON;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "seata-storage-service",path = "/storage")
public interface StorageFeignService {

    /**
     * 调用减少库存的方法
     * @param productId 产品id
     * @param count 减少的数量
     * @return json
     */
    @PostMapping("/deduct")
    ResultJSON deduct(@RequestParam("productId") Long productId,@RequestParam("count") Integer count);
}
