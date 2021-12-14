package com.curtis.springcloud.provider.payment.service;

import com.curtis.springcloud.provider.payment.entity.Payment;

public interface PaymentService {

    boolean createPayment(Payment payment);

    Payment getPaymentById(Long id);
}
