package com.example.demo.config.keycloak;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
@NoArgsConstructor
public class KeycloakProvider {
    @Autowired
    private KeycloakConfiguration keycloakConfiguration;

    private Keycloak keycloak = null;

    public Keycloak getInstance() {
        if(keycloak == null) {

            return KeycloakBuilder.builder()
                    .serverUrl(keycloakConfiguration.getServerUrl())
                    .realm(keycloakConfiguration.getRealm())
                    .username(keycloakConfiguration.getUsernameAdmin())
                    .password(keycloakConfiguration.getPasswordAdmin())
                    .clientId(keycloakConfiguration.getClientId())
                    .resteasyClient(new ResteasyClientBuilder().connectionPoolSize(10).build())
                    .build();
        }

        return keycloak;
    }
}
