package com.example.demo.controller;

import com.example.demo.dto.request.command.popup.CreatePopupCommandRequestData;
import com.example.demo.dto.request.command.popup.DeletePopupCommandRequestData;
import com.example.demo.dto.request.command.popup.UpdatePopupCommandRequestData;
import com.example.demo.dto.request.query.popup.GetPopupQueryRequestData;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PopupController extends BaseController{

    @GetMapping("v1/popup/{lang}/{id}")
    public ResponseEntity<?> getPopup(@PathVariable("lang") String lang, @PathVariable("id") Integer id) {
        GetPopupQueryRequestData requestData = new GetPopupQueryRequestData(id, lang);
        return execute(requestData);
    }

    @PostMapping("v1/popup")
    public ResponseEntity<?> createPopup(@RequestBody CreatePopupCommandRequestData requestData) {
        return execute(requestData);
    }

    @PutMapping("v1/popup/{lang}/{id}")
    public ResponseEntity<?> updatePopup(@PathVariable("lang") String lang , @PathVariable("id") Integer id, @RequestBody UpdatePopupCommandRequestData requestData) {
        requestData.setIdExceptionUpdate(id);
        requestData.setIdLanguageUpdate(lang);
        return execute(requestData);
    }

    @DeleteMapping("v1/popup/{lang}/{id}")
    public ResponseEntity<?> deletePopup(@PathVariable("lang") String lang, @PathVariable("id") int id) {
        DeletePopupCommandRequestData requestData = new DeletePopupCommandRequestData(id, lang);
        return execute(requestData);
    }
}
