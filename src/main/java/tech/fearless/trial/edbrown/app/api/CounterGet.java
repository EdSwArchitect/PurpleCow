package tech.fearless.trial.edbrown.app.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tech.fearless.trial.edbrown.app.model.Counter;

import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Context;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/counter-int")
public class CounterGet {
    private static final Logger LOGGER = LoggerFactory.getLogger(CounterGet.class);
    private Client client = ClientBuilder.newClient();
    private Properties props = new Properties();
    @Context
    private ServletContext context;
    private String counterUrl;
    private ObjectMapper mapper;

    public CounterGet() {
        this.mapper = new ObjectMapper();
    }

    @GET
    public long getIt() {
        if (props.isEmpty()) {

            try {
                props.load(new FileInputStream(new File(context.getRealPath("/WEB-INF/counter.properties"))));
                counterUrl = props.getProperty("counter.url");

                if (counterUrl == null) {
                    LOGGER.error("Error retrieving config value from file");
                    return -1;
                }

            } catch (IOException ioe) {
                LOGGER.error("Error reading config file", ioe);
                return -1;
            }
        }

        String s =
                client.target(counterUrl)
                        .request(APPLICATION_JSON)
                        .accept(APPLICATION_JSON)
                        .get(String.class);

        Counter answer = null;
        try {
            answer = mapper.readValue(s, Counter.class);

            LOGGER.error("The mapper worked. Class object: {}", answer);
        } catch (JsonProcessingException jpe) {
            LOGGER.error("Error unmarshalling the JSON response", jpe);
            return -1;
        }

        return answer.getValue();
    }
}
