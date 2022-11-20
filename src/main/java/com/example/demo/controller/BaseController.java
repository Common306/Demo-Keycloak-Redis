package com.example.demo.controller;

import com.example.demo.dto.request.RequestData;
import com.example.demo.dto.response.BaseResponse;
import com.example.demo.dto.response.ResponseCode;
import com.example.demo.dto.response.ResponseData;
import com.example.demo.handle.Bus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class BaseController {
    @Autowired
    protected Bus bus;

    protected <T extends RequestData, I extends ResponseData> ResponseEntity<BaseResponse<I>> execute(T request) {
        ResponseData responseData = bus.excute(request);
        BaseResponse response = new BaseResponse(ResponseCode.OK.getCode(), responseData, "SUCCESSFULLY");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
