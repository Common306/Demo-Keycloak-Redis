package com.example.demo.service.command.popup;

import com.example.demo.cache.ExceptionCache;
import com.example.demo.dto.response.ResponseCode;
import com.example.demo.entities.Popup;
import com.example.demo.entities.PopupId;
import com.example.demo.exception.CustomizeException;
import com.example.demo.repository.command.PopupCommandRepository;
import com.example.demo.repository.query.ExceptionQueryRepository;
import com.example.demo.repository.query.LanguageQueryRepository;
import com.example.demo.repository.query.PopupButtonQueryRepository;
import com.example.demo.repository.query.PopupQueryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PopupCommandServiceImpl implements PopupCommandService{

    private final PopupCommandRepository popupCommandRepository;

    private final ExceptionCache exceptionCache;

    @Override
    public void createPopup(Popup popup) {

        popupCommandRepository.save(popup);

    }

    @Override
    public void updatePopup(int idExceptionUpdate, String idLanguageUpdate, Popup popup) {

        exceptionCache.deleteException(idExceptionUpdate, idLanguageUpdate);

        popupCommandRepository.save(popup);

    }

    @Override
    public void deletePopup(int exceptionId, String languageId) {

        exceptionCache.deleteException(exceptionId, languageId);

        PopupId popupId = new PopupId(exceptionId, languageId);
        popupCommandRepository.deleteById(popupId);

    }

}
