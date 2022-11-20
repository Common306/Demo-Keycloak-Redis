package com.example.demo.service.command.language;

import com.example.demo.entities.Language;
import com.example.demo.repository.command.LanguageCommandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LanguageCommandServiceImpl implements LanguageCommandService{

    private final LanguageCommandRepository languageCommandRepository;

    @Override
    public void createLanguage(Language language) {
        languageCommandRepository.save(language);
    }
}
