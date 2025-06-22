package com.example.mobileapi.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    @Column(columnDefinition = "TEXT")
    private String content;
    private String thumbnail;
    private String category;
    private String status; // published, draft, pending, rejected
    private LocalDateTime createdAt;
    private String author;
    private int views;

    private Long productId;

    @ElementCollection
    private List<String> tags;
} 