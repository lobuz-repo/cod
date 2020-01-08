package com.lobuz.core.cod.service;

import com.lobuz.core.cod.api.request.ArticleAddRequest;
import com.lobuz.core.cod.api.snapshot.ArticleSnapshot;
import com.lobuz.core.cod.data.DocumentTypeEnum;
import com.lobuz.core.cod.dto.model.Article;
import com.lobuz.core.cod.dto.repository.ArticleRepository;
import com.lobuz.core.cod.exception.WikiException;
import com.lobuz.core.cod.mapper.converter.WikiMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.nonNull;


@Service
public class WikiServiceImpl implements WikiService {

    private final ArticleRepository repository;
    private final WikiMapper mapper;

    public WikiServiceImpl(ArticleRepository repository, WikiMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public String addArticle(ArticleAddRequest request) {
        Article article = mapper.converter(request);

        repository.save(article);
        return article.getId();
    }

    @Override
    @Transactional(readOnly = true)
    public ArticleSnapshot getArticleById(String articleId) {
        final Article article = getArticle(articleId);
        return mapper.converter(article);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ArticleSnapshot> getArticleByAuthorId(String authorId) {

        List<Article> articles = repository.findAllByAuthorId(authorId);

        if (nonNull(articles) && !articles.isEmpty()) {
            return articles.stream()
                    .map(mapper::converter)
                    .collect(Collectors.toList());
        }
        throw WikiException.articleNotFound();
    }

    @Override
    @Transactional(readOnly = true)
    public List<ArticleSnapshot> getAllArticles() {
        List<Article> articles = repository.findAllByType(DocumentTypeEnum.ARTICLE.getType());
        return articles.stream()
                .map(mapper::converter)
                .collect(Collectors.toList());
    }


    @Override
    @Transactional
    public void deleteArticleById(String articleId) {
        if (repository.existsById(articleId)) {
            repository.deleteById(articleId);
        } else {
            throw WikiException.articleNotFound();
        }
    }

    @Override
    @Transactional
    public void deleteArticleByAuthorId(String authorId) {
        try {
            repository.deleteAllByAuthorId(authorId);
        } catch (Exception e) {
            throw WikiException.articleNotFound();
        }
    }

    private Article getArticle(String articleId) {
        return repository.findById(articleId).orElseThrow(WikiException::articleNotFound);
    }

}
