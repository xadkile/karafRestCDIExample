package org.mss.jpa;

import org.mss.cdi.MyService;
import org.mss.jpa.booking.Booking;
import org.mss.jpa.booking.BookingService;
import org.mss.jpa.ingredient.IngredientJPA_CDIService;
import org.mss.jpa.ingredient.IngredientJPA_DSService;
import org.mss.rest.RProp;
import org.osgi.service.cdi.annotations.Reference;
import org.osgi.service.cdi.annotations.Service;
import org.osgi.service.jaxrs.whiteboard.propertytypes.JaxrsResource;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

@Path("ingredient")
@Service
@RProp
// TODO check if @JaxrsResource can replace @RProp
//@JaxrsResource
@ApplicationScoped
public class MyJpaRestApi {

    @Inject
    IngredientJPA_CDIService cdiService;

    @GET
    @Path("list_cdi")
    @Produces("application/json")
    public String getListCDI() {
        return String.format("{\"v\":%s}", service.list().size());
    }


    @Inject
    @Reference
    IngredientJPA_DSService service;


    /**
     * http://localhost:8181/ingredient/list
     */
    @GET
    @Path("list")
    @Produces("application/json")
    public String getList() {
        return String.format("{\"v\":%s}", service.list().size());
    }

//    @Inject
//    @Reference // to retrieve BookingServie from Osgi service register
//    BookingService bookingService;
//
//    /**
//     * http://localhost:8181/ingredient/list_booking
//     */
//    @GET
//    @Path("list_booking")
//    @Produces("application/json")
//    public List<Booking> getBooking() {
//        return bookingService.list();
//    }
}
