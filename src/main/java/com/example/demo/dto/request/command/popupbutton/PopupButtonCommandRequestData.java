package com.example.demo.dto.request.command.popupbutton;

import com.example.demo.dto.request.command.CommandRequestData;
import com.example.demo.entities.Language;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PopupButtonCommandRequestData extends CommandRequestData {

    private String buttonLeft;

    private String buttonRight;

    private Language language;
}
