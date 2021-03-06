package com.curtis.springcloud.consumer.order.openfeign.hystrix.controller.api;

import com.curtis.springcloud.consumer.order.openfeign.hystrix.common.CommonResult;
import com.curtis.springcloud.consumer.order.openfeign.hystrix.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author curtis.cai
 * @desc TODO
 * @date 2021-08-07
 * @email curtis.cai@outlook.com
 * @reference
 */
@FeignClient(value = "CLOUD-PROVIDER-PAYMENT-SERVICE")
public interface PaymentControllerApi {

    @PostMapping(value = "/payment")
    public CommonResult createPayment(@RequestBody Payment payment);

    @GetMapping(value = "/payment/{id}")
    public CommonResult getPaymentById(@PathVariable(value = "id") Long id);

    @GetMapping(value = "/timeout/{millisecond}")
    public CommonResult timeout(@PathVariable("millisecond") Integer millisecond);

    @GetMapping(value = "/exception/{param}")
    public CommonResult exception(@PathVariable("param") String param);
}
