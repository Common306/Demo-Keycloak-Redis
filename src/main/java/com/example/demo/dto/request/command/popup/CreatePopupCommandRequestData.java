package com.example.demo.dto.request.command.popup;

import com.example.demo.dto.request.command.CommandRequestData;
import com.example.demo.entities.Exception;
import com.example.demo.entities.Language;
import com.example.demo.entities.PopupButton;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePopupCommandRequestData extends CommandRequestData {
    private String title;

    private String content;

    private PopupButton popupButton;

    private Exception exception;

    private Language language;
}
