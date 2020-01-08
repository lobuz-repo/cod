package com.lobuz.core.cod.mapper.loader;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URL;

@Slf4j
@Service
public class ModelFileLoader {

    public <T> T fromFile(String filePath, Class<T> modelClass) {
        try {
            URL url = new URL(filePath);
            ObjectMapper mapper = new ObjectMapper();
            return mapper
                    .readValue(url, modelClass);
        } catch (IOException e) {
            log.error("Error during reading content from json file, " + e);
        }
        return null;
    }
}
