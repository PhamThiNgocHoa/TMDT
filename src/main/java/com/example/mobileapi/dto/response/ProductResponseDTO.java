package com.example.mobileapi.dto.response;

import com.example.mobileapi.entity.ProductColor;
import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ProductResponseDTO {

    private Integer id;
    private String name;
    private String img;
    private int price;
    private String description;
    private Integer categoryId;
    private String categoryName;
    private Double originalPrice;
    private String discount;
    private Boolean inStock;
    private Boolean productNew;
    private Boolean hot;
    private List<ProductColorResponseDTO> productColors;
    private List<ProductSizeResponseDTO> productSizes;
    private List<ImageResponse> productImages;
    private List<ProductSpecificationDTO> productSpecifications;
}
