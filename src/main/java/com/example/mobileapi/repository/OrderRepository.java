package com.example.mobileapi.repository;

import com.example.mobileapi.entity.Order;
import com.example.mobileapi.entity.enums.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findByCustomerId(int customerId);

    List<Order> findByStatusAndCustomer_Id(OrderStatus status, int customerId);

    List<Order> findByStatus(OrderStatus status);

    @Query("SELECT o.totalAmount FROM Order o WHERE o.id = ?1")
    BigDecimal findTotalAmountByOrderId(int orderId);

    List<Order> findAllByOrderDateBetween(LocalDateTime orderDateAfter, LocalDateTime orderDateBefore);
}
