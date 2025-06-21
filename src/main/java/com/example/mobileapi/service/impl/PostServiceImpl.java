package com.example.mobileapi.service.impl;

import com.example.mobileapi.dto.request.PostRequestDTO;
import com.example.mobileapi.dto.response.PostResponseDTO;
import com.example.mobileapi.entity.Post;
import com.example.mobileapi.mapper.PostMapper;
import com.example.mobileapi.repository.PostRepository;
import com.example.mobileapi.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import jakarta.persistence.criteria.Predicate;
@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private PostMapper postMapper;

    @Override
    public Page<PostResponseDTO> getPosts(String status, String search, String date, Pageable pageable) {
        Specification<Post> spec = (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (status != null && !status.isEmpty()) {
                predicates.add(cb.equal(root.get("status"), status));
            }
            if (search != null && !search.isEmpty()) {
                predicates.add(cb.or(
                    cb.like(cb.lower(root.get("title")), "%" + search.toLowerCase() + "%"),
                    cb.like(cb.lower(root.get("content")), "%" + search.toLowerCase() + "%")
                ));
            }
            if (date != null && !date.isEmpty()) {
                try {
                    LocalDate localDate = LocalDate.parse(date);
                    LocalDateTime start = localDate.atStartOfDay();
                    LocalDateTime end = localDate.plusDays(1).atStartOfDay();
                    predicates.add(cb.between(root.get("createdAt"), start, end));
                } catch (DateTimeParseException ignored) {}
            }
            return cb.and(predicates.toArray(new Predicate[0]));
        };
        return postRepository.findAll(spec, pageable).map(postMapper::toDto);
    }

    @Override
    public Optional<PostResponseDTO> getPostById(Long id) {
        return postRepository.findById(id).map(postMapper::toDto);
    }

    @Override
    public PostResponseDTO createPost(PostRequestDTO dto) {
        Post post = postMapper.toEntity(dto);
        Post saved = postRepository.save(post);
        return postMapper.toDto(saved);
    }

    @Override
    public Optional<PostResponseDTO> updatePost(Long id, PostRequestDTO dto) {
        Optional<Post> postOpt = postRepository.findById(id);
        if (postOpt.isPresent()) {
            Post post = postOpt.get();
            postMapper.updateEntity(post, dto);
            Post saved = postRepository.save(post);
            return Optional.of(postMapper.toDto(saved));
        }
        return Optional.empty();
    }

    @Override
    public boolean deletePost(Long id) {
        if (postRepository.existsById(id)) {
            postRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean updatePostStatus(Long id, String status) {
        Optional<Post> postOpt = postRepository.findById(id);
        if (postOpt.isPresent()) {
            Post post = postOpt.get();
            post.setStatus(status);
            post.setUpdatedAt(LocalDateTime.now());
            postRepository.save(post);
            return true;
        }
        return false;
    }
} 