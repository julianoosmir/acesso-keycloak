package tutorial.service;

import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.resource.RolesResource;
import org.keycloak.admin.client.resource.UsersResource;

@ApplicationScoped
@RequiredArgsConstructor
public class RealmResource {

    private final Keycloak keycloak;

    @ConfigProperty(name = "quarkus.keycloak.admin-client.realm")
    String realm;


    public UsersResource users() {
        return keycloak.realm(realm).users();
    }

    public RolesResource roles() {
        return keycloak.realm(realm).roles();
    }
}
