package com.example.demo.service.command.user;

import com.example.demo.config.keycloak.KeycloakConfiguration;
import com.example.demo.config.keycloak.KeycloakProvider;
import com.example.demo.dto.request.command.user.RegisterCommandRequestData;
import com.example.demo.dto.response.ResponseCode;
import com.example.demo.exception.CustomizeException;
import lombok.AllArgsConstructor;
import org.keycloak.admin.client.CreatedResponseUtil;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.admin.client.resource.UserResource;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.RoleRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.stereotype.Service;

import javax.ws.rs.core.Response;
import java.util.*;

@Service
@AllArgsConstructor
public class UserCommandServiceImpl implements UserCommandService{

    private final KeycloakConfiguration keycloakConfiguration;

    private final KeycloakProvider keycloakProvider;

    @Override
    public Response createNewUser(RegisterCommandRequestData userRegister) {
        UsersResource usersResource = keycloakProvider.getInstance().realm(keycloakConfiguration.getRealm()).users();
        CredentialRepresentation credentialRepresentation = createPasswordCredentials(userRegister.getPassword());

        UserRepresentation userRepresentation = new UserRepresentation();
        userRepresentation.setUsername(userRegister.getUsername());
        userRepresentation.setCredentials(Collections.singletonList(credentialRepresentation));
        userRepresentation.setFirstName(userRegister.getFirstName());
        userRepresentation.setLastName(userRegister.getLastName());
        userRepresentation.setEmail(userRegister.getEmail());
        userRepresentation.setEnabled(true);
        userRepresentation.setEmailVerified(false);

        Map<String, List<String>> attributes = new HashMap<>();
        attributes.put("Address", Arrays.asList(userRegister.getAddress()));
        attributes.put("DOB", Arrays.asList(userRegister.getDob().toString()));
        userRepresentation.setAttributes(attributes);

        Response response = usersResource.create(userRepresentation);
        if(response.getStatus() == 409) {
            throw new CustomizeException(ResponseCode.NOT_IMPLEMENT.getCode());
        } else {
            RealmResource realmResource = keycloakProvider.getInstance().realm(keycloakConfiguration.getRealm());
            RoleRepresentation roleUser = realmResource.roles().get("USER").toRepresentation();
            String userId = CreatedResponseUtil.getCreatedId(response);

            UserResource userResource = usersResource.get(userId);
            userResource.roles().realmLevel().add(Arrays.asList(roleUser));
        }

        return response;
    }

    private CredentialRepresentation createPasswordCredentials(String password) {
        CredentialRepresentation passwordCredentials = new CredentialRepresentation();
        passwordCredentials.setTemporary(false);
        passwordCredentials.setType(CredentialRepresentation.PASSWORD);
        passwordCredentials.setValue(password);
        return passwordCredentials;
    }
}
