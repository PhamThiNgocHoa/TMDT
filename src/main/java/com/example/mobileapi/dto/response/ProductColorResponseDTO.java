package com.example.mobileapi.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductColorResponseDTO {
    private Integer id;
    private String color;
}
