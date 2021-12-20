package com.curtis.springcloud.consumer.order.openfeign.hystrix.api;

import com.curtis.springcloud.consumer.order.openfeign.hystrix.common.CommonResult;
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
public class ExceptionServiceApi {

    // @LoadBalanced
    @Resource
    private RestTemplate restTemplate;

    // private static final String PAYMENT_SERVICE_URL = "http://localhost:8001";
    // 这里服务名称与大小写无关，均可
    private static final String PAYMENT_SERVICE_URL = "http://CLOUD-PROVIDER-PAYMENT-SERVICE";
    // private static final String PAYMENT_SERVICE_URL = "http://cloud-provider-payment-service";

    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionServiceApi.class);

    @HystrixCommand(fallbackMethod = "fallbackWithException")
    public CommonResult exception(String param) {
        CommonResult commonResult = restTemplate.getForObject(PAYMENT_SERVICE_URL + "/exception", CommonResult.class);
        return commonResult;
    }

    private CommonResult fallbackWithException(String param) {
        return CommonResult.success(200, "服务发生异常，入参：" + param, null);
    }
}
