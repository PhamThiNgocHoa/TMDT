package com.example.mobileapi.mapper;


import com.example.mobileapi.dto.request.RatingRequestDTO;
import com.example.mobileapi.dto.response.RatingResponseDTO;
import com.example.mobileapi.entity.Rating;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RatingMapper {
    Rating toEntity(RatingRequestDTO dto);

    RatingRequestDTO toRequestDTO(Rating entity);

    @Mapping(source = "customer.fullname", target = "customerName")
    RatingResponseDTO toResponseDTO(Rating entity);

}
