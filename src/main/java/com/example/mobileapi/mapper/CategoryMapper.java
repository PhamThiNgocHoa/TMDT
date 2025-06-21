package com.example.mobileapi.mapper;

import com.example.mobileapi.dto.request.CategoryRequestDTO;
import com.example.mobileapi.dto.response.CategoryResponseDTO;
import com.example.mobileapi.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mapping(target = "active", expression = "java(dto.getActive() != null ? dto.getActive() : true)")
    Category toCategory(CategoryRequestDTO dto);

    Category toCategory(CategoryResponseDTO dto);

    @Mapping(source = "active", target = "active")
    CategoryResponseDTO toCategoryResponseDTO(Category category);

    CategoryRequestDTO toCategoryRequestDTO(Category entiry);

    @Mapping(source = "active", target = "active")
    List<CategoryResponseDTO> toCategoryResponseDTOs(List<Category> categories);

    List<Category> toCategories(List<CategoryRequestDTO> categoryRequestDTOS);

    List<Category> toCategorieList(List<CategoryResponseDTO> dtos);

    void updateCategoryFromDto(CategoryRequestDTO dto, @MappingTarget Category entity);
}
