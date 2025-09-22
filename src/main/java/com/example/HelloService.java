package com.example;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;

public class HelloService {
    private static final Logger logger = LogManager.getLogger(HelloService.class);
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public String greet(String name) {
        logger.debug("greet() called with name='{}'", name);

        if (StringUtils.isBlank(name)) {
            logger.info("Name was blank. Using default greeting.");
            return "Hello";
        }

        String message = "Hello, " + name + "!";
        logger.info("Greeting generated: {}", message);

        try {
            String json = objectMapper.writeValueAsString(Map.of("message", message, "name", name));
            logger.debug("Greeting JSON: {}", json);
        } catch (JsonProcessingException e) {
            logger.warn("Failed to serialize greeting to JSON", e);
        }
        return message;
    }
}



