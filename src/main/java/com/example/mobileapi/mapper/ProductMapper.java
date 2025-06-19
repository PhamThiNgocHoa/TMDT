package com.example.mobileapi.mapper;

import com.example.mobileapi.dto.request.ProductRequestDTO;
import com.example.mobileapi.dto.response.*;
import com.example.mobileapi.entity.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(source = "categoryId", target = "category.id")
    @Mapping(source = "discount", target = "discount")
    Product toProduct(ProductRequestDTO dto);

    Product toProduct(ProductResponseDTO dto);

    ProductRequestDTO toProductRequestDTO(Product product);

    @Mapping(source = "category.id", target = "categoryId")
    @Mapping(source = "category.name", target = "categoryName")
    @Mapping(target = "productSpecifications", source = "productSpecifications")
    @Mapping(target = "originalPrice", source = "originalPrice")
    @Mapping(target = "discount", source = "discount")
    @Mapping(target = "inStock", source = "inStock")
    @Mapping(target = "hot", source = "hot")
    @Mapping(target = "featured", source = "featured")
    @Mapping(source = "productNew", target = "productNew")
    @Mapping(target = "type", source = "type")
    ProductResponseDTO toProductResponseDTO(Product product);


    List<ProductResponseDTO> toProductResponseDTOList(List<Product> productList);

    List<Product> toProductList(List<ProductResponseDTO> dtos);

    @Mapping(source = "specification.id", target = "specificationId")
    @Mapping(source = "specification.name", target = "specificationName")
    ProductSpecificationDTO toProductSpecificationDTO(ProductSpecification productSpecification);

    List<ProductSpecificationDTO> toProductSpecificationDTOList(List<ProductSpecification> productSpecifications);

    ProductColorResponseDTO toProductColorResponseDTO(ProductColor productColor);

    List<ProductColorResponseDTO> toProductColorResponseDTOList(List<ProductColor> productColors);

    ProductSizeResponseDTO toProductSizeResponseDTO(ProductSize productSize);

    List<ProductSizeResponseDTO> toProductSizeResponseDTOList(List<ProductSize> productSizes);

    ImageResponse toImageResponse(ProductImage productImage);

    List<ImageResponse> toImageResponseDTOList(List<ProductImage> images);


}


