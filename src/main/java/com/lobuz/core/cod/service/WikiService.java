package com.lobuz.core.cod.service;

import com.lobuz.core.cod.api.request.ArticleAddRequest;
import com.lobuz.core.cod.api.snapshot.ArticleSnapshot;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface WikiService {

    String addArticle(ArticleAddRequest request);

    ArticleSnapshot getArticleById(String articleId);

    Page<ArticleSnapshot> getArticleByAuthorId(Pageable pageable, String authorId);

    Page<ArticleSnapshot> getAllArticles(Pageable pageable);

    void deleteArticleById(String articleId);

    void deleteArticleByAuthorId(String authorId);

}
