package com.example.demo.handle.command.popup;

import com.example.demo.dto.request.command.popup.UpdatePopupCommandRequestData;
import com.example.demo.dto.response.ResponseCode;
import com.example.demo.dto.response.command.popup.UpdatePopupCommandResponseData;
import com.example.demo.entities.Popup;
import com.example.demo.handle.command.CommandHandler;
import com.example.demo.service.command.popup.PopupCommandService;
import com.example.demo.service.query.popup.PopupQueryService;
import com.example.demo.utils.ModelMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UpdatePopupCommandHandler extends CommandHandler<UpdatePopupCommandRequestData, UpdatePopupCommandResponseData> {

    private final PopupCommandService popupCommandService;

    private final PopupQueryService popupQueryService;

    @Override
    public UpdatePopupCommandResponseData handle(UpdatePopupCommandRequestData requestData) {
        int idExceptionUpdate = requestData.getIdExceptionUpdate();
        String idLanguageUpdate = requestData.getIdLanguageUpdate();

        Popup popup = ModelMapper.map(requestData, Popup.class);

        popupQueryService.checkValidWhenUpdate(idExceptionUpdate, idLanguageUpdate, popup);

        popupCommandService.updatePopup(idExceptionUpdate, idLanguageUpdate, popup);
        return new UpdatePopupCommandResponseData(ResponseCode.OK, "update popup successful");
    }
}
