package tutorial.config.migration;


import io.quarkus.runtime.Startup;
import jakarta.inject.Singleton;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.keycloak.representations.idm.UserRepresentation;
import tutorial.entity.Person;
import tutorial.repository.PersonRepository;

import java.util.List;

@Singleton
@SuppressWarnings("unused")
@RequiredArgsConstructor
public class MigrationService {

    private final PersonRepository personRepository;

    private final AttachRoleToKeycloakUser attachRoleToKeycloakUser;

    private final CreateKeycloakUserService createKeycloakUserService;

    private final EnableDisableKeycloakUserService enableDisableKeycloakUserService;

    private final AssignPasswordKeycloakUserService assignPasswordKeycloakUserService;

    private final SearchKeycloakUser searchKeycloakUser;

    @ConfigProperty(name = "keycloak.default-user-password")
    String defaultPassword;
    @ConfigProperty(name = "quarkus.flyway.enabled")
    boolean flywayEnabled;

    @Startup
    @Transactional
    void syncUsersKeycloak()
            throws InterruptedException {

        if (flywayEnabled) {
            List<Person> personList = personRepository.findAll().stream().toList();
            createKeycloakUsers(personList);
            Thread.sleep(5000);
            updateKeycloakUsers(personList, defaultPassword);
        }
    }

    private void createKeycloakUsers(List<Person> personList) {
        for (Person person : personList) {
            UserRepresentation userRepresentation = searchKeycloakUser.execute(person.getCpf());
            if (userRepresentation == null) {
                System.out.println(":::Creating person in keycloak:" + person.getFullName());
                this.createKeycloakUserService.execute(person);
            } else {
                person.setKeycloakUserId(userRepresentation.getId());
            }
            this.personRepository.persist(person);
        }
    }

    private void updateKeycloakUsers(List<Person> personList, String defaultPassword) {
        for (Person person : personList) {
            if (!person.getKeycloakSync()) {
                this.assignPasswordKeycloakUserService.execute(person, defaultPassword);
                this.enableDisableKeycloakUserService.execute(person, Boolean.TRUE);
                this.attachRoleToKeycloakUser.execute(person);
                person.setKeycloakSync(Boolean.TRUE);
                this.personRepository.persist(person);
            }
        }
    }
}
