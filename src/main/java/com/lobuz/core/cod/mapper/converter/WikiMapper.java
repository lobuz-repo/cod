package com.lobuz.core.cod.mapper.converter;

import com.lobuz.core.cod.api.request.ArticleAddRequest;
import com.lobuz.core.cod.api.snapshot.ArticleSnapshot;
import com.lobuz.core.cod.data.DocumentTypeEnum;
import com.lobuz.core.cod.dto.generator.IdGenerator;
import com.lobuz.core.cod.dto.model.Article;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class WikiMapper {

    public Article converter(ArticleAddRequest request) {
        return Article.builder()
                .id(IdGenerator.getId())
                .title(request.getTitle())
                .content(request.getContent())
                .authorId(request.getAuthorId())
                .creationTime(getCurrentTime())
                .type(DocumentTypeEnum.ARTICLE.getType())
                .category(request.getCategory())
                .build();
    }

    public ArticleSnapshot converter(Article article) {
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
