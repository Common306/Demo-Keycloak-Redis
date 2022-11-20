package com.example.demo.handle.command.popupbutton;

import com.example.demo.dto.request.command.popupbutton.PopupButtonCommandRequestData;
import com.example.demo.dto.response.ResponseCode;
import com.example.demo.dto.response.command.popupbutton.PopupButtonCommandResponseData;
import com.example.demo.entities.PopupButton;
import com.example.demo.handle.command.CommandHandler;
import com.example.demo.service.command.popupbutton.PopupButtonCommandService;
import com.example.demo.utils.ModelMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CreatePopupButtonCommandHandler extends CommandHandler<PopupButtonCommandRequestData, PopupButtonCommandResponseData> {

    private final PopupButtonCommandService popupButtonCommandService;

    @Override
    public PopupButtonCommandResponseData handle(PopupButtonCommandRequestData requestData) {

        PopupButton popupButton = ModelMapper.map(requestData, PopupButton.class);

        popupButtonCommandService.createPopupButton(popupButton);
        return new PopupButtonCommandResponseData(ResponseCode.CREATED, "create popup button successful");
    }
}
