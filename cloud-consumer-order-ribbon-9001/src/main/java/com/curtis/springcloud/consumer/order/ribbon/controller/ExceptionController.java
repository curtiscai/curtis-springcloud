package com.curtis.springcloud.consumer.order.ribbon.controller;

import com.curtis.springcloud.consumer.order.ribbon.common.CommonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class ExceptionController {

    // @LoadBalanced
    @Resource
    private RestTemplate restTemplate;

    // private static final String PAYMENT_SERVICE_URL = "http://localhost:8001";
    // 这里服务名称与大小写无关，均可
    private static final String PAYMENT_SERVICE_URL = "http://CLOUD-PROVIDER-PAYMENT-SERVICE";
    // private static final String PAYMENT_SERVICE_URL = "http://cloud-provider-payment-service";

    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionController.class);


    @GetMapping(value = "/exception/{param}")
    public CommonResult exception(@PathVariable("param") String param) {
        CommonResult commonResult = restTemplate.getForObject(PAYMENT_SERVICE_URL + "/exception/" + param, CommonResult.class);
        return commonResult;
    }
}
