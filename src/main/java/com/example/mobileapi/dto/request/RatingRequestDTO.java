package com.example.mobileapi.dto.request;
import java.util.UUID;
import jakarta.validation.constraints.*;
import lombok.Getter;

@Getter
public class RatingRequestDTO {
    @NotNull(message = "MISSING_PRODUCT")
    Integer productId;

    @NotNull(message = "MISSING_CUSTOMER")
    Integer customerId;

    @NotBlank(message = "MISSING_COMMENT")
    @Size(min = 10, max = 500, message = "INVALID_COMMENT_LENGTH")
    String comment;

    @Min(value = 1, message = "INVALID_SCORE")
    @Max(value = 5, message = "INVALID_SCORE")
    Integer score;
}
