package com.github_gomestkd.restwithspringbootandmysqlerudioudemy.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ObjectMapperConfig {

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();

        SimpleFilterProvider simpleFilterProvider = new SimpleFilterProvider()
                .addFilter(
                    "PersonFilter",
                    SimpleBeanPropertyFilter.serializeAllExcept("password")
                );

        objectMapper.setFilterProvider(simpleFilterProvider);

        return objectMapper;
    }
}
