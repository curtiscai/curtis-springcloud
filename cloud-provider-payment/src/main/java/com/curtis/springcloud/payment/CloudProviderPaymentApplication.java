package com.curtis.springcloud.payment;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class CloudProviderPaymentApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudProviderPaymentApplication.class, args);
    }
}
