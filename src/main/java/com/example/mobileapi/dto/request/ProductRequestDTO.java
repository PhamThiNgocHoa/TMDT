package com.example.mobileapi.dto.request;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class ProductRequestDTO {
    String name;
    String img;
    Double originalPrice; // Giá gốc
    String discount; // Giảm giá (ví dụ "-30%" hoặc "10%")
    String description; // Mô tả sản phẩm
    Integer categoryId; // ID danh mục
}
