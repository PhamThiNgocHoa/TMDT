package com.example.mobileapi.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductCustomizationDTO {
    private String location;
    private String height;
    private String note;
}
