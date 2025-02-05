package tutorial.config.migration;

import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.keycloak.admin.client.resource.UserResource;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.idm.UserRepresentation;
import tutorial.entity.Person;
import tutorial.exception.keycloak.KeycloakException;
import tutorial.service.RealmResource;

@Slf4j
@ApplicationScoped
@RequiredArgsConstructor
public class EnableDisableKeycloakUserService {

    private final RealmResource realmResource;

    public void execute(Person person, Boolean enableDisable) throws KeycloakException {
        try {
            UsersResource usersResource = realmResource.users();
            UserResource userResource = usersResource.get(person.getKeycloakUserId());
            UserRepresentation userRepresentation = userResource.toRepresentation();
            userRepresentation.setEnabled(enableDisable);
            if (person.getEmail() != null) {
                userRepresentation.setEmailVerified(Boolean.TRUE);
            }
            userResource.update(userRepresentation);

        } catch (Exception e) {
            log.error("EnableKeycloakUserService::execute:{}", e.getMessage());
            throw new KeycloakException("");
        }
    }

}