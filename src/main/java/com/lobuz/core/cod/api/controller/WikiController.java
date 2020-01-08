package com.lobuz.core.cod.api.controller;

import com.lobuz.core.cod.api.request.ArticleAddRequest;
import com.lobuz.core.cod.api.snapshot.ArticleSnapshot;
import com.lobuz.core.cod.data.CategoryModel;
import com.lobuz.core.cod.service.ManagementWikiService;
import com.lobuz.core.cod.service.WikiService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/wiki/article")
public class WikiController {

    private final WikiService service;
    private final ManagementWikiService managementWikiService;

    public WikiController(WikiService service, ManagementWikiService managementWikiService) {
        this.service = service;
        this.managementWikiService = managementWikiService;
    }

    @GetMapping
    public List<ArticleSnapshot> getAllArticles() {
        return service.getAllArticles();
    }

    @GetMapping("/{articleId}")
    public ArticleSnapshot getArticleById(@PathVariable String articleId) {
        return service.getArticleById(articleId);
    }

    @GetMapping("/author/{authorId}")
    public List<ArticleSnapshot> getArticleByAuthorId(@PathVariable String authorId) {
        return service.getArticleByAuthorId(authorId);
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

    @GetMapping("/file")
    public List<CategoryModel> getArticleCategories() {
        return managementWikiService.getArticleCategories();
    }

}

