package com.example.mobileapi.service;

import com.example.mobileapi.dto.response.TransactionResponse;

public interface TransactionService {
    TransactionResponse createTransaction(String id, int orderId, String responseCode, String transactionDate, String amount);
}

