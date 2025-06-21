package com.example.mobileapi.mapper;

import com.example.mobileapi.dto.ProductCustomizationDTO;
import com.example.mobileapi.entity.ProductCustomization;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductCustomizationMapper {
    ProductCustomization toEntity(ProductCustomizationDTO dto);

    ProductCustomizationDTO toDTO(ProductCustomization entity);
}
