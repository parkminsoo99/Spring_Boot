package com.example.blogmaking.springbootdeveloper.domain.repository;

import com.example.blogmaking.springbootdeveloper.domain.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Article,Long> {
}
