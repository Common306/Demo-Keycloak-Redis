package com.example.demo.dto.request.query.popup;

import com.example.demo.dto.request.query.QueryRequestData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetPopupQueryRequestData extends QueryRequestData {
    private int exceptionId;
    private String languageId;
}
