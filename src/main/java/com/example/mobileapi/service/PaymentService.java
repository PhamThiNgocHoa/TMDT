package com.example.mobileapi.service;
import com.example.mobileapi.dto.response.PaymentResponse;
import com.example.mobileapi.exception.AppException;

import java.util.UUID;


public interface PaymentService {

    PaymentResponse createVNPayPayment(int orderId, String returnUrl) throws AppException;

    boolean notifyOrder(
            String vnpResponseCode,
            String vnpTransactionStatus,
            int orderId,
            String vnpTransactionNo,
            String vnpTransactionDate,
            String vnpAmount);
}

