package com.lobuz.core.cod.data;

public enum DocumentTypeEnum {

    ARTICLE("article");

    private final String type;


    DocumentTypeEnum(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
