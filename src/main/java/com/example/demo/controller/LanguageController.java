package com.example.demo.controller;

import com.example.demo.dto.request.command.language.LanguageCommandRequestData;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class LanguageController extends BaseController{

    @PostMapping("v1/language")
    public ResponseEntity<?> createLanguage(@RequestBody LanguageCommandRequestData requestData) {
        return execute(requestData);
    }
}
