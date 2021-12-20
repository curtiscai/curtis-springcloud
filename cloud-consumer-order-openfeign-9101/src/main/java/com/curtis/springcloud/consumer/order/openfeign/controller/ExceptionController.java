package com.curtis.springcloud.consumer.order.openfeign.controller;

import com.curtis.springcloud.consumer.order.openfeign.common.CommonResult;
import com.curtis.springcloud.consumer.order.openfeign.controller.api.PaymentControllerApi;
import com.curtis.springcloud.consumer.order.openfeign.entity.Payment;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class ExceptionController {

    @Resource
    private PaymentControllerApi paymentControllerApi;

    @GetMapping(value = "/exception/{param}")
    public CommonResult exception(@PathVariable String param) {
        CommonResult commonResult = paymentControllerApi.exception(param);
        return commonResult;
    }
}
