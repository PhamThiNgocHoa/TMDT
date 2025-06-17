package com.example.mobileapi.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductSpecificationDTO {

    private Integer id;
    private String value;
    private Integer specificationId;  // Tham chiếu đến thông số kỹ thuật
    private String specificationName;  // Tên của thông số kỹ thuật

}
