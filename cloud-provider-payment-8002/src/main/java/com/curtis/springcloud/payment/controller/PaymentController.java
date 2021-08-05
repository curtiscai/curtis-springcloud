package com.curtis.springcloud.payment.controller;

import com.curtis.springcloud.payment.common.CommonResult;
import com.curtis.springcloud.payment.entity.Payment;
import com.curtis.springcloud.payment.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

// @RequestMapping(value = "/payment")
@RestController
public class PaymentController {

    @Value("${server.port}")
    private Integer serverPort;

    @Resource
    private PaymentService paymentService;

    private static final Logger LOGGER = LoggerFactory.getLogger(PaymentController.class);


    @PostMapping(value = "/payment")
    public CommonResult createPayment(@RequestBody Payment payment) {
        LOGGER.info("receive request");
        paymentService.createPayment(payment);
        return CommonResult.success(200, "payment success, server port: "+ serverPort, payment);
    }

    @GetMapping(value = "/payment/{id}")
    public CommonResult createPayment(@PathVariable Long id) {
        LOGGER.info("receive request");
        Payment paymentById = paymentService.getPaymentById(id);
        return CommonResult.success(200, "query success, server port: "+ serverPort, paymentById);
    }
}
