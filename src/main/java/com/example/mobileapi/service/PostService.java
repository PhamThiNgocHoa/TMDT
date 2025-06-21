package com.example.mobileapi.service;

import com.example.mobileapi.dto.request.PostRequestDTO;
import com.example.mobileapi.dto.response.PostResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface PostService {
    Page<PostResponseDTO> getPosts(String status, String search, String date, Pageable pageable);
    Optional<PostResponseDTO> getPostById(Long id);
    PostResponseDTO createPost(PostRequestDTO dto);
    Optional<PostResponseDTO> updatePost(Long id, PostRequestDTO dto);
    boolean deletePost(Long id);
    boolean updatePostStatus(Long id, String status);
} 