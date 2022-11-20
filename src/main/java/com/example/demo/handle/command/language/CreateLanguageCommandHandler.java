package com.example.demo.handle.command.language;

import com.example.demo.dto.request.command.language.LanguageCommandRequestData;
import com.example.demo.dto.response.ResponseCode;
import com.example.demo.dto.response.command.language.LanguageCommandResponseData;
import com.example.demo.entities.Language;
import com.example.demo.handle.command.CommandHandler;
import com.example.demo.service.command.language.LanguageCommandService;
import com.example.demo.utils.ModelMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CreateLanguageCommandHandler extends CommandHandler<LanguageCommandRequestData, LanguageCommandResponseData> {

    private final LanguageCommandService languageCommandService;

    @Override
    public LanguageCommandResponseData handle(LanguageCommandRequestData requestData) {

        Language language = ModelMapper.map(requestData, Language.class);
        languageCommandService.createLanguage(language);
        return new LanguageCommandResponseData(ResponseCode.CREATED, "create language successful");
    }
}
