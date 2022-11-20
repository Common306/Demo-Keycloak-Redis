package com.example.demo.dto.response.query.popup;

import com.example.demo.dto.response.query.QueryResponseData;
import com.example.demo.entities.Exception;
import com.example.demo.entities.Language;
import com.example.demo.entities.PopupButton;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetPopupQueryResponseData extends QueryResponseData {

    private String title;

    private String content;

    private PopupButton popupButton;

    private Exception exception;

    private Language language;
}
