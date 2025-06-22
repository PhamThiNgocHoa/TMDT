package com.example.mobileapi.mapper;

import com.example.mobileapi.dto.request.ProductSpecificationRequestDTO;
import com.example.mobileapi.entity.ProductSpecification;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductSpecificationMapper {
    ProductSpecification toEntity(ProductSpecificationRequestDTO dto);
    ProductSpecificationRequestDTO toDTO(ProductSpecification entity);
} 