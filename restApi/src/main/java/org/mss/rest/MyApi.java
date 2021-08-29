package org.mss.rest;

import org.mss.cdi.MyService;
import org.osgi.service.cdi.ServiceScope;
import org.osgi.service.cdi.annotations.Reference;
import org.osgi.service.cdi.annotations.Service;
import org.osgi.service.cdi.annotations.ServiceInstance;
import org.osgi.service.jaxrs.whiteboard.propertytypes.JaxrsResource;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
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
@Path("/myApi") //whiteboard
//@ApplicationScoped //CDI this is needed
//@RequestScoped
@Dependent //should set it to dependent, so that its scope == service scope
@Service // osgi CDI
@ServiceInstance(ServiceScope.PROTOTYPE) // this is service scope
@RProp // CDI
public class MyApi {

    @Inject
    ExampleServiceInterface service;

    @Inject
    MyService ms;

    @GET // whiteboard
    @Path("/run_api") //whiteboard
    @Produces("application/json")
    public String runApi(){
        return String.format("{\"run\": %s-%s-%s-%s %s, \"thisHasCode\":%s}",
            ms.getClass1().hashCode(),
            ms.getHolder().getClass1().hashCode(),
            ms.hashCode(),
            service.hashCode(),
//            "xxx",
            ms.checkSame(),
            this.hashCode()
            );
    }
}
