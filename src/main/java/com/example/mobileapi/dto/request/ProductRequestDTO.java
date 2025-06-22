package com.example.mobileapi.dto.request;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import java.util.List;

@Data
@Builder
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class ProductRequestDTO {
    String name;
    String img;
    Integer price;
    String description;
    Integer categoryId;
    String categoryName;
    Double originalPrice;
    String discount;
    Boolean inStock;
    Boolean productNew;
    Boolean hot;
    Boolean featured;
    String type;
    List<ProductColorRequestDTO> productColors;
    List<ProductSizeRequestDTO> productSizes;
    List<ImageRequestDTO> productImages;
    List<ProductSpecificationRequestDTO> productSpecifications;
}
