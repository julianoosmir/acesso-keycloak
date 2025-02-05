package tutorial.config.migration;

import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;
import org.keycloak.admin.client.resource.UserResource;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.idm.RoleRepresentation;
import tutorial.entity.Person;
import tutorial.service.RealmResource;

import java.util.List;

@ApplicationScoped
@RequiredArgsConstructor
public class AttachRoleToKeycloakUser {

    private final RealmResource realmResource;

    public void execute(Person person) {
        UsersResource usersResource = realmResource.users();
        UserResource userResource = usersResource.get(person.getKeycloakUserId());
        List<RoleRepresentation> roles = getRoles(person);
        userResource.roles().realmLevel().add(roles);
    }

    private List<RoleRepresentation> getRoles(Person person) {
        return person.getRoles().stream()
                .map(role -> realmResource.roles().get(role.name()).toRepresentation())
                .toList();
    }
}

