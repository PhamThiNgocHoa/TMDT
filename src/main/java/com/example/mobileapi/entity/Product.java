package com.example.mobileapi.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Table(name = "products")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    Integer id;

    @Column(nullable = false)
    String name;  // Tên sản phẩm

    @Column(nullable = false)
    String img;   // Hình ảnh sản phẩm

    @Column(nullable = false)
    int price;    // Giá sản phẩm

    @Column(nullable = false)
    String detail;  // Mô tả sản phẩm

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "categoryId", nullable = false)
    Category category;  // Mối quan hệ với danh mục sản phẩm

    @Column(nullable = false)
    String brand;  // Hãng sản xuất của sản phẩm

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    List<ProductSpecification> productSpecifications = new ArrayList<>();  // Thông số kỹ thuật của sản phẩm
}
