package com.curtis.springcloud.eureka.server.controller;

import com.curtis.springcloud.eureka.server.common.CommonResult;
import com.curtis.springcloud.eureka.server.entity.Payment;
import com.google.common.collect.Maps;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.Map;

@RestController
public class OrderController {

    @Resource
    private RestTemplate restTemplate;

    private static final String PAYMENT_SERVICE_URL = "http://localhost:8000";

    @PostMapping(value = "/payment")
    public CommonResult createPayment(@RequestBody Payment payment) {
        CommonResult commonResult = restTemplate.postForObject(PAYMENT_SERVICE_URL + "/payment", payment, CommonResult.class);
        return commonResult;
    }

    @GetMapping(value = "/payment/{id}")
    public CommonResult getPaymentById(@PathVariable Long id) {
        Map<String, Object> uriVariables = Maps.newHashMap();
        uriVariables.put("id", id);
        CommonResult commonResult = restTemplate.getForObject(PAYMENT_SERVICE_URL + "/payment/{id}", CommonResult.class, uriVariables);
        return commonResult;
    }
}
