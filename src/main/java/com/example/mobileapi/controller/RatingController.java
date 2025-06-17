package com.example.mobileapi.controller;

import com.example.mobileapi.dto.request.RatingRequestDTO;
import com.example.mobileapi.dto.response.ApiResponse;
import com.example.mobileapi.dto.response.RatingResponseDTO;
import com.example.mobileapi.service.RatingService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rating")
@RequiredArgsConstructor
@Tag(name = "Rating", description = "RatingAPI")
@PreAuthorize("hasRole('USER')")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class RatingController {
    RatingService ratingService;

    @PostMapping
    public ApiResponse<RatingResponseDTO> create(
            @Valid @RequestBody RatingRequestDTO dto) {
        RatingResponseDTO created = ratingService.create(dto);
        return ApiResponse.success(created);
    }

    @PatchMapping("/{id}")
    public ApiResponse<RatingResponseDTO> update(
            @PathVariable("id") int id,
            @RequestBody RatingRequestDTO dto) {
        RatingResponseDTO updated = ratingService.update(id, dto);
        return ApiResponse.success(updated);
    }

    @GetMapping("/{id}")
    public ApiResponse<RatingResponseDTO> getById(
            @PathVariable("id") int id) {
        RatingResponseDTO rating = ratingService.getById(id);
        return ApiResponse.success(rating);
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> delete(
            @PathVariable("id") int id) {
        ratingService.delete(id);
        return ApiResponse.success();
    }

    @GetMapping("/product/{productId}")
    public ApiResponse<List<RatingResponseDTO>> getAllByProduct(
            @PathVariable("productId") int productId) {
        List<RatingResponseDTO> list = ratingService.getAllByProduct(productId);
        return ApiResponse.success(list);
    }

    @GetMapping("/avg/{productId}")
    public ApiResponse<Double> avgRating(
            @PathVariable("productId") int productId) {
        return ApiResponse.success(ratingService.avgRating(productId));
    }
}
