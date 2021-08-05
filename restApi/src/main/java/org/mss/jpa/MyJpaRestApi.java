package org.mss.jpa;

import org.mss.jpa.booking.Booking;
import org.mss.jpa.booking.BookingService;
import org.mss.rest.RProp;
import org.osgi.service.cdi.annotations.Reference;
import org.osgi.service.cdi.annotations.Service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

@Path("ingredient")
@Service
@RProp
@ApplicationScoped
public class MyJpaRestApi {
    //    @Inject
//    IngredientJPAService service;
//    // http://localhost:8181/ingredient/list
//    @GET
//    @Path("list")
//    @Produces("application/json")
//    public List<Ingredient> getList(){
//        return service.list();
//    }
//
    @Inject
    @Reference // to retrieve BookingServie from Osgi service register
    BookingService bookingService;

    @GET
    @Path("list_booking")
    @Produces("application/json")
    public List<Booking> getBooking() {
        return bookingService.list();
    }
}
