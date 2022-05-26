package tech.fearless.trial.edbrown.app.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/counter")
public class GetIt {
    private static final Logger LOGGER = LoggerFactory.getLogger(GetIt.class);
    private Client client = ClientBuilder.newClient();

    @GET
    @Produces(APPLICATION_JSON)
    public Response getIt() {
        String answer =
        client.target("https://api.countapi.xyz/hit/edbrown-submission/1ccb732e-b55a-4404-ad3f-0f99c02fe44e")
                .request(MediaType.TEXT_PLAIN)
                .get(String.class);

        LOGGER.error("The result is: '{}'", answer);

        return Response.ok(answer).build();
    }

    @POST
    @Produces(APPLICATION_JSON)
    @Consumes(APPLICATION_JSON)
    public Response doIt(String json) {
        LOGGER.error("JSON coming in is: '{}'", json);


        return Response.ok().build();
    }
}
