package com.curtis.springcloud.payment.service;

import com.curtis.springcloud.payment.entity.Payment;

public interface PaymentService {

    boolean createPayment(Payment payment);

    Payment getPaymentById(Long id);
}
