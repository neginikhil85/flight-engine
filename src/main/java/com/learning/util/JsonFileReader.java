package com.learning.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;

import java.nio.file.Files;
import java.nio.file.Paths;

@Slf4j
public class JsonFileReader {

    private final ObjectMapper objectMapper = new ObjectMapper();

    {
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    }

    public <T> T readFile(String filePath, TypeReference<T> type) {
        try {
            byte[] jsonData = Files.readAllBytes(Paths.get(filePath));
            return objectMapper.readValue(jsonData, type);
        } catch (Exception e) {
            log.error("[JsonFileReader::readFile] Error while reading json data Ex: {}", e.getMessage());
            return null;
        }
    }
}
