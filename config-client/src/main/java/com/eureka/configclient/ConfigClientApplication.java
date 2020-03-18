package com.eureka.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@EnableDiscoveryClient//向服务中心注册服务
@SpringBootApplication
public class ConfigClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApplication.class, args);
    }

    @Value("${name}")
    String name;

    @Value("${age}")
    String age;

    @Value("${version}")
    String version;

    @LoadBalanced
    @RequestMapping(value = "/hi",method = {RequestMethod.GET,RequestMethod.POST})
    public String getAge() {
        return "你好，我是"+name+"， 我今年"+age+"我来自："+version;
    }
}
