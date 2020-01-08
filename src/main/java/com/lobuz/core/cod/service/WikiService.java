package com.lobuz.core.cod.service;

import com.lobuz.core.cod.api.request.ArticleAddRequest;
import com.lobuz.core.cod.api.snapshot.ArticleSnapshot;

import java.util.List;

public interface WikiService {

    String addArticle(ArticleAddRequest request);

    ArticleSnapshot getArticleById(String articleId);

    List<ArticleSnapshot> getArticleByAuthorId(String authorId);

    List<ArticleSnapshot> getAllArticles();

    void deleteArticleById(String articleId);

    void deleteArticleByAuthorId(String authorId);

}
