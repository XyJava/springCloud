package com.eureka.servicefeign;

import org.springframework.stereotype.Component;

/**
 * 熔断器的指定类
 */
@Component
public class FeignHelloHystrix implements FeignService {
    @Override
    public String feignHello(String name) {
        return "Feign say : Hello ,"+name+",sorry,error!";
    }

    @Override
    public String helloFeign(String name) {
        return "I am helloFeign , sorry, "+name+"have error!";
    }
}
