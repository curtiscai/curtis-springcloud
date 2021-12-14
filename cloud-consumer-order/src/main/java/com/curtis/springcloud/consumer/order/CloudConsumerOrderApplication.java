package com.curtis.springcloud.consumer.order;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
// @EnableEurekaClient
@SpringBootApplication
public class CloudConsumerOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudConsumerOrderApplication.class, args);
    }
}
