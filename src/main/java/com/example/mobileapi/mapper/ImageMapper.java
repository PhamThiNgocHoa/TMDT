package com.example.mobileapi.mapper;

import com.example.mobileapi.dto.request.ImageRequestDTO;
import com.example.mobileapi.entity.ProductImage;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ImageMapper {
    ProductImage toEntity(ImageRequestDTO dto);
    ImageRequestDTO toDTO(ProductImage entity);
} 