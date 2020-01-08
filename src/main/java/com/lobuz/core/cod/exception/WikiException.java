package com.lobuz.core.cod.exception;

import org.springframework.http.HttpStatus;

public class WikiException extends CoreException {

    private static final int ARTICLE_NOT_FOUND = 420;

    public WikiException(int code, String message, String description, HttpStatus status) {
        super(code, message, description, status);
    }

    protected WikiException(ErrorDetails errorDetails) {
        super(errorDetails);
    }

    public static WikiException withErrorDetails(ErrorDetails errorDetails) {
        return new WikiException(errorDetails);
    }

    public static WikiException articleNotFound() {
        return new WikiException(ARTICLE_NOT_FOUND, "ARTICLE_NOT_FOUND", "Article not found", HttpStatus.NOT_FOUND);
    }

}
