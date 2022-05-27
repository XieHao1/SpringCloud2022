package com.xh.seata.controller;

import com.xh.seata.service.StorageService;
import com.xh.seata.vo.ResultJSON;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/storage")
public class StorageController {

    @Resource
    private StorageService storageService;

    @PostMapping("/deduct")
    ResultJSON deduct(Long productId, Integer count){
        return storageService.deduct(productId,count);
    }
}
