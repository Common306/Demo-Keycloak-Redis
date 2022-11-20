package com.example.demo.handle.command.exception;

import com.example.demo.dto.request.command.exception.ExceptionCommandRequestData;
import com.example.demo.dto.response.ResponseCode;
import com.example.demo.dto.response.command.exception.ExceptionCommandResponseData;
import com.example.demo.entities.Exception;
import com.example.demo.handle.command.CommandHandler;
import com.example.demo.service.command.exception.ExceptionCommandService;
import com.example.demo.utils.ModelMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CreateExceptionCommandHandler extends CommandHandler<ExceptionCommandRequestData, ExceptionCommandResponseData> {

    private final ExceptionCommandService exceptionCommandService;

    @Override
    public ExceptionCommandResponseData handle(ExceptionCommandRequestData requestData) {

        Exception exception = ModelMapper.map(requestData, Exception.class);

        exceptionCommandService.createException(exception);
        return new ExceptionCommandResponseData(ResponseCode.CREATED, "Create successful");
    }
}
