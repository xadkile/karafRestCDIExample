package org.mss.jpa;

import org.mss.rest.RProp;
import org.osgi.service.cdi.annotations.Service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;


@Path("ingredient")
@Service
@RProp
@ApplicationScoped
public class RestIngredient {
    @Inject
    IngredientJPAService service;
    // http://localhost:8181/ingredient/list
    @GET
    @Path("list")
    @Produces("application/json")
    public List<Ingredient> getList(){
        return service.list();
    }
}
