package com.curtis.springcloud.consumer.order.openfeign;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

// 开启Feign功能
@EnableFeignClients
// 使用@EnableDiscoveryClient或者@EnableEurekaClient都可以启用Eureka服务发现，H版中不需要该注解也可以启用Eureka服务发现
// @EnableDiscoveryClient
// @EnableEurekaClient
@SpringBootApplication
public class CloudConsumerOrderOpenFeign9101Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudConsumerOrderOpenFeign9101Application.class, args);
    }
}
