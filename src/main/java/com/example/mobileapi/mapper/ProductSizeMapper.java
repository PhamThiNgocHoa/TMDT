package com.example.mobileapi.mapper;

import com.example.mobileapi.dto.request.ProductSizeRequestDTO;
import com.example.mobileapi.entity.ProductSize;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductSizeMapper {
    ProductSize toEntity(ProductSizeRequestDTO dto);
    ProductSizeRequestDTO toDTO(ProductSize entity);
} 