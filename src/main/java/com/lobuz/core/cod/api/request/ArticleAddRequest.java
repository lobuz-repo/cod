package com.lobuz.core.cod.api.request;

import lombok.Data;

@Data
public class ArticleAddRequest {

    private String authorId;
    private String title;
    private String content;
}
