package com.eureka.eurekaclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Eureka服务提供者
 */
@EnableEurekaClient
@SpringBootApplication
@RestController
public class EurekaclientApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaclientApplication.class, args);
    }

    @Value("${server.port}")
    String port;

    @RequestMapping("/hello")
    public String hello(@RequestParam String name) {
        return "Hello " + name +",I am from port:  " + port;
    }

    @RequestMapping("/helloRibbon")
    public String helloRibbon(@RequestParam String name) {
        return "Ribbon Say：Hello " + name +",I am from port:  " + port;
    }

    @RequestMapping("/helloFeign")
    public String helloFeign(@RequestParam String name) {
        return "Feign Say：Hello " + name +",I am from port:  " + port;
    }
}
