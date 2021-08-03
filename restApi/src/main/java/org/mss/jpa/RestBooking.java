package org.mss.jpa;

import org.mss.rest.RProp;
import org.osgi.service.cdi.annotations.Service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;


//@Path("booking")
//@Service
//@RProp
//@ApplicationScoped
public class RestBooking {
//    @Inject
    BookingJPAService service;

//    @GET
//    @Path("list")
//    @Produces("application/json")
//    public List<Booking> getList(){
//        return service.list();
//    }
}
