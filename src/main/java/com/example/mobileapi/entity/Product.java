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

@Entity
@Table(name = "products")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    Integer id; // Mã sản phẩm, sử dụng Integer thay vì String

    @Column(nullable = false)
    String name; // Tên sản phẩm

    @Column(nullable = false)
    String img; // Ảnh sản phẩm chính (imageUrl thay vì img)

    @Column(nullable = false)
    Double price; // Giá sản phẩm (số)

    @Column(nullable = true)
    Double originalPrice; // Giá gốc (optional)

    @Column(nullable = true)
    String discount; // Giảm giá dạng chuỗi (ví dụ "-30")

    @Column(nullable = true)
    String description; // Mô tả sản phẩm

    @Column(nullable = true)
    Boolean inStock;

    @Column(nullable = true)
    Boolean hot;

    @Column(nullable = true)
    Boolean productNew;

    @Column(nullable = true)
    String type;  // Loại sản phẩm

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<ProductColor> productColors = new ArrayList<>();

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<ProductSize> productSizes = new ArrayList<>();

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<ProductImage> productImages = new ArrayList<>();


    // Mối quan hệ với Category
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "category_id", nullable = false)
    Category category; // Sản phẩm thuộc danh mục nào

    // Mối quan hệ với ProductSpecification
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<ProductSpecification> productSpecifications = new ArrayList<>();

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<ProductImage> images = new ArrayList<>();

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Builder.Default
    private List<Rating> ratings = new ArrayList<>();

    @PrePersist
    public void calculatePrice() {
        if (originalPrice != null) {
            this.price = originalPrice * (1 - getDiscountAsDecimal());
        }
    }

    // Hàm chuyển đổi discount sang dạng số
    public Double getDiscountAsDecimal() {
        if (discount != null && discount.endsWith("%")) {
            try {
                return Double.parseDouble(discount.replace("%", "")) / 100;
            } catch (NumberFormatException e) {
                return 0.0; // Nếu giá trị không hợp lệ, mặc định là 0%
            }
        }
        return 0.0; // Nếu không có discount, mặc định là 0%
    }

}
