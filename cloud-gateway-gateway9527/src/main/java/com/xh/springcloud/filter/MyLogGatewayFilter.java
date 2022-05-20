package com.xh.springcloud.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Component
@Slf4j
public class MyLogGatewayFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("***********come in MyLogGateWayFilter:  "+ LocalDateTime.now());
        String uName = exchange.getRequest().getQueryParams().getFirst("uName");
        if(uName == null) {
            log.info("*******用户名为null，非法用户，o(╥﹏╥)o");
            //设置返回数据 设置状态码信息
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            //返回信息
            return exchange.getResponse().setComplete();
        }
        //放行
        return chain.filter(exchange);
    }

    @Override
    //设置过滤的级别
    //也可以使用order注解来实现
    public int getOrder() {
        return 0;
    }
}
