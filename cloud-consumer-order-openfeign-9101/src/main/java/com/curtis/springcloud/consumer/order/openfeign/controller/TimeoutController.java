package com.curtis.springcloud.consumer.order.openfeign.controller;

import com.curtis.springcloud.consumer.order.openfeign.common.CommonResult;
import com.curtis.springcloud.consumer.order.openfeign.controller.api.PaymentControllerApi;
import com.curtis.springcloud.consumer.order.openfeign.entity.Payment;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class TimeoutController {

    @Resource
    private PaymentControllerApi paymentControllerApi;

    @GetMapping(value = "/timeout/{millisecond}")
    public CommonResult timeout(@PathVariable("millisecond") Integer millisecond) {
        CommonResult commonResult = paymentControllerApi.timeout(millisecond);
        return commonResult;
    }
}
