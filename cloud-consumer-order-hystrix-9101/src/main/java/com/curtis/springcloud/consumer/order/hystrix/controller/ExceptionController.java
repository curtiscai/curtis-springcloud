package com.curtis.springcloud.consumer.order.hystrix.controller;

import com.curtis.springcloud.consumer.order.hystrix.common.CommonResult;
import com.curtis.springcloud.consumer.order.hystrix.service.api.ExceptionServiceApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class ExceptionController {

    @Autowired
    private ExceptionServiceApi exceptionServiceApi;

    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionController.class);

    @GetMapping(value = "/exception/{param}")
    public CommonResult exception(@PathVariable String param) {
        CommonResult commonResult = exceptionServiceApi.exception(param);
        return commonResult;
    }
}
