package com.curtis.springcloud.consumer.order;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

// 启用Eureka服务治理中心（activate Eureka Server related configuration）
@EnableEurekaServer
@SpringBootApplication
public class CloudEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudEurekaServerApplication.class, args);
    }
}
