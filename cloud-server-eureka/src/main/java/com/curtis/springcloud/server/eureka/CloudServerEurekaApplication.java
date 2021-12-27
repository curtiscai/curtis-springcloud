package com.curtis.springcloud.server.eureka;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 单机版服务注册中心
 */
// 启用Eureka服务治理中心（activate Eureka Server related configuration）
@EnableEurekaServer
@SpringBootApplication
public class CloudServerEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudServerEurekaApplication.class, args);
    }
}
