package com.curtis.springcloud.consumer.order.ribbon.hystrix;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

// 启动断路器(使用@EnableHystrix或者@EnableCircuitBreaker都可以，@EnableHystrix继承自@EnableCircuitBreaker)
// @EnableHystrix
@EnableCircuitBreaker
// 使用@EnableDiscoveryClient或者@EnableEurekaClient都可以启用Eureka服务发现，H版中不需要该注解也可以启用Eureka服务发现
// @EnableDiscoveryClient
// @EnableEurekaClient
@SpringBootApplication
public class CloudConsumerOrderRibbonHystrix9201Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudConsumerOrderRibbonHystrix9201Application.class, args);
    }
}
