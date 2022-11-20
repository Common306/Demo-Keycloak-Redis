package com.example.demo.dto.request.command.exception;

import com.example.demo.dto.request.command.CommandRequestData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionCommandRequestData extends CommandRequestData {
    private int exceptionId;

    private String description;
}
