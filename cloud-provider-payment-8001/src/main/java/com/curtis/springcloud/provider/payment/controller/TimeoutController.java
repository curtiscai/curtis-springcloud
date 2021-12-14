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


    @GetMapping(value = "/timeout/{second}")
    public CommonResult timeout(@PathVariable("second") Integer second) {
        LOGGER.info("receive request");
        try {
            TimeUnit.SECONDS.sleep(second);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return CommonResult.success(200, "invoke success, server port: "+ serverPort, null);
    }
}
