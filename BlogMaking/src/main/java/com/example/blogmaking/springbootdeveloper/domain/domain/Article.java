package com.example.blogmaking.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Builder;
import org.springframework.data.annotation.Id;

@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", updatable=false)
    private Long id;

    @Column(name="title", nullable = false)
    private String title;

    @Column(name ="content", nullable = false)
    private  String content;

    @Builder
    public Article(String title, String content){
        this.title = title;
        this.content = content;
    }
}