package com.example.mobileapi.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductSizeResponseDTO {
    private Integer id;
    private String size;
}
