package com.example.demo.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponse<T extends ResponseData> {
    private int responseCode;

    private T responseData;

    private Object message;

    public BaseResponse(int responseCode, Object message) {
        this.responseCode = responseCode;
        this.message = message;
    }
}
