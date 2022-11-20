package com.example.demo.exception;

import com.example.demo.dto.response.BaseResponse;
import com.example.demo.dto.response.ResponseCode;
import com.google.gson.Gson;
import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Component
public class CustomOAuth2AccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException ex) throws IOException, ServletException {
        String message = ex.getLocalizedMessage();
        BaseResponse baseResponse = new BaseResponse(ResponseCode.FORBIDDEN.getCode(), null, message);
        response.setStatus(403);
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        String json = new Gson().toJson(baseResponse);
        response.getWriter().print(json);
    }
}
