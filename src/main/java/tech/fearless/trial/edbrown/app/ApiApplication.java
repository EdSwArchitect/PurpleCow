package tech.fearless.trial.edbrown.app;

import tech.fearless.trial.edbrown.app.api.GetIt;
import org.glassfish.jersey.server.ResourceConfig;
import tech.fearless.trial.edbrown.app.api.MapperProvider;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("/api")
public class ApiApplication extends ResourceConfig  {
    public ApiApplication() {
        packages(ApiApplication.class.getPackage().getName(),
                GetIt.class.getPackage().getName());
//        register(MapperProvider.class);
    }
}
