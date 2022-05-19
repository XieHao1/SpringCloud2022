package com.xh.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        //ID:path_route_xh
        //path:/guonei
        //uri: http://news.baidu.com
        //将http://localhost:9527/guonei 映射到http://news.baidu.com/guonei
//        routes.route("path_route_xh",
//                r -> r.path("/guonei").uri("http://news.baidu.com/guonei"));
//        return routes.build();
        return routes.route("path_route_xh1",
                r -> r.path("/guonei").uri("http://news.baidu.com/guonei"))
                     .route("path_route_xh2",
                r -> r.path("/guonei").uri("http://news.baidu.com/guonei"))
                .build();
    }
}
