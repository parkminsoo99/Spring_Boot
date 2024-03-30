package com.example.blogmaking.controller;

import com.example.blogmaking.domain.Article;
import com.example.blogmaking.dto.AddArticleRequest;
import com.example.blogmaking.dto.UpdateArticleRequest;
import com.example.blogmaking.repository.BlogRepository;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class BlogApiControllerTest {
    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    protected ObjectMapper objectMapper;

    @Autowired
    private WebApplicationContext context;

    @Autowired
    BlogRepository blogRepository;

    @BeforeEach
    public void mockMvcSetUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
        blogRepository.deleteAll();
    }
    @DisplayName("AddArticle : 블로그 글 추가에 성공한다.")
    @Test
    public void addAritcle() throws Exception{
        //given
        final String url = "/api/articles";
        final String title = "title";
        final String content = "content";
        final AddArticleRequest userRequest = new AddArticleRequest(title,content);
        final String requestBody = objectMapper.writeValueAsString(userRequest);

        //when
        ResultActions result = mockMvc.perform(post(url)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(requestBody));
        //then
        result.andExpect(status().isCreated());
        List<Article> articles = blogRepository
                .findAll();

        assertThat(articles.size()).isEqualTo(1);
        assertThat(articles.get(0).getTitle()).isEqualTo(title);
        assertThat(articles.get(0).getContent()).isEqualTo(content);
    }
    @DisplayName("findAllArticle 조회에 성공")
    @Test
    //given
    public void findAllAritcles() throws Exception {
        final String url = "/api/articles";
        final String title = "title";
        final String content = "content";

        blogRepository.save(Article.builder().title(title).content(content).build());

        //when
        final ResultActions actions = mockMvc.perform(get(url).accept(MediaType.APPLICATION_JSON));
        //then
        actions.andExpect(status().isOk())
                .andExpect(jsonPath("$[0].content").value(content))
                .andExpect(jsonPath("$[0].title").value(title));
    }

    @DisplayName("FindById에 성공한다")
    @Test
    public void findByIdArticle() throws Exception{
        final String url ="/api/articles/{id}";
        final String title = "title";
        final String content = "content";

        Article savedArticle = blogRepository.save(Article.builder().title(title).content(content).build());

        final ResultActions actions = mockMvc.perform(get(url, savedArticle.getId()));

        actions.andExpect(status().isOk())
                .andExpect(jsonPath("$.content").value(content))
                .andExpect(jsonPath("$.title").value(title));
    }
    @DisplayName("DeleteId에 성공한다")
    @Test
    public void deleteId() throws Exception{
        final String url="/api/articles/{id}";
        final String title = "title";
        final String content ="content";

         Article saved = blogRepository.save(Article.builder().title(title).content(content).build());

         mockMvc.perform(delete(url,saved.getId())).andExpect(status().isOk());

         List<Article> articles = blogRepository.findAll();

         assertThat(articles).isEmpty();
    }
    @DisplayName("update에 성공한다.")
    @Test
    public void updateid() throws Exception{
        final String url="/api/articles/{id}";
        final String title ="title";
        final String content="content";

        Article saved = blogRepository.save(Article.builder().content(content).title(title).build());
        final String newTitle = "new title";
        final String newContent = "new content";

        UpdateArticleRequest request = new UpdateArticleRequest(newTitle,newContent);

        ResultActions actions = mockMvc.perform(put(url, saved.getId())
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(request)));

        actions.andExpect(status().isOk());
        Article article = blogRepository.findById(saved.getId()).get();
        assertThat(article.getTitle()).isEqualTo(newTitle);
        assertThat(article.getContent()).isEqualTo(newContent);
    }
}