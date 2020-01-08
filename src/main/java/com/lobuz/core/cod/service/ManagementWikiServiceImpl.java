package com.lobuz.core.cod.service;

import com.lobuz.core.cod.configuration.CategoryConfiguration;
import com.lobuz.core.cod.data.CategoryModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ManagementWikiServiceImpl implements ManagementWikiService {

    private final CategoryConfiguration categoryConfiguration;

    public ManagementWikiServiceImpl(CategoryConfiguration categoryConfiguration) {
        this.categoryConfiguration = categoryConfiguration;
    }


    @Override
    public List<CategoryModel> getArticleCategories() {

        List<CategoryModel> categories = categoryConfiguration.getCategories();
        categories.forEach((cat) -> log.info(cat.toString()));
        return categories;
    }
}
