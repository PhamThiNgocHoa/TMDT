package com.example.mobileapi.entity;

import com.example.mobileapi.entity.enums.OrderMethod;
import com.example.mobileapi.entity.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

@Table(name = "orders")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    Integer id;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "customer_id", nullable = false)
    Customer customer;

    LocalDateTime orderDate;

    @Column(name = "total_amount", nullable = false)
    BigDecimal totalAmount;

    String address;

    String numberPhone;
    @Enumerated(EnumType.STRING)
    OrderMethod paymentMethod;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    OrderStatus status;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    List<OrderDetail> orderDetails = new ArrayList<>();

    String receiver;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        return id != null ? id.equals(order.id) : order.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
