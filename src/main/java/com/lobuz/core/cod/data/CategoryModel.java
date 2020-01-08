package com.lobuz.core.cod.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryModel {

    private String id;
    private String category;

    @Override
    public String toString() {
        return "CategoryModel{" +
                "id='" + id + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
