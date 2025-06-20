package com.example.mobileapi.service.impl;

import com.example.mobileapi.dto.response.TransactionResponse;
import com.example.mobileapi.service.OrderService;
import com.example.mobileapi.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceIml implements TransactionService {

    @Autowired
    private OrderService orderService;

    @Override
    public TransactionResponse createTransaction(String id, int orderId, String responseCode, String transactionDate, String amount) {
        return TransactionResponse.builder()
                .id(id)
                .orders(orderService.getOrder(orderId))
                .responseCode(responseCode)
                .transactionDate(transactionDate)
                .amount(amount)
                .build();
    }

}
