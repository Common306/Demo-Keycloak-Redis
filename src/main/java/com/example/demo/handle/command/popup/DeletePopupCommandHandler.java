package com.example.demo.handle.command.popup;

import com.example.demo.dto.request.command.popup.DeletePopupCommandRequestData;
import com.example.demo.dto.response.ResponseCode;
import com.example.demo.dto.response.command.popup.DeletePopupCommandResponseData;
import com.example.demo.handle.command.CommandHandler;
import com.example.demo.service.command.popup.PopupCommandService;
import com.example.demo.service.query.popup.PopupQueryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DeletePopupCommandHandler extends CommandHandler<DeletePopupCommandRequestData, DeletePopupCommandResponseData> {
    private final PopupCommandService popupCommandService;

    private final PopupQueryService popupQueryService;

    @Override
    public DeletePopupCommandResponseData handle(DeletePopupCommandRequestData requestData) {

        popupQueryService.checkValidWhenDelete(requestData.getIdDelete(), requestData.getLangDelete());

        popupCommandService.deletePopup(requestData.getIdDelete(), requestData.getLangDelete());
        return new DeletePopupCommandResponseData(ResponseCode.OK, "delete popup successful");
    }
}
