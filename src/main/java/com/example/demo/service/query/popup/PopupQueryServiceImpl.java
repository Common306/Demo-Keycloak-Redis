package com.example.demo.service.query.popup;

import com.example.demo.cache.ExceptionCache;
import com.example.demo.dto.response.ResponseCode;
import com.example.demo.entities.Popup;
import com.example.demo.entities.PopupId;
import com.example.demo.exception.CustomizeException;
import com.example.demo.repository.query.ExceptionQueryRepository;
import com.example.demo.repository.query.LanguageQueryRepository;
import com.example.demo.repository.query.PopupButtonQueryRepository;
import com.example.demo.repository.query.PopupQueryRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class PopupQueryServiceImpl implements PopupQueryService {

    private final PopupQueryRepository popupQueryRepository;

    private final PopupButtonQueryRepository popupButtonQueryRepository;

    private final ExceptionQueryRepository exceptionQueryRepository;

    private final LanguageQueryRepository languageQueryRepository;

    private final ExceptionCache exceptionCache;

    @Override
    public Popup getExceptionByIdAndLanguage(int exceptionId, String languageId) {
        Popup popup = exceptionCache.getException(exceptionId, languageId);
        if (popup != null) {
            return popup;
        }
        popup = getPopupFromDB(exceptionId, languageId);
        exceptionCache.setException(popup);
        return popup;
    }

    @Override
    public boolean isExistById(int responseCode, String lang) {
        PopupId popupId = new PopupId(responseCode, lang);
        return popupQueryRepository.existsById(popupId);
    }

    private Popup getPopupFromDB(int exceptionId, String languageId) {
        PopupId popupId = new PopupId(exceptionId, languageId);
        Optional<Popup> popup = popupQueryRepository.findById(popupId);
        if (!popup.isPresent()) {
            throw new CustomizeException(ResponseCode.NOT_FOUND.getCode());
        }
        return popup.get();
    }

    @Override
    public void checkValidWhenCreate(Popup popup) {
        boolean isExist = isExistPopupInDatabase(popup.getException().getExceptionId(), popup.getLanguage().getLanguageId());

        if (isExist) {
            throw new CustomizeException(ResponseCode.NOT_IMPLEMENT.getCode());
        }

        if (!isValidAttribute(popup)) {
            throw new CustomizeException(ResponseCode.NOT_IMPLEMENT.getCode());
        }
    }

    @Override
    public void checkValidWhenUpdate(int idExceptionUpdate, String idLanguageUpdate, Popup popup) {
        boolean isExist = isExistPopupInDatabase(idExceptionUpdate, idLanguageUpdate);
        if (!isExist) {
            throw new CustomizeException(ResponseCode.NOT_FOUND.getCode());
        }

        if (!isValidAttribute(popup)) {
            throw new CustomizeException(ResponseCode.NOT_IMPLEMENT.getCode());
        }
        if (popup.getException().getExceptionId() != idExceptionUpdate
                || !popup.getLanguage().getLanguageId().equals(idLanguageUpdate)) {
            throw new CustomizeException(ResponseCode.NOT_IMPLEMENT.getCode());
        }

    }

    @Override
    public void checkValidWhenDelete(int idExceptionUpdate, String idLanguageUpdate) {
        boolean isExistInDatabase = isExistPopupInDatabase(idExceptionUpdate, idLanguageUpdate);
        if (!isExistInDatabase) {
            throw new CustomizeException(ResponseCode.NOT_FOUND.getCode());
        }
    }

    private boolean isExistPopupInDatabase(int exceptionId, String languageId) {
        PopupId popupId = new PopupId(exceptionId, languageId);
        return popupQueryRepository.existsById(popupId);
    }

    private boolean isValidAttribute(Popup popup) {
        if (!popupButtonQueryRepository.existsById(popup.getPopupButton().getPopupButtonId())
                || !exceptionQueryRepository.existsById(popup.getException().getExceptionId())
                || !languageQueryRepository.existsById(popup.getLanguage().getLanguageId())) {
            return false;
        }
        return true;
    }
}
