package com.example.demo.exception;

import com.example.demo.dto.response.BaseResponse;
import com.example.demo.dto.response.ResponseCode;
import com.google.gson.Gson;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class CustomOAuth2AuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException ex) throws IOException {
//        String message = "Access denied";
        String message = ex.getLocalizedMessage();
        BaseResponse baseResponse = new BaseResponse(ResponseCode.FORBIDDEN.getCode(), null, message);
        response.setStatus(403);
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        String json = new Gson().toJson(baseResponse);
        response.getWriter().print(json);
    }
}
