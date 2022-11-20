package com.example.demo.dto.response.command.popup;

import com.example.demo.dto.response.ResponseCode;
import com.example.demo.dto.response.command.CommandResponseData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdatePopupCommandResponseData extends CommandResponseData {
    private ResponseCode responseCode;

    private String message;
}
