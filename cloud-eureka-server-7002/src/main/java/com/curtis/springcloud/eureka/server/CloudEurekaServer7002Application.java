package com.curtis.springcloud.eureka.server;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

// 启用Eureka服务治理中心（activate Eureka Server related configuration）
@EnableEurekaServer
@SpringBootApplication
public class CloudEurekaServer7002Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudEurekaServer7002Application.class, args);
    }
}
