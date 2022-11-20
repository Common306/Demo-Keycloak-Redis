package com.example.demo.utils;

public class StringUtils {
    public static boolean isEmpty(String input) {
        return input.trim().isEmpty() || input == null;
    }
}
