package com.example.mobileapi.service.impl;


import com.example.mobileapi.dto.request.RatingRequestDTO;
import com.example.mobileapi.dto.response.RatingResponseDTO;
import com.example.mobileapi.entity.Customer;
import com.example.mobileapi.entity.Product;
import com.example.mobileapi.entity.Rating;
import com.example.mobileapi.exception.AppException;
import com.example.mobileapi.exception.ErrorCode;
import com.example.mobileapi.mapper.RatingMapper;
import com.example.mobileapi.repository.CustomerRepository;
import com.example.mobileapi.repository.ProductRepository;
import com.example.mobileapi.repository.RatingRepository;
import com.example.mobileapi.service.RatingService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Service
public class RatingServiceImpl implements RatingService {
    RatingRepository ratingRepository;
    RatingMapper ratingMapper;
    ProductRepository productRepository;
    CustomerRepository customerRepository;

    @Override
    public RatingResponseDTO create(RatingRequestDTO dto) {
        validateRating(dto);
        Product product = productRepository.findById(dto.getProductId()).orElseThrow(() -> new AppException(ErrorCode.PRODUCT_NOT_FOUND));
        Rating rating = ratingMapper.toEntity(dto);
        Customer customer = customerRepository.findById(dto.getCustomerId())
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUND
                ));
        rating.setProduct(product);
        rating.setCustomer(customer);
        rating.setScore(dto.getScore());
        rating.setComment(dto.getComment());

        Rating ratingSaved = ratingRepository.save(rating);

        return ratingMapper.toResponseDTO(ratingSaved);
    }

    @Override
    public RatingResponseDTO update(int id, RatingRequestDTO dto) {
        validateRating(dto);
        Rating rating = ratingRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.RATING_NOT_FOUND));

        long minutesSinceCreate = Duration.between(rating.getCreatedAt(), Instant.now()).toMinutes();
        if (minutesSinceCreate > 30) {
            throw new AppException(ErrorCode.RATING_UPDATE_EXPIRED);
        }

        if (dto.getProductId() != null) {
            Product product = productRepository.findById(dto.getProductId())
                    .orElseThrow(() -> new AppException(ErrorCode.PRODUCT_NOT_FOUND));
            rating.setProduct(product);
        }

        if (dto.getScore() != null) {
            rating.setScore(dto.getScore());
        }

        if (dto.getComment() != null) {
            rating.setComment(dto.getComment());
        }

        Rating updated = ratingRepository.save(rating);

        return ratingMapper.toResponseDTO(updated);
    }

    private void validateRating(RatingRequestDTO dto) {
        String comment = dto.getComment();
        if (comment == null || comment.trim().length() < 5 || comment.length() > 255) {
            throw new AppException(ErrorCode.INVALID_COMMENT_LENGTH);
        }
    }


    @Override
    public RatingResponseDTO getById(int id) {
        return ratingRepository.findById(id)
                .map(ratingMapper::toResponseDTO)
                .orElseThrow(() -> new AppException(ErrorCode.RATING_NOT_FOUND));
    }

    @Override
    public void delete(int id) {
        ratingRepository
                .findById(id)
                .ifPresentOrElse(
                        ratingRepository::delete,
                        () -> {
                            throw new AppException(ErrorCode.RATING_NOT_FOUND);
                        }
                );

    }

    @Override
    public List<RatingResponseDTO> getAllByProduct(int productId) {
        Product product = productRepository.findById(productId).orElseThrow(() -> new AppException(ErrorCode.PRODUCT_NOT_FOUND));
        List<Rating> ratings = ratingRepository.findAllByProduct((product));
        if (ratings != null && !ratings.isEmpty()) {
            return ratings.stream()
                    .map(ratingMapper::toResponseDTO)
                    .toList();
        }


        return Collections.emptyList();
    }

    @Override
    public Double avgRating(int productId) {
        List<RatingResponseDTO> ratings = getAllByProduct(productId);
        if (ratings.isEmpty()) {
            return 0.0;
        }
        double totalScore = ratings.stream().mapToDouble(RatingResponseDTO::getScore).sum();
        return totalScore / ratings.size();


    }
}
