package com.lobuz.core.cod.configuration;

import com.lobuz.core.cod.data.CategoryModel;
import com.lobuz.core.cod.mapper.loader.ModelFileLoader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CategoryConfiguration {

    private final ModelFileLoader loader;
    private final FilePathProperties properties;

    public CategoryConfiguration(ModelFileLoader loader, FilePathProperties properties) {
        this.loader = loader;
        this.properties = properties;
    }

    @Bean
    public List<CategoryModel> getCategories() {
        return List.of(loader.fromFile(properties.getCategories(), CategoryModel[].class));
    }
}
