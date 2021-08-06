package org.mss.jpa;

import org.mss.jpa.booking.Booking;
import org.mss.jpa.booking.BookingService;
import org.mss.jpa.ingredient.IngredientJPA_CDIService;
import org.mss.jpa.ingredient.IngredientJPA_DSService;
import org.mss.rest.RProp;
import org.osgi.service.cdi.annotations.Reference;
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

    @Inject
    @Reference // to retrieve BookingServie from Osgi service register
    BookingService bookingService;

    /**
     * http://localhost:8181/ingredient/list_booking
     */
    @GET
    @Path("list_booking")
    @Produces("application/json")
    public List<Booking> getBooking() {
        return bookingService.list();
    }


//
//    @Inject
//    @Reference(target = "(osgi.jndi.service.name=tacoCloudPost)")
//    DataSource dataSource;

//    @Inject
//    @Reference(target = "(osgi.unit.name=booking-hibernate)")
//    private JpaTemplate dataSource;
    /**
     * http://localhost:8181/ingredient/check
     * @return
     */
//    @GET
//    @Path("check")
//    @Produces("application/json")
//    public String check(){
//        if(dataSource!=null){
//            return String.format("{\"z\":\"%s\"}", dataSource.getClass().getName());
//        }else{
//            return "{\"z\":\"null\"}";
//        }
//    }
}
