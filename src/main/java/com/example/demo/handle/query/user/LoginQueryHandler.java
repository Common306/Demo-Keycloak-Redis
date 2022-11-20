package com.example.demo.handle.query.user;

import com.example.demo.config.keycloak.KeycloakToken;
import com.example.demo.dto.request.query.user.LoginQueryRequestData;
import com.example.demo.dto.response.query.user.LoginQueryResponseData;
import com.example.demo.handle.query.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class LoginQueryHandler extends QueryHandler<LoginQueryRequestData, LoginQueryResponseData> {

    @Override
    public LoginQueryResponseData handle(LoginQueryRequestData requestData) {
        KeycloakToken keycloakToken = new KeycloakToken();
        Map<String, Object> data = keycloakToken.getDataToken(requestData.getUsername(), requestData.getPassword());
        LoginQueryResponseData loginQueryResponseData = LoginQueryResponseData.builder()
                .accessToken(data.get("access_token").toString())
                .refreshToken(data.get("refresh_token").toString())
                .expiresIn((Long) data.get("expires_in"))
                .refreshExpiresIn((Long) data.get("refresh_expires_in"))
                .tokenType(data.get("token_type").toString())
                .build();
        return loginQueryResponseData;
    }
}
