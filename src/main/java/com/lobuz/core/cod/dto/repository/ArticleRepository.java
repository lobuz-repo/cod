package com.lobuz.core.cod.dto.repository;

import com.lobuz.core.cod.api.snapshot.ArticleSnapshot;
import com.lobuz.core.cod.dto.model.Article;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository  extends CouchbaseRepository<Article, String> {

//    Page<Article> findAllByAuthorId(Pageable pageable, Long authorId);
//
//    boolean existsArticleByAuthorId(Long authorId);
//
//    void deleteAllByAuthorId(Long authorId);
}
