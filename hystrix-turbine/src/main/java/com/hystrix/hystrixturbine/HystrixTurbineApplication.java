package com.hystrix.hystrixturbine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 *  使用 Turbine 聚合监控多个系统服务
 */
@SpringBootApplication
@EnableHystrixDashboard//开启 Hystrix 仪表盘 监控功能
@EnableTurbine//开启 turbine 功能
public class HystrixTurbineApplication {

    public static void main(String[] args) {
        SpringApplication.run(HystrixTurbineApplication.class, args);
    }
}
