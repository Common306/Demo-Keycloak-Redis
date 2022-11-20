package com.example.demo.dto.request.command.language;

import com.example.demo.dto.request.command.CommandRequestData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LanguageCommandRequestData extends CommandRequestData {
    private String languageId;

    private String description;
}
