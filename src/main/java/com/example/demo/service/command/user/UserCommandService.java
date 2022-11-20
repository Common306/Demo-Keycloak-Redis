package com.example.demo.service.command.user;

import com.example.demo.dto.request.command.user.RegisterCommandRequestData;

import javax.ws.rs.core.Response;
public interface UserCommandService {
    Response createNewUser(RegisterCommandRequestData userRegister);
}
