package com.lobuz.core.cod.api.controller;

import com.lobuz.core.cod.api.request.ArticleAddRequest;
import com.lobuz.core.cod.api.snapshot.ArticleSnapshot;
import com.lobuz.core.cod.service.WikiService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/wiki/article")
@AllArgsConstructor
public class WikiController {

    private final WikiService service;

    @GetMapping
    public Page<ArticleSnapshot> getAllArticles(Pageable pageable) {
        return service.getAllArticles(pageable);
    }

    @GetMapping("/{articleId}")
    public ArticleSnapshot getArticleById(@PathVariable String articleId) {
        return service.getArticleById(articleId);
    }

    @GetMapping("/author/{authorId}")
    public Page<ArticleSnapshot> getArticleByAuthorId(Pageable pageable, @PathVariable String authorId) {
        return service.getArticleByAuthorId(pageable, authorId);
    }

    @PostMapping("/add")
    public String addArticle(@RequestBody @Valid ArticleAddRequest request) {
        return service.addArticle(request);
    }

    @DeleteMapping("/delete/{articleId}")
    public void deleteArticleById(@PathVariable String articleId) {
        service.deleteArticleById(articleId);
    }

    @DeleteMapping("/delete/author/{authorId}")
    public void deleteArticleByAuthorId(@PathVariable String authorId) {
        service.deleteArticleByAuthorId(authorId);
    }

}

