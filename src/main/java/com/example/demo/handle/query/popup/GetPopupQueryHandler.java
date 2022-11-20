package com.example.demo.handle.query.popup;

import com.example.demo.dto.request.query.popup.GetPopupQueryRequestData;
import com.example.demo.dto.response.query.popup.GetPopupQueryResponseData;
import com.example.demo.entities.Popup;
import com.example.demo.handle.query.QueryHandler;
import com.example.demo.service.query.popup.PopupQueryService;
import com.example.demo.utils.ModelMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class GetPopupQueryHandler extends QueryHandler<GetPopupQueryRequestData, GetPopupQueryResponseData> {
    private final PopupQueryService popupQueryService;

    @Override
    public GetPopupQueryResponseData handle(GetPopupQueryRequestData requestData) {
        Popup popup = popupQueryService.getExceptionByIdAndLanguage(requestData.getExceptionId(), requestData.getLanguageId());

        GetPopupQueryResponseData responseData = ModelMapper.map(popup, GetPopupQueryResponseData.class);
        return responseData;
    }
}
