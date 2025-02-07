package tutorial.controller;

import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
import org.eclipse.microprofile.jwt.JsonWebToken;
import tutorial.service.PersonService;

@ApplicationScoped
@Path("/users")
@Produces("application/json")
@Consumes("application/json")
@RequiredArgsConstructor
public class PersonControllers {

    private final PersonService personService;
    private final JsonWebToken jsonWebToken;

    @GET
    @RolesAllowed({"ADMIN"})
    public Response getAllUsers() {
      return Response.ok(personService.findAll()).build();
    }

    @GET
    @Path("/my-user")
    @RolesAllowed({"USER"})
    public Response getUser() {
        String token = jsonWebToken.getName();
        return Response.ok(personService.findByCpf(token)).build();
    }

}
