package com.curtis.springcloud.provider.payment;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

// 使用@EnableDiscoveryClient或者@EnableEurekaClient都可以启用Eureka服务发现，H版中不需要该注解也可以启用Eureka服务发现
// @EnableDiscoveryClient
// @EnableEurekaClient
@SpringBootApplication
public class CloudProviderPayment8001Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudProviderPayment8001Application.class, args);
    }
}
