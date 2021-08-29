package org.mss.jpa;

import org.mss.rest.RProp;
import org.osgi.service.cdi.annotations.Service;
import org.osgi.service.cdi.annotations.SingleComponent;

import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

//@SingleComponent
@Path("msc")
@RProp
@Service
public class MySingleComponent {
    @GET
    public String run(){
        return "run_msc";
    }
}
