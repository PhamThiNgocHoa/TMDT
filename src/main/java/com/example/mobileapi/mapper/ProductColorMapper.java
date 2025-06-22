package com.example.mobileapi.mapper;

import com.example.mobileapi.dto.request.ProductColorRequestDTO;
import com.example.mobileapi.entity.ProductColor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductColorMapper {
    ProductColor toEntity(ProductColorRequestDTO dto);
    ProductColorRequestDTO toDTO(ProductColor entity);
} 