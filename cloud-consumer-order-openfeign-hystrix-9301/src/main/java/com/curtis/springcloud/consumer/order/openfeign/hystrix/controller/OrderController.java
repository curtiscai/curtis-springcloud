package com.curtis.springcloud.consumer.order.openfeign.hystrix.controller;

import com.curtis.springcloud.consumer.order.openfeign.hystrix.common.CommonResult;
import com.curtis.springcloud.consumer.order.openfeign.hystrix.controller.api.PaymentControllerApi;
import com.curtis.springcloud.consumer.order.openfeign.hystrix.entity.Payment;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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
    @GetMapping(value = "/timeout/{millisecond}")
    public CommonResult timeout(@PathVariable("millisecond") Integer millisecond) {
        CommonResult commonResult = paymentControllerApi.timeout(millisecond);
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
