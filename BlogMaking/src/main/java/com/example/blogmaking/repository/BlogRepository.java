package com.example.blogmaking.repository;

import com.example.blogmaking.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Article, Long> {
}
