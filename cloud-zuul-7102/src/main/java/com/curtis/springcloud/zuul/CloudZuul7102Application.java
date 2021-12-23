package com.curtis.springcloud.zuul;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * 单机版服务注册中心
 */
// 启用Zuul网关，包含@EnableCircuitBreaker会同时启用断路器
@EnableZuulProxy
@SpringBootApplication
public class CloudZuul7102Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudZuul7102Application.class, args);
    }
}
