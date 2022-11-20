package com.example.demo.dto.response.command.language;

import com.example.demo.dto.response.ResponseCode;
import com.example.demo.dto.response.command.CommandResponseData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LanguageCommandResponseData extends CommandResponseData {
    private ResponseCode responseCode;

    private String message;
}
