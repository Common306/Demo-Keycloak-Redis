package com.example.demo.service.query.user;

import com.example.demo.config.keycloak.KeycloakConfiguration;
import com.example.demo.config.keycloak.KeycloakProvider;
import com.example.demo.dto.response.ResponseCode;
import com.example.demo.entities.User;
import com.example.demo.exception.CustomizeException;
import lombok.AllArgsConstructor;
import org.keycloak.admin.client.resource.UserResource;
import org.keycloak.admin.client.resource.UsersResource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class UserQueryServiceImpl implements UserQueryService {
    private final KeycloakConfiguration keycloakConfiguration;
    private final KeycloakProvider keycloakProvider;

    @Override
    public User getUserInfo(String id){
        UsersResource usersResource = keycloakProvider.getInstance().realm(keycloakConfiguration.getRealm()).users();
        UserResource userResource = usersResource.get(id);
        try {
            Map<String, List<String>> attributes = userResource.toRepresentation().getAttributes();
            User user = User.builder()
                    .username(userResource.toRepresentation().getUsername())
                    .email(userResource.toRepresentation().getEmail())
                    .firstName(userResource.toRepresentation().getFirstName())
                    .lastName(userResource.toRepresentation().getLastName())
                    .address(attributes.get("Address").get(0))
                    .dob(attributes.get("DOB").get(0))
                    .build();
            return user;
        } catch (Exception e) {
            throw new CustomizeException(ResponseCode.NOT_FOUND_USER.getCode());
        }
    }
}
