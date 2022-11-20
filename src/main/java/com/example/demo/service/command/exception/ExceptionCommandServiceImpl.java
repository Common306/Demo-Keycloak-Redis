package com.example.demo.service.command.exception;

import com.example.demo.entities.Exception;
import com.example.demo.repository.command.ExceptionCommandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ExceptionCommandServiceImpl implements ExceptionCommandService{

    private final ExceptionCommandRepository exceptionCommandRepository;

    @Override
    public void createException(Exception exception) {

        exceptionCommandRepository.save(exception);
    }

}
