package com.example.demo.config.keycloak;

import com.example.demo.dto.response.ResponseCode;
import com.example.demo.exception.CustomizeException;
import lombok.NoArgsConstructor;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.admin.client.token.TokenManager;
import org.keycloak.representations.AccessTokenResponse;
import java.util.HashMap;
import java.util.Map;
@NoArgsConstructor
public class KeycloakToken {
    private String serverUrl = "http://localhost:8080/auth";
    private String realm = "SpringBootKeycloak";
    private String clientId = "login-app";

    public Map<String, Object> getDataToken(String username, String password) {

        Keycloak keycloak = KeycloakBuilder.builder()
                .serverUrl(serverUrl)
                .realm(realm)
                .username(username)
                .password(password)
                .clientId(clientId)
                .build();
        TokenManager tokenManager = keycloak.tokenManager();
        AccessTokenResponse accessToken;
        try {
            accessToken = tokenManager.getAccessToken();
        } catch (Exception e) {
            throw new CustomizeException(ResponseCode.NOT_AUTHORIZED.getCode());
        }
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("access_token", accessToken.getToken());
        data.put("expires_in", accessToken.getExpiresIn());
        data.put("refresh_expires_in", accessToken.getRefreshExpiresIn());
        data.put("refresh_token", accessToken.getRefreshToken());
        data.put("token_type", accessToken.getTokenType());
        data.put("not-before-policy", accessToken.getNotBeforePolicy());
        data.put("session_state", accessToken.getSessionState());
        data.put("scope", accessToken.getScope());

        return data;
    }
}
