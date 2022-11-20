package com.example.demo.handle.command.popup;

import com.example.demo.dto.request.command.popup.CreatePopupCommandRequestData;
import com.example.demo.dto.response.ResponseCode;
import com.example.demo.dto.response.command.popup.CreatePopupCommandResponseData;
import com.example.demo.entities.Popup;
import com.example.demo.handle.command.CommandHandler;
import com.example.demo.service.command.popup.PopupCommandService;
import com.example.demo.service.query.popup.PopupQueryService;
import com.example.demo.utils.ModelMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CreatePopupCommandHandler extends CommandHandler<CreatePopupCommandRequestData, CreatePopupCommandResponseData> {

    private final PopupCommandService popupCommandService;

    private final PopupQueryService popupQueryService;

    @Override
    public CreatePopupCommandResponseData handle(CreatePopupCommandRequestData requestData) {

        Popup popup = ModelMapper.map(requestData, Popup.class);

        popupQueryService.checkValidWhenCreate(popup);

        popupCommandService.createPopup(popup);

        return new CreatePopupCommandResponseData(ResponseCode.CREATED, "create popup successful");
    }
}
