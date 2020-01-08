package com.lobuz.core.cod.configuration;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.validation.constraints.NotNull;

@Data
@Configuration
@ConfigurationProperties(prefix = "data.path")
public class FilePathProperties {

    @NotNull
    private String categories;
}
