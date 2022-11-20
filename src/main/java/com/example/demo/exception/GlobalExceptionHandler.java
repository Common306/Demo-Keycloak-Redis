package com.example.demo.exception;

import com.example.demo.config.internationalization.LanguageConfig;
import com.example.demo.dto.response.BaseResponse;
import com.example.demo.dto.response.ResponseCode;
import com.example.demo.entities.Popup;
import com.example.demo.service.query.popup.PopupQueryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import javax.ws.rs.NotAuthorizedException;

@RestControllerAdvice
@AllArgsConstructor
public class GlobalExceptionHandler {

    private final PopupQueryService popupQueryService;

    private final LanguageConfig languageConfig;

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<BaseResponse<?>> accessDenied() {
        BaseResponse response = new BaseResponse(ResponseCode.FORBIDDEN.getCode(), "ACCESS DENIED");
        return new ResponseEntity<>(response, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(NotAuthorizedException.class)
    public ResponseEntity<BaseResponse<?>> handleLoginFail() {
        BaseResponse response = new BaseResponse(ResponseCode.NOT_AUTHORIZED.getCode(), "NOT AUTHORIZED");
        return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
    }


    @ExceptionHandler(CustomizeException.class)
    public ResponseEntity<BaseResponse<?>> handleException(CustomizeException ex) {

        Popup popup = getPopupException(ex.getResponseCode(), languageConfig.getLanguage(ex.getResponseCode()));

        BaseResponse response = new BaseResponse(ex.getResponseCode(), popup);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    public Popup getPopupException(int exceptionId, String languageId) {
        return popupQueryService.getExceptionByIdAndLanguage(exceptionId, languageId);
    }

}
