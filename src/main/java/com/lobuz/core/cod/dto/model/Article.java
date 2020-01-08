package com.lobuz.core.cod.dto.model;

import com.couchbase.client.java.repository.annotation.Id;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.couchbase.core.mapping.Document;

import java.time.LocalDateTime;

@Builder
@Data
@Document
public class Article {

    @Id
    private String id;

    private String title;

    private String content;

    private String authorId;

    private String category;

    private String type;

    private LocalDateTime creationTime;


}
