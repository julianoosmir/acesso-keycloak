package tutorial.exception.keycloak;



import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;
import tutorial.exception.CustomExceptionMapper;
import tutorial.exception.ErrorResponse;

@Provider
@SuppressWarnings("unused")
public class KeycloakExceptionMapper extends CustomExceptionMapper<KeycloakException> {

    @Override
    @Produces(MediaType.APPLICATION_JSON)
    public Response toResponse(KeycloakException e) {
        ErrorResponse errorResponse = this.getErrorResponse(e);
        errorResponse.setTitle("");
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorResponse).build();
    }

}
