package com.example.demo.config.internationalization;

import com.example.demo.repository.query.LanguageQueryRepository;
import com.example.demo.service.query.popup.PopupQueryService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
@AllArgsConstructor
public class LanguageConfig{

    private final HttpServletRequest request;
    private final PopupQueryService popupQueryService;
    private final String LANGUAGE_DEFAULT = "en";

    public String getLanguage(int responseCode) {

        String lang = request.getParameter("lang");
        boolean isExistLanguage = popupQueryService.isExistById(responseCode, lang);
        if(!isExistLanguage) {
            return LANGUAGE_DEFAULT;
        }
        return lang;
    }
}
