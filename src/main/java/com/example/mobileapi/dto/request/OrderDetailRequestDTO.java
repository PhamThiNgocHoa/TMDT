package com.example.mobileapi.dto.request;

import com.example.mobileapi.dto.ProductCustomizationDTO;
import lombok.Data;

@Data
public class OrderDetailRequestDTO {
    private Integer productId;
    private Integer quantity;
    private String color;
    private ProductCustomizationDTO customization;

}
