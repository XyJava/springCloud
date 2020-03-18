package com.eureka.serviceribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Eureka服务消费者（RestTemplate + Ribbon）
 * 开启熔断器功能（Hystrix）
 * 开启熔断器监控功能（HystrixDashboard）
 */
@SpringBootApplication
@EnableDiscoveryClient//向服务中心注册
@EnableHystrix//开启 Hysterix(熔断器) 功能
@EnableHystrixDashboard//开启 HystrixDashboard(Hystrix 仪表盘) 监控功能
public class ServiceRibbonApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceRibbonApplication.class, args);
    }

    @Bean
    @LoadBalanced//开启负载均衡功能
    RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
