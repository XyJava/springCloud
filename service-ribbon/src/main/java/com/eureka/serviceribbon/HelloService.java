package com.eureka.serviceribbon;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {
    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "helloError")//注明该方法启用熔断器功能并注明熔断方法
    public String helloService(String name) {
        return restTemplate.getForObject("http://SERVICE-CLIENT/hello?name=" + name,String.class);
    }

    public String helloError(String name){
        return "Hello , "+name+",sorry,error!";
    }

    @HystrixCommand(fallbackMethod = "helloRibbonError")//注明该方法启用熔断器功能并注明熔断方法
    public String helloRibbonService(String name) {
        return restTemplate.getForObject("http://SERVICE-CLIENT/helloRibbon?name=" + name,String.class);
    }

    public String helloRibbonError(String name){
        return "HelloRibbon  , "+name+",sorry,error!";
    }
}
