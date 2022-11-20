package com.example.demo.controller;

import com.example.demo.dto.request.command.user.RegisterCommandRequestData;
import com.example.demo.dto.request.query.user.LoginQueryRequestData;
import com.example.demo.dto.request.query.user.UserQueryRequestData;
import com.example.demo.dto.response.BaseResponse;
import com.example.demo.dto.response.command.user.RegisterCommandResponseData;
import com.example.demo.dto.response.query.user.LoginQueryResponseData;
import com.example.demo.dto.response.query.user.UserQueryResponseData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@Slf4j
public class UserController extends BaseController{

    @PostMapping(value = "v1/login")
    public ResponseEntity<BaseResponse<LoginQueryResponseData>> loginAccount(@RequestBody LoginQueryRequestData loginQueryRequestData) {
        return execute(loginQueryRequestData);
    }

    @PostMapping(value = "v1/register")
    public ResponseEntity<BaseResponse<RegisterCommandResponseData>> registerUser(@RequestBody RegisterCommandRequestData registerCommandRequestData) {
        return execute(registerCommandRequestData);
    }

    @GetMapping("v1/user/{id}")
//    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ResponseEntity<BaseResponse<UserQueryResponseData>> getUserInfo(@PathVariable("id") String id) {
        log.info("call user controller");
        UserQueryRequestData userQueryRequestData = new UserQueryRequestData(id);
        return execute(userQueryRequestData);
    }
}
