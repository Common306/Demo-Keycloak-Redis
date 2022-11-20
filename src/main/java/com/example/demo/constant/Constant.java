package com.example.demo.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Constant {
    public static final String UNDERSCORE = "_";
    public static final String DOT = ".";
    public static final String COMMA = ",";
}
