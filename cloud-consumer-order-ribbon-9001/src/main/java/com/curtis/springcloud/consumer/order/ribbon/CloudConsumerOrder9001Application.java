package com.curtis.springcloud.consumer.order.ribbon;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class CloudConsumerOrder9001Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudConsumerOrder9001Application.class, args);
    }
}
