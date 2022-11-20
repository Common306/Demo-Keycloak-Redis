package com.example.demo.controller;

import com.example.demo.dto.request.command.exception.ExceptionCommandRequestData;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class ExceptionController extends BaseController{

    @PostMapping("v1/exception")
    public ResponseEntity<?> createException(@RequestBody ExceptionCommandRequestData requestData) {
        // log
        return execute(requestData);
        // log
    }
}
