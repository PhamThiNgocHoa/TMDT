package com.example.mobileapi.dto.request;

import lombok.Data;
import java.util.List;

@Data
public class PostRequestDTO {
    private String title;
    private String content;
    private String thumbnail;
    private String category;
    private String status;
    private String author;
    private int views;
    private Long productId;
    private List<String> tags;
} 