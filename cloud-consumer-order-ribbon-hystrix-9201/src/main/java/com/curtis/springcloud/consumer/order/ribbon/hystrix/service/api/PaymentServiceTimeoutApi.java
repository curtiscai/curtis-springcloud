package com.curtis.springcloud.consumer.order.ribbon.hystrix.service.api;

import com.curtis.springcloud.consumer.order.ribbon.hystrix.common.CommonResult;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author curtis.cai
 * @desc TODO
 * @date 2021-12-15
 * @email curtis.cai@outlook.com
 * @reference
 */
@Service
public class PaymentServiceTimeoutApi {

    // @LoadBalanced
    @Resource
    private RestTemplate restTemplate;

    // private static final String PAYMENT_SERVICE_URL = "http://localhost:8001";
    // 这里服务名称与大小写无关，均可
    private static final String PAYMENT_SERVICE_URL = "http://CLOUD-PROVIDER-PAYMENT-SERVICE";
    // private static final String PAYMENT_SERVICE_URL = "http://cloud-provider-payment-service";

    private static final Logger LOGGER = LoggerFactory.getLogger(PaymentServiceTimeoutApi.class);

    @HystrixCommand(fallbackMethod = "fallbackWithTimeout")
    public CommonResult timeout(Integer millisecond) {
        CommonResult commonResult = restTemplate.getForObject(PAYMENT_SERVICE_URL + "/timeout/" + millisecond, CommonResult.class);
        return commonResult;
    }

    private CommonResult fallbackWithTimeout(Integer second) {
        return CommonResult.success(200, "服务发生超时", null);
    }
}
