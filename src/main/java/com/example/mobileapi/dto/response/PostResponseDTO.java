package com.example.mobileapi.dto.response;

import lombok.Data;
import java.util.List;

@Data
public class PostResponseDTO {
    private Long id;
    private String title;
    private String content;
    private String thumbnail;
    private String category;
    private String status;
    private String createdAt;
    private String author;
    private int views;
    private Long productId;
    private List<String> tags;
} 