package com.lobuz.core.cod.dto.generator;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public abstract class IdGenerator {

    public static String getId() {
        return UUID.randomUUID().toString();
    }
}
