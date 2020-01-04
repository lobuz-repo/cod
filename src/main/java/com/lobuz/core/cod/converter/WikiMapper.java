package com.lobuz.core.cod.converter;

import com.lobuz.core.cod.api.request.ArticleAddRequest;
import com.lobuz.core.cod.api.snapshot.ArticleSnapshot;
import com.lobuz.core.cod.dto.generator.IdGenerator;
import com.lobuz.core.cod.dto.model.Article;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class WikiMapper {

    private final IdGenerator generator;

    public WikiMapper(IdGenerator generator) {
        this.generator = generator;
    }

    public Article mapToArticle(ArticleAddRequest request) {
        return Article.builder()
                .id(generator.getId())
                .title(request.getTitle())
                .content(request.getContent())
                .authorId(request.getAuthorId())
                .creationTime(getCurrentTime())
                .build();
//        return new Article(request.getTitle(), request.getContent(), request.getUserId(), getCurrentTime());
    }

    public ArticleSnapshot mapArticleToSnapshot(Article article) {
        return ArticleSnapshot.builder()
                .id(article.getId())
                .title(article.getTitle())
                .content(article.getContent())
                .authorId(article.getAuthorId())
                .creationTime(article.getCreationTime())
                .build();
    }

    private LocalDateTime getCurrentTime() {
        return LocalDateTime.now();
    }

}
