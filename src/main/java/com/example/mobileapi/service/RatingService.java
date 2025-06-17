package com.example.mobileapi.service;

import com.example.mobileapi.dto.request.RatingRequestDTO;
import com.example.mobileapi.dto.response.RatingResponseDTO;

import java.util.List;
import java.util.UUID;

public interface RatingService {

    RatingResponseDTO create(RatingRequestDTO dto);

    RatingResponseDTO update(int id, RatingRequestDTO dto);

    RatingResponseDTO getById(int id);

    void delete(int id);

    List<RatingResponseDTO> getAllByProduct(int productId);

    Double avgRating(int productId);
}
