package com.example.mobileapi.controller;

import com.example.mobileapi.dto.request.PostRequestDTO;
import com.example.mobileapi.dto.response.PostResponseDTO;
import com.example.mobileapi.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping
    public Map<String, Object> getPosts(
            @RequestParam(required = false) String status,
            @RequestParam(required = false) String date,
            @RequestParam(required = false) String search,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String sort,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int limit
    ) {
        Pageable pageable = PageRequest.of(page, limit);
        Map<String, String> filters = new HashMap<>();
        if (status != null) filters.put("status", status);
        if (date != null) filters.put("date", date);
        if (search != null) filters.put("search", search);
        if (category != null) filters.put("category", category);
        if (sort != null) filters.put("sort", sort);
        Page<PostResponseDTO> result = postService.getPosts(filters, pageable);
        Map<String, Object> response = new HashMap<>();
        response.put("data", result.getContent());
        response.put("total", result.getTotalElements());
        return response;
    }

    @GetMapping("/{id}")
    public PostResponseDTO getPostById(@PathVariable Long id) {
        return postService.getPostById(id);
    }

    @PostMapping
    public PostResponseDTO createPost(@RequestBody PostRequestDTO dto) {
        return postService.createPost(dto);
    }

    @PutMapping("/{id}")
    public PostResponseDTO updatePost(@PathVariable Long id, @RequestBody PostRequestDTO dto) {
        return postService.updatePost(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id) {
        postService.deletePost(id);
    }

    @PatchMapping("/{id}/status")
    public void updatePostStatus(@PathVariable Long id, @RequestBody Map<String, String> body) {
        postService.updatePostStatus(id, body.get("status"));
    }

    @GetMapping("/product/{productId}")
    public List<PostResponseDTO> getPostsByProductId(@PathVariable Long productId) {
        // Tạm thời trả về tất cả bài viết có productId, sẽ thêm hàm trong service
        return postService.getPostsByProductId(productId);
    }
} 