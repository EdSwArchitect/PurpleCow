package tech.fearless.trial.edbrown.app.api;

import com.fasterxml.jackson.databind.ObjectMapper;

//import javax.ws.rs.ext.ContextResolver;

public class MapperProvider /*implements ContextResolver<ObjectMapper>*/ {
    private ObjectMapper mapper;

    public MapperProvider() {
        this.mapper = new ObjectMapper();
    }

//    @Override
//    public ObjectMapper getContext(Class<?> aClass) {
//        return mapper;
//    }
}
