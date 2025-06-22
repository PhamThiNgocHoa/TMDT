package com.example.mobileapi.service;

import com.example.mobileapi.dto.response.RevenueResponse;
import com.example.mobileapi.entity.enums.OrderStatus;
import com.example.mobileapi.dto.request.OrderEditRequestDTO;
import com.example.mobileapi.dto.request.OrderRequestDTO;
import com.example.mobileapi.dto.response.OrderResponseDTO;
import com.example.mobileapi.exception.AppException;
import org.springframework.security.access.prepost.PreAuthorize;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface OrderService {
    int saveOrder(OrderRequestDTO orderRequestDTO) throws AppException;

    OrderResponseDTO getOrder(int orderId);

    void deleteOrder(int orderId);

    BigDecimal getPriceByOrderId(int orderId);

    void updateOrder(int id, OrderRequestDTO orderRequestDTO);

    List<OrderResponseDTO> getOrderByCustomerId(int customerId);

    List<OrderResponseDTO> getAllOrders();

    void editOrder(int id, OrderEditRequestDTO orderEditRequestDTO) throws AppException;

    List<RevenueResponse> getMonthlyRevenue();

    List<OrderResponseDTO> getOrdersByStatus(OrderStatus status);

    void changeOrderStatus(int orderId, OrderStatus status) throws AppException;

    @PreAuthorize("@customerServiceImpl.getCustomerIdByUsername(authentication.name) == #customerId")
    List<OrderResponseDTO> getOrdersByStatusAndCustomerId(OrderStatus status, int customerId);

    boolean existById(Integer orderId);

    RevenueResponse getRevenueByMonth(int month, int year);

    RevenueResponse getRevenueByYear(int year);

    RevenueResponse getRevenueByDate(LocalDate date);

}
