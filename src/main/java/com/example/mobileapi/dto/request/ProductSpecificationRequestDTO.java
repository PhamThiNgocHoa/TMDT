package com.example.mobileapi.dto.request;

import lombok.Data;

@Data
public class ProductSpecificationRequestDTO {
    private Integer id;
    private String value;
    private Integer specificationId;
    private String specificationName;
} 