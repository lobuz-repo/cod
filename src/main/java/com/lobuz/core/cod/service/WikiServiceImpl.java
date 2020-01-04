package com.lobuz.core.cod.service;

import com.lobuz.core.cod.api.request.ArticleAddRequest;
import com.lobuz.core.cod.api.snapshot.ArticleSnapshot;
import com.lobuz.core.cod.converter.WikiMapper;
import com.lobuz.core.cod.dto.model.Article;

import com.lobuz.core.cod.dto.repository.ArticleRepository;
import com.lobuz.core.cod.exception.WikiException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


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
        Article article = mapper.mapToArticle(request);

        repository.save(article);
        return article.getId();
    }

    @Override
    @Transactional(readOnly = true)
    public ArticleSnapshot getArticleById(String articleId) {
        final Article article = getArticle(articleId);
        return mapper.mapArticleToSnapshot(article);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ArticleSnapshot> getArticleByAuthorId(Pageable pageable, String authorId) {

//        if (repository.existsArticleByAuthorId(authorId)) {
//            return repository.findAllByAuthorId(pageable, authorId)
//                    .map(mapper::mapArticleToSnapshot);
//        }
        throw WikiException.articleNotFound();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ArticleSnapshot> getAllArticles(Pageable pageable) {
//        return repository.findAll(pageable)
//                .map(mapper::mapArticleToSnapshot);
        return null;
    }

    @Override
    @Transactional
    public void deleteArticleById(String articleId) {
//        if (repository.existsById(articleId)) {
//            repository.deleteById(articleId);
//        } else {
//            throw WikiException.articleNotFound();
//        }
    }

    @Override
    @Transactional
    public void deleteArticleByAuthorId(String authorId) {
//        if (repository.existsArticleByAuthorId(authorId)) {
//            repository.deleteAllByAuthorId(authorId);
//        } else {
//            throw WikiException.articleNotFound();
//        }
    }

    private Article getArticle(String articleId) {
        return repository.findById(articleId).orElseThrow(WikiException::articleNotFound);
    }

}
