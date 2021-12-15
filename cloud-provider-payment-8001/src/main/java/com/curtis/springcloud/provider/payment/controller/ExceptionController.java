package com.curtis.springcloud.provider.payment.controller;

import com.curtis.springcloud.provider.payment.common.CommonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class ExceptionController {

    @Value("${server.port}")
    private Integer serverPort;

    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionController.class);


    @GetMapping(value = "/exception/{param}")
    public CommonResult exception(@PathVariable String param) {
        LOGGER.info("receive request");
        throw new RuntimeException("An exception occurs, server port: " + serverPort + ", The PathVariable Is " + param);
    }
}
