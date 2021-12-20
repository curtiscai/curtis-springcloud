package com.curtis.springcloud.consumer.order.ribbon.hystrix.controller;

import com.curtis.springcloud.consumer.order.ribbon.hystrix.common.CommonResult;
import com.curtis.springcloud.consumer.order.ribbon.hystrix.service.api.PaymentServiceExceptionApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExceptionController {

    @Autowired
    private PaymentServiceExceptionApi paymentServiceExceptionApi;

    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionController.class);

    @GetMapping(value = "/exception/{param}")
    public CommonResult exception(@PathVariable("param") String param) {
        CommonResult commonResult = paymentServiceExceptionApi.exception(param);
        return commonResult;
    }
}
