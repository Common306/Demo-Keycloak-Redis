package com.example.demo.handle;

import com.example.demo.dto.request.RequestData;
import com.example.demo.dto.response.ResponseData;

public interface IHandler<T extends RequestData, I extends ResponseData> {
    I handle(T requestData);
}
