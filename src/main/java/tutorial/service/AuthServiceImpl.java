package tutorial.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.resteasy.reactive.ClientWebApplicationException;
import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.representations.AccessTokenResponse;
import tutorial.dto.UserInputLoginDTO;
import tutorial.dto.UserOutputValidLoginDTO;
import tutorial.entity.Person;
import tutorial.repository.PersonRepository;

@RequiredArgsConstructor
@ApplicationScoped
@Slf4j
public class AuthServiceImpl {

    private final PersonRepository personRepository;

    @ConfigProperty(name = "quarkus.keycloak.admin-client.realm")
    String realm;
    @ConfigProperty(name = "quarkus.keycloak.admin-client.client-id")
    String clientId;
    @ConfigProperty(name = "quarkus.keycloak.admin-client.client-secret")
    String clientSecret;
    @ConfigProperty(name = "quarkus.keycloak.admin-client.server-url")
    String serverUrl;
    @ConfigProperty(name = "keycloak.temporary-lock-time")
    Long keycloakTemporaryLockTime;
    @ConfigProperty(name = "keycloak.max-login-failure")
    Long maxLoginFailure;
    @ConfigProperty(name = "keycloak.default-user-password")
    String defaultUserPassword;

    @Transactional
    public Object loginKeycloak(UserInputLoginDTO userInputLoginDTO) {

        UserOutputValidLoginDTO userOutputValidLoginDTO = new UserOutputValidLoginDTO();

        Person person = this.personRepository.findByCPF(userInputLoginDTO.getCpf()).orElseThrow(
                () -> new EntityNotFoundException("erro ao encontrar o CPF " + userInputLoginDTO.getCpf()));

        try {
            Keycloak keycloak = KeycloakBuilder.builder()
                    .serverUrl(serverUrl)
                    .realm(realm)
                    .grantType(OAuth2Constants.PASSWORD)
                    .clientId(clientId)
                    .clientSecret(clientSecret)
                    .username(userInputLoginDTO.getCpf())
                    .password(userInputLoginDTO.getPassword())
                    .build();

            AccessTokenResponse response = keycloak.tokenManager().getAccessToken();

            userOutputValidLoginDTO.setAccessToken(response.getToken());
            userOutputValidLoginDTO.setRefreshToken(response.getRefreshToken());
            userOutputValidLoginDTO.setExpiresIn(response.getExpiresIn());
            userOutputValidLoginDTO.setRefreshExpiresIn(response.getRefreshExpiresIn());

        } catch (ClientWebApplicationException e) {
            Response errorResponse = e.getResponse();

        } catch (Exception e) {
            log.error("KeycloakLoginService::execute:{}", e.getMessage());
        }
        return userOutputValidLoginDTO;
    }
}
