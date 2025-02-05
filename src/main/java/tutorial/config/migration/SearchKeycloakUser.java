package tutorial.config.migration;

import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.idm.UserRepresentation;
import tutorial.service.RealmResource;

import java.util.List;

@ApplicationScoped
@RequiredArgsConstructor
public class SearchKeycloakUser {

    private final RealmResource realmResource;

    public UserRepresentation execute(String username) {
        UsersResource usersResource = realmResource.users();
        List<UserRepresentation> users = usersResource.searchByUsername(username, true);
        if (!users.isEmpty()) {
            return users.get(0);
        } else {
            return null;
        }
    }

}