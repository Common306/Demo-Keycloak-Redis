package com.example.demo.dto.response;

public enum ResponseCode {
    NOT_FOUND_USER(100), OK(200), CREATED(201),
    NOT_AUTHORIZED(401), FORBIDDEN(403), NOT_FOUND(404),
    NOT_IMPLEMENT(501);
    private int code;

    ResponseCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }
}
