package tutorial.config.migration;



import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jboss.resteasy.reactive.ClientWebApplicationException;
import org.keycloak.admin.client.resource.UserResource;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.idm.CredentialRepresentation;
import tutorial.entity.Person;
import tutorial.exception.keycloak.KeycloakException;
import tutorial.service.RealmResource;

@Slf4j
@ApplicationScoped
@RequiredArgsConstructor
public class AssignPasswordKeycloakUserService {

    private final RealmResource realmResource;

    public void execute(Person person, String password) throws KeycloakException {
        try {
            UsersResource usersResource = realmResource.users();
            UserResource userResource = usersResource.get(person.getKeycloakUserId());
            userResource.resetPassword(getCredentials(password));
        } catch (ClientWebApplicationException e) {
            Response errorResponse = e.getResponse();
            if (errorResponse.getStatus() == 400) {
                throw new KeycloakException("");
            }
        } catch (Exception e) {
            log.error("AssignPasswordKeycloakUserService::execute:{}", e.getMessage());
            throw new KeycloakException("");
        }
    }

    private CredentialRepresentation getCredentials(String password) {
        CredentialRepresentation credentialRepresentation = new CredentialRepresentation();
        credentialRepresentation.setTemporary(false);
        credentialRepresentation.setType(CredentialRepresentation.PASSWORD);
        credentialRepresentation.setValue(password);
        return credentialRepresentation;
    }
}
