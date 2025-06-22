package com.example.mobileapi.service.impl;

import com.example.mobileapi.dto.request.PostRequestDTO;
import com.example.mobileapi.dto.response.PostResponseDTO;
import com.example.mobileapi.entity.Post;
import com.example.mobileapi.repository.PostRepository;
import com.example.mobileapi.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;

    @Override
    public Page<PostResponseDTO> getPosts(Map<String, String> filters, Pageable pageable) {
        Page<Post> page = postRepository.findAll(pageable);
        List<PostResponseDTO> dtos = page.getContent().stream().map(this::toDto).collect(Collectors.toList());
        return new PageImpl<>(dtos, pageable, page.getTotalElements());
    }

    @Override
    public PostResponseDTO getPostById(Long id) {
        return postRepository.findById(id).map(this::toDto).orElse(null);
    }

    @Override
    public PostResponseDTO createPost(PostRequestDTO dto) {
        Post post = new Post();
        BeanUtils.copyProperties(dto, post);
        post.setCreatedAt(LocalDateTime.now());
        post.setViews(0);
        Post saved = postRepository.save(post);
        return toDto(saved);
    }

    @Override
    public PostResponseDTO updatePost(Long id, PostRequestDTO dto) {
        Post post = postRepository.findById(id).orElseThrow();
        BeanUtils.copyProperties(dto, post, "id", "createdAt");
        Post saved = postRepository.save(post);
        return toDto(saved);
    }

    @Override
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }

    @Override
    public void updatePostStatus(Long id, String status) {
        Post post = postRepository.findById(id).orElseThrow();
        post.setStatus(status);
        postRepository.save(post);
    }

    @Override
    public List<PostResponseDTO> getPostsByProductId(Long productId) {
        return postRepository.findAll().stream()
            .filter(post -> productId != null && productId.equals(post.getProductId()))
            .map(this::toDto)
            .collect(java.util.stream.Collectors.toList());
    }

    private PostResponseDTO toDto(Post post) {
        PostResponseDTO dto = new PostResponseDTO();
        BeanUtils.copyProperties(post, dto);
        dto.setCreatedAt(post.getCreatedAt() != null ? post.getCreatedAt().toString() : null);
        dto.setProductId(post.getProductId());
        return dto;
    }
} 