package tech.fearless.trial.edbrown.app.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/counter")
public class GetIt {
    private static final Logger LOGGER = LoggerFactory.getLogger(GetIt.class);
    private Client client = ClientBuilder.newClient();
    private Properties props = new Properties();
    @Context
    private ServletContext context;
    private String counterUrl;

    @GET
    @Produces(APPLICATION_JSON)
    public Response getIt() {
        if (props.isEmpty()) {

            try {
                props.load(new FileInputStream(new File(context.getRealPath("/WEB-INF/counter.properties"))));
                counterUrl = props.getProperty("counter.url");

                if (counterUrl == null) {
                    return Response.status(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(),
                            "Configuration URL not found").build();
                }

                LOGGER.error("Counter URL: '{}'", counterUrl);
            } catch (IOException e) {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), "Unable to access configuration file").build();
            }
        }

        String answer =
                client.target(counterUrl)
                .request(APPLICATION_JSON)
                .get(String.class);

        LOGGER.error("The result is: '{}'", answer);

        Response response = client.target(counterUrl).request(MediaType.TEXT_PLAIN).buildGet().invoke();

        int code = response.getStatusInfo().getStatusCode();

        LOGGER.error("Status is: {}", code);
        LOGGER.error("Media type: {}", response.getMediaType().getType());
        LOGGER.error("Content type: {}", response.getHeaderString("Content-Type"));

        if (code == 200) {

            return Response.ok(answer).build();
        }
        else {
            return Response.fromResponse(response).build();
        }
    }

}
