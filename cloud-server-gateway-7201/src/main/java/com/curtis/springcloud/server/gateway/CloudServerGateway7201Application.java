package com.curtis.springcloud.server.gateway;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


// 启用Zuul网关，包含@EnableCircuitBreaker会同时启用断路器
// @EnableZuulProxy
// 使用@EnableDiscoveryClient或者@EnableEurekaClient都可以启用Eureka服务发现，H版中不需要该注解也可以启用Eureka服务发现
// @EnableDiscoveryClient
// @EnableEurekaClient
@SpringBootApplication
public class CloudServerGateway7201Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudServerGateway7201Application.class, args);
    }
}
