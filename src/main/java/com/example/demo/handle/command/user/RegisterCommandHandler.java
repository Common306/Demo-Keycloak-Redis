package com.example.demo.handle.command.user;

import com.example.demo.config.keycloak.KeycloakToken;
import com.example.demo.dto.request.command.user.RegisterCommandRequestData;
import com.example.demo.dto.response.command.user.RegisterCommandResponseData;
import com.example.demo.handle.command.CommandHandler;
import com.example.demo.service.command.user.UserCommandService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.ws.rs.core.Response;
import java.util.Map;

@Component
@AllArgsConstructor
public class RegisterCommandHandler extends CommandHandler<RegisterCommandRequestData, RegisterCommandResponseData> {

    private final UserCommandService userCommandService;
    @Override
    public RegisterCommandResponseData handle(RegisterCommandRequestData requestData) {
        Response response = userCommandService.createNewUser(requestData);

        if(response.getStatus() == 201) {
            KeycloakToken keycloakToken = new KeycloakToken();
            Map<String, Object> data = keycloakToken.getDataToken(requestData.getUsername(), requestData.getPassword());
            RegisterCommandResponseData registerCommandResponseData = RegisterCommandResponseData.builder()
                    .accessToken(data.get("access_token").toString())
                    .refreshToken(data.get("refresh_token").toString())
                    .expiresIn((Long) data.get("expires_in"))
                    .refreshExpiresIn((Long) data.get("refresh_expires_in"))
                    .tokenType(data.get("token_type").toString())
                    .build();
            return registerCommandResponseData;
        }
        return null;
    }
}
