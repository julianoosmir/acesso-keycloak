package tutorial.config.migration;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.keycloak.admin.client.CreatedResponseUtil;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.idm.UserRepresentation;
import tutorial.entity.Person;
import tutorial.exception.keycloak.KeycloakException;
import tutorial.service.RealmResource;

@Slf4j
@ApplicationScoped
@RequiredArgsConstructor
public class CreateKeycloakUserService {

    private final RealmResource realmResource;

    private static String[] splitName(String fullName) {
        String[] parts = fullName.split("\\s+");
        String firstName = parts[0];
        StringBuilder lastName = new StringBuilder();
        if (parts.length > 2) {
            for (int i = 1; i < parts.length; i++) {
                lastName.append(parts[i]).append(" ");
            }
            lastName = new StringBuilder(lastName.toString().trim());
        } else if (parts.length == 2) {
            lastName = new StringBuilder(parts[1]);
        }
        return new String[]{firstName, lastName.toString()};
    }

    public void execute(Person person) throws KeycloakException {
        try {
            UsersResource usersResource = realmResource.users();
            UserRepresentation userRepresentation = createUserRepresentation(person);
            Response response = usersResource.create(userRepresentation);
            String userId = CreatedResponseUtil.getCreatedId(response);
            person.setKeycloakUserId(userId);
        } catch (Exception e) {
            log.error("CreateKeycloakUserService::execute:{}", e.getMessage());
            throw new KeycloakException("");
        }
    }

    private UserRepresentation createUserRepresentation(Person person) {
        UserRepresentation userRepresentation = new UserRepresentation();

        String[] nameParts = splitName(person.getFullName());
        String firstName = "";
        String lastName = "";
        if (nameParts.length >= 2) {
            firstName = nameParts[0];
            lastName = nameParts[1];
        } else if (nameParts.length == 1) {
            firstName = nameParts[0];
        }

        userRepresentation.setFirstName(firstName);
        userRepresentation.setLastName(lastName);
        userRepresentation.setUsername(person.getCpf());
        userRepresentation.setEmail(person.getEmail());
        userRepresentation.setEnabled(Boolean.FALSE);
        return userRepresentation;
    }
}