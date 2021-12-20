package com.curtis.springcloud.consumer.order.hystrix.controller;

import com.curtis.springcloud.consumer.order.hystrix.common.CommonResult;
import com.curtis.springcloud.consumer.order.hystrix.controller.api.PaymentControllerApi;
import com.curtis.springcloud.consumer.order.hystrix.entity.Payment;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@DefaultProperties(defaultFallback = "globalFallback")
public class OrderDefaultHystrixController {

    @Resource
    private PaymentControllerApi paymentControllerApi;

    @HystrixCommand
    @GetMapping(value = "/global/timeout/{second}")
    public CommonResult timeout(@PathVariable("second") Integer second) {
        CommonResult commonResult = paymentControllerApi.timeout(second);
        return commonResult;
    }

    @HystrixCommand
    @GetMapping(value = "/global/exception/{param}")
    public CommonResult exception(@PathVariable String param) {
        CommonResult commonResult = paymentControllerApi.exception(param);
        return commonResult;
    }

    public CommonResult globalFallback() {
        return CommonResult.success(200, "服务调用发生异常或者超时", null);

    }
}
