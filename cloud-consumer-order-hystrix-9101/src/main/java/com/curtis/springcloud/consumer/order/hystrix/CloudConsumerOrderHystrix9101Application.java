package com.curtis.springcloud.consumer.order.hystrix;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

// 启动断路器
@EnableCircuitBreaker
@EnableEurekaClient
@SpringBootApplication
public class CloudConsumerOrderHystrix9101Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudConsumerOrderHystrix9101Application.class, args);
    }
}
