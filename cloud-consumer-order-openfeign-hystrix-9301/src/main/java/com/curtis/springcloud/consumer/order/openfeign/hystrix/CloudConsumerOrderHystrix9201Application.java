package com.curtis.springcloud.consumer.order.openfeign.hystrix;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;

// 启动断路器(使用@EnableHystrix或者@EnableCircuitBreaker都可以，@EnableHystrix继承自@EnableCircuitBreaker)
// @EnableHystrix
@EnableCircuitBreaker
// 开启Feign功能
@EnableFeignClients
// 消费端可以不注册进注册中心，但是需要从注册中心拉取服务注册信息
// @EnableEurekaClient
@SpringBootApplication
public class CloudConsumerOrderHystrix9201Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudConsumerOrderHystrix9201Application.class, args);
    }
}
