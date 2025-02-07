package tutorial.controller;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
import tutorial.dto.UserInputLoginDTO;
import tutorial.service.AuthService;

@ApplicationScoped
@Path("/auth")
@Produces("application/json")
@Consumes("application/json")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService loginService;

    @POST
    @Path("/user/login")
    public Response login(@Valid UserInputLoginDTO userInputLoginDTO) {

        Object token = loginService.loginKeycloak(userInputLoginDTO);

        return Response.status(Response.Status.OK).entity(token).build();
    }
}
