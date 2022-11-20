package com.example.demo.controller;

import com.example.demo.dto.request.command.popupbutton.PopupButtonCommandRequestData;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class PopupButtonController extends BaseController {

    @PostMapping("v1/button")
    public ResponseEntity<?> createPopupButton(@RequestBody PopupButtonCommandRequestData requestData) {
        return execute(requestData);
    }
}
