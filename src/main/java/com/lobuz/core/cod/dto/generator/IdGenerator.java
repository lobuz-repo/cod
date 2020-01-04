package com.lobuz.core.cod.dto.generator;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class IdGenerator {

    public String getId() {
        return UUID.randomUUID().toString();
    }

}
