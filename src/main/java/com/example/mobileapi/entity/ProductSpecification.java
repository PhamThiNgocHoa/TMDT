package com.example.mobileapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Table(name = "product_specifications")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class ProductSpecification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    Integer id;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    Product product;  // Liên kết với sản phẩm

    @ManyToOne
    @JoinColumn(name = "specification_id", nullable = false)
    Specification specification;  // Liên kết với thông số kỹ thuật

    @Column(nullable = false)
    String value;  // Giá trị của thông số kỹ thuật (ví dụ: 'Intel i7', '16GB', '512GB SSD')
}
