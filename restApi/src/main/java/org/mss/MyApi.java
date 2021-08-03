package org.mss;

import org.osgi.service.cdi.annotations.Service;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * the api is at http://localhost:8181/myApi/run_api
 * Three things need to be done:
 *  - correct maven dependencies
 *  - correct feature.xml : to install required feature to karaf
 *  - annotated the classes correctly
 */
@Path("myApi") //whiteboard part
@ApplicationScoped //CDI this is needed
@Service // CDI
@RProp // CDI
public class MyApi {
    @GET // whiteboard
    @Path("run_api") //whiteboard
    @Produces("application/json")
    public String runApi(){
        return "{\"run\": api}";
    }
}
