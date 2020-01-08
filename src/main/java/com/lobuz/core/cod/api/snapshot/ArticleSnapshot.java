package com.lobuz.core.cod.api.snapshot;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class ArticleSnapshot {

    private String id;

    private String title;

    private String content;

    private String authorId;

    private String category;

    private String type;

    private LocalDateTime creationTime;
}

