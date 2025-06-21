package com.example.mobileapi.repository;

import com.example.mobileapi.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PostRepository extends JpaRepository<Post, Long>, JpaSpecificationExecutor<Post> {
    // Có thể bổ sung các hàm custom nếu cần
} 