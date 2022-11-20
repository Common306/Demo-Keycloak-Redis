package com.example.demo.handle.query.user;

import com.example.demo.dto.request.query.user.UserQueryRequestData;
import com.example.demo.dto.response.query.user.UserQueryResponseData;
import com.example.demo.entities.User;
import com.example.demo.handle.query.QueryHandler;
import com.example.demo.service.query.user.UserQueryService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserQueryHandler extends QueryHandler<UserQueryRequestData, UserQueryResponseData> {
    private final UserQueryService userQueryService;

    @Override
    public UserQueryResponseData handle(UserQueryRequestData requestData) {
        User user = userQueryService.getUserInfo(requestData.getUserId());
        UserQueryResponseData responseData = UserQueryResponseData.builder()
                .username(user.getUsername())
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .address(user.getAddress())
                .dob(user.getDob())
                .build();
        return responseData;
    }
}
