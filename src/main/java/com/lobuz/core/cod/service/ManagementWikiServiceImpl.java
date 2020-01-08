package com.lobuz.core.cod.service;

import com.lobuz.core.cod.data.CategoryModel;
import com.lobuz.core.cod.mapper.loader.ModelFileLoader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ManagementWikiServiceImpl implements ManagementWikiService {

    private final ModelFileLoader loader;

    public ManagementWikiServiceImpl(ModelFileLoader loader) {
        this.loader = loader;
    }

    @Override
    public CategoryModel[] getArticleCategories() {
        String filePath = "classpath:data/category.json";

        CategoryModel[] categoryModels = loader.fromFile(filePath, CategoryModel[].class);
        for (CategoryModel cat : categoryModels){
            log.info(cat.toString());
        }
        return categoryModels;
    }
}
