package com.example.demo.service.command.popup;

import com.example.demo.entities.Popup;

public interface PopupCommandService {
    void createPopup(Popup popup);

    void updatePopup(int idExceptionUpdate, String idLanguageUpdate, Popup popup);

    void deletePopup(int id, String lang);
}
