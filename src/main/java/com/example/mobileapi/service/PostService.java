package com.example.mobileapi.service;

import com.example.mobileapi.dto.request.PostRequestDTO;
import com.example.mobileapi.dto.response.PostResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface PostService {
    Page<PostResponseDTO> getPosts(Map<String, String> filters, Pageable pageable);
    PostResponseDTO getPostById(Long id);
    PostResponseDTO createPost(PostRequestDTO dto);
    PostResponseDTO updatePost(Long id, PostRequestDTO dto);
    void deletePost(Long id);
    void updatePostStatus(Long id, String status);
    List<PostResponseDTO> getPostsByProductId(Long productId);
} 