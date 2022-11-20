package com.example.demo.utils;

import org.springframework.stereotype.Component;

@Component
public class ModelMapper {

    private final static org.modelmapper.ModelMapper mapper = new org.modelmapper.ModelMapper();

    public static <T> T map(Object sourceObject, Class<T> resultObject) {

        return mapper.map(sourceObject, resultObject);
    }
}
