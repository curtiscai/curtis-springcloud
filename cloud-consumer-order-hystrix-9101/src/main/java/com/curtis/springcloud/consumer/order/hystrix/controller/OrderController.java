package com.curtis.springcloud.consumer.order.hystrix.controller;

import com.curtis.springcloud.consumer.order.hystrix.common.CommonResult;
import com.curtis.springcloud.consumer.order.hystrix.controller.api.PaymentControllerApi;
import com.curtis.springcloud.consumer.order.hystrix.entity.Payment;
import com.google.common.collect.Maps;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.Map;

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

    @HystrixCommand(fallbackMethod = "timeoutFallback")
    @GetMapping(value = "/timeout/{second}")
    public CommonResult timeout(@PathVariable("second") Integer second) {
        CommonResult commonResult = paymentControllerApi.timeout(second);
        return commonResult;
    }

    public CommonResult timeoutFallback(Integer second) {
        return CommonResult.success(200, "服务调用发生超时", null);
    }

    @HystrixCommand(fallbackMethod = "exceptionFallback")
    @GetMapping(value = "/exception/{param}")
    public CommonResult exception(@PathVariable String param) {
        CommonResult commonResult = paymentControllerApi.exception(param);
        return commonResult;
    }

    public CommonResult exceptionFallback(String param) {
        return CommonResult.success(200, "服务调用发生异常", null);

    }
}
