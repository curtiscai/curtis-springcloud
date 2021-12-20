package com.curtis.springcloud.consumer.order.ribbon.hystrix.controller;

import com.curtis.springcloud.consumer.order.ribbon.hystrix.common.CommonResult;
import com.curtis.springcloud.consumer.order.ribbon.hystrix.service.api.PaymentServiceTimeoutApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TimeoutController {

    @Autowired
    private PaymentServiceTimeoutApi paymentServiceTimeoutApi;

    private static final Logger LOGGER = LoggerFactory.getLogger(TimeoutController.class);

    @GetMapping(value = "/timeout/{millisecond}")
    public CommonResult timeout(@PathVariable("millisecond") Integer millisecond) {
        CommonResult commonResult = paymentServiceTimeoutApi.timeout(millisecond);
        return commonResult;
    }
}
