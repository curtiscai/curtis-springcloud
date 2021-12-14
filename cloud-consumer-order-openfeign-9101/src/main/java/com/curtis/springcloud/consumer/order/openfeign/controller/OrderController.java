package com.curtis.springcloud.consumer.order.openfeign.controller;

import com.curtis.springcloud.consumer.order.openfeign.common.CommonResult;
import com.curtis.springcloud.consumer.order.openfeign.controller.api.PaymentControllerApi;
import com.curtis.springcloud.consumer.order.openfeign.entity.Payment;
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

    @GetMapping(value = "/timeout/{second}")
    public CommonResult timeout(@PathVariable("second") Integer second) {
        CommonResult commonResult = paymentControllerApi.timeout(second);
        return commonResult;
    }
}
