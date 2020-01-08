package com.lobuz.core.cod.dto.repository;

import com.lobuz.core.cod.dto.model.Article;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends CouchbaseRepository<Article, String> {


    List<Article> findAllByType(String type);

    List<Article> findAllByAuthorId(String authorId);

    List<Article> deleteAllByAuthorId(String authorId);
}
