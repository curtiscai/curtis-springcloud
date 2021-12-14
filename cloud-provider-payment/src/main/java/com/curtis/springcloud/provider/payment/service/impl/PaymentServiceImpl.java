package com.curtis.springcloud.provider.payment.service.impl;

import com.curtis.springcloud.provider.payment.entity.Payment;
import com.curtis.springcloud.provider.payment.service.PaymentService;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;

@Service
public class PaymentServiceImpl implements PaymentService {

    private static ConcurrentHashMap<Long, Payment> dataHashMap = new ConcurrentHashMap<>();

    /**
     * 业务数据初始化
     */
    static {
        dataHashMap.put(1L, new Payment(1L, "10000001"));
        dataHashMap.put(2L, new Payment(2L, "10000002"));
        dataHashMap.put(3L, new Payment(3L, "10000003"));
    }

    @Override
    public boolean createPayment(Payment payment) {
        dataHashMap.put(payment.getId(), payment);
        return true;
    }

    @Override
    public Payment getPaymentById(Long id) {
        Payment payment = dataHashMap.get(id);
        return payment;
    }
}
