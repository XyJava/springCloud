package com.eureka.servicefeign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "service-client",fallback = FeignHelloHystrix.class)//指定调用哪个服务，例如：调用service-client服务，并指定熔断器的类
public interface FeignService {

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    String feignHello(@RequestParam(value = "name") String name);

    @RequestMapping(value = "/helloFeign",method = RequestMethod.GET)
    String helloFeign(@RequestParam(value = "name") String name);
}
