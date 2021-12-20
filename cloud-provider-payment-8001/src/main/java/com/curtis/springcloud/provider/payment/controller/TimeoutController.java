package com.curtis.springcloud.provider.payment.controller;

import com.curtis.springcloud.provider.payment.common.CommonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

@RestController
public class TimeoutController {

    @Value("${server.port}")
    private Integer serverPort;

    private static final Logger LOGGER = LoggerFactory.getLogger(TimeoutController.class);


    @GetMapping(value = "/timeout/{millisecond}")
    public CommonResult timeout(@PathVariable("millisecond") Integer millisecond) {
        LOGGER.info("receive request");
        try {
            TimeUnit.MILLISECONDS.sleep(millisecond);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return CommonResult.success(200, "invoke success, server port: "+ serverPort, null);
    }
}
