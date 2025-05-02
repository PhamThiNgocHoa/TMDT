package com.example.mobileapi.dto.response;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
@Builder
public class ProductResponseDTO {
    Integer id;
    String name;
    String img;
    int price;
    String detail;
    Integer categoryId;  // ID của danh mục sản phẩm
    String categoryName;  // Tên của danh mục sản phẩm (ví dụ: Laptop, Màn hình, v.v.)
    String brand;  // Hãng sản xuất
}
