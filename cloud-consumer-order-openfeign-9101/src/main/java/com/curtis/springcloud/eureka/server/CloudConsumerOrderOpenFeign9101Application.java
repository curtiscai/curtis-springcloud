package com.curtis.springcloud.eureka.server;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

// 开启Feign功能
@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class CloudConsumerOrderOpenFeign9101Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudConsumerOrderOpenFeign9101Application.class, args);
    }
}
