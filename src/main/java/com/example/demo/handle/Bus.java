package com.example.demo.handle;

import com.example.demo.dto.request.RequestData;
import com.example.demo.dto.response.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Bus<T extends RequestData, I extends ResponseData>{
    @Autowired
    Registry registry;

    public I excute(T request) {
        IHandler handler = registry.getHandler(request);
        I response = (I)handler.handle(request);
        return response;
    };
}
