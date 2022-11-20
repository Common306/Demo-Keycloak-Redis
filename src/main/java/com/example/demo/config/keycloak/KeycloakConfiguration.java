package com.example.demo.config.keycloak;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
@NoArgsConstructor
public class KeycloakConfiguration {

    @Value("${keycloak.realm}")
    private String realm;

    @Value("${keycloak.auth-server-url}")
    private String serverUrl;

    @Value("${keycloak.resource}")
    private String clientId;

    private String usernameAdmin = "admin";

    private String passwordAdmin = "123456";
}
