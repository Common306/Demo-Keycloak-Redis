package com.example.demo.service.query.popup;

import com.example.demo.entities.Popup;

public interface PopupQueryService {
    Popup getExceptionByIdAndLanguage(int id, String language);

    boolean isExistById(int responseCode, String lang);

    void checkValidWhenCreate(Popup popup);

    void checkValidWhenUpdate(int idExceptionUpdate, String idLanguageUpdate, Popup popup);

    void checkValidWhenDelete(int idExceptionUpdate, String idLanguageUpdate);
}
