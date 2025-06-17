package com.example.mobileapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product_images")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(nullable = false)
    String url;

    @Column(nullable = false)
    String alt;

    @ManyToOne
    @JoinColumn(name = "product_id")
    Product product; // Mối quan hệ với sản phẩm
}
