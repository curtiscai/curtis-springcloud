package com.curtis.springcloud.eureka.server.controller;

import com.curtis.springcloud.eureka.server.common.CommonResult;
import com.curtis.springcloud.eureka.server.controller.api.PaymentControllerApi;
import com.curtis.springcloud.eureka.server.entity.Payment;
import com.google.common.collect.Maps;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
public class OrderController {

    @Resource
    private PaymentControllerApi paymentControllerApi;

    @PostMapping(value = "/payment")
    public CommonResult createPayment(@RequestBody Payment payment) {
        CommonResult commonResult = paymentControllerApi.createPayment(payment);
        return commonResult;
    }

    @GetMapping(value = "/payment/{id}")
    public CommonResult getPaymentById(@PathVariable Long id) {
        CommonResult commonResult = paymentControllerApi.getPaymentById(id);
        return commonResult;
    }

    @GetMapping(value = "/timeout/{second}")
    public CommonResult timeout(@PathVariable("second") Integer second) {
        CommonResult commonResult = paymentControllerApi.timeout(second);
        return commonResult;
    }
}
