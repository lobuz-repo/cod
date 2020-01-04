package com.lobuz.core.cod.api.snapshot;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;

import java.time.LocalDateTime;

@Builder
@Data
@Document
public class ArticleSnapshot {

    @Id
    private String id;

    private String title;

    private String content;

    private String authorId;

    private LocalDateTime creationTime;
}

