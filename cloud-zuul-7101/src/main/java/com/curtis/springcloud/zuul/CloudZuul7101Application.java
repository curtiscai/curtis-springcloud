package com.curtis.springcloud.zuul;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;


// 启用Zuul网关，包含@EnableCircuitBreaker会同时启用断路器
@EnableZuulProxy
// 使用@EnableDiscoveryClient或者@EnableEurekaClient都可以启用Eureka服务发现，H版中不需要该注解也可以启用Eureka服务发现
// @EnableDiscoveryClient
// @EnableEurekaClient
@SpringBootApplication
public class CloudZuul7101Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudZuul7101Application.class, args);
    }
}
