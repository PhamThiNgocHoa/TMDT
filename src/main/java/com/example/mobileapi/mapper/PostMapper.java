package com.example.mobileapi.mapper;

import com.example.mobileapi.dto.request.PostRequestDTO;
import com.example.mobileapi.dto.response.PostResponseDTO;
import com.example.mobileapi.entity.Post;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Component
public class PostMapper {
    public Post toEntity(PostRequestDTO dto) {
        Post post = new Post();
        post.setTitle(dto.getTitle());
        post.setContent(dto.getContent());
        post.setStatus(dto.getStatus());
        post.setThumbnail(dto.getThumbnail());
        post.setCategory(dto.getCategory());
        post.setAuthor(dto.getAuthor());
        post.setViews(dto.getViews());
        post.setTags(dto.getTags() != null ? new ArrayList<>(dto.getTags()) : null);
        post.setCreatedAt(LocalDateTime.now());
        post.setUpdatedAt(LocalDateTime.now());
        return post;
    }

    public void updateEntity(Post post, PostRequestDTO dto) {
        if (dto.getTitle() != null) post.setTitle(dto.getTitle());
        if (dto.getContent() != null) post.setContent(dto.getContent());
        if (dto.getStatus() != null) post.setStatus(dto.getStatus());
        if (dto.getThumbnail() != null) post.setThumbnail(dto.getThumbnail());
        if (dto.getCategory() != null) post.setCategory(dto.getCategory());
        if (dto.getAuthor() != null) post.setAuthor(dto.getAuthor());
        if (dto.getTags() != null) post.setTags(new ArrayList<>(dto.getTags()));
        post.setViews(dto.getViews());
        post.setUpdatedAt(LocalDateTime.now());
    }

    public PostResponseDTO toDto(Post post) {
        PostResponseDTO dto = new PostResponseDTO();
        dto.setId(post.getId());
        dto.setTitle(post.getTitle());
        dto.setContent(post.getContent());
        dto.setStatus(post.getStatus());
        dto.setThumbnail(post.getThumbnail());
        dto.setCategory(post.getCategory());
        dto.setAuthor(post.getAuthor());
        dto.setViews(post.getViews());
        dto.setTags(post.getTags());
        dto.setCreatedAt(post.getCreatedAt());
        dto.setUpdatedAt(post.getUpdatedAt());
        return dto;
    }
} 