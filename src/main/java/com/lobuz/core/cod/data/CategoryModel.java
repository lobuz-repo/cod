package com.lobuz.core.cod.data;

import lombok.Data;

@Data
public class CategoryModel {

    private String id;
    private String category;

    @Override
    public String toString() {
        return "read from JSON file {" +
                "id='" + id + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
