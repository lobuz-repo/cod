package com.lobuz.core.cod.api.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ArticleAddRequest {

    @NotNull
    private String authorId;

    @NotNull
    private String title;

    @NotNull
    private String content;

    @NotNull
    private String category;
}
