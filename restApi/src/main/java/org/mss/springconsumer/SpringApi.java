package org.mss.springconsumer;

import org.bitbucket.xadkile.sandwich.ggcloud.provider.api.GGCloudServiceProvider;
import org.mss.rest.RProp;
import org.osgi.service.cdi.ServiceScope;
import org.osgi.service.cdi.annotations.Reference;
import org.osgi.service.cdi.annotations.Service;
import org.osgi.service.cdi.annotations.ServiceInstance;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/springApi")
@Dependent
@Service
@ServiceInstance(ServiceScope.PROTOTYPE)
@RProp
public class SpringApi {

    @Inject
    @Reference
    GGCloudServiceProvider provider;

    @Inject
    XC xc;

    @Inject
    @SingletonBank
    Bank bank;

    @Inject
    @InstanceBank
    Bank bank2;

    // http://localhost:8181/springApi/verify
    @GET
    @Path("/verify")
    @Produces("application/json")
    public String runApi() throws Exception{
        String status = "";
        try{
            this.provider.getFirebaseAuth().verifyIdToken("eyJhbGciOiJSUzI1NiIsImtpZCI6IjM2NGU4NTQ1NzI5OWQ5NzIxYjczNDQyZGNiNTQ3Y2U2ZDk4NGRmNTkiLCJ0eXAiOiJKV1QifQ.eyJuYW1lIjoiWGFkIEtpbGUiLCJwaWN0dXJlIjoiaHR0cHM6Ly93d3cuZ29vZ2xlLmNvbS9sb2dvcy9kb29kbGVzLzIwMTgvZWRpdGgtY2F2ZWxscy0xNTNyZC1iaXJ0aGRheS01OTY5NzIyMjUxMTQ5MzEyLTJ4LnBuZyIsImlzcyI6Imh0dHBzOi8vc2VjdXJldG9rZW4uZ29vZ2xlLmNvbS9tc3Nwcm9qZWN0LTMyMjMwNiIsImF1ZCI6Im1zc3Byb2plY3QtMzIyMzA2IiwiYXV0aF90aW1lIjoxNjI5MDkwNzYyLCJ1c2VyX2lkIjoiMSIsInN1YiI6IjEiLCJpYXQiOjE2MjkwOTA3NjIsImV4cCI6MTYyOTA5NDM2MiwiZW1haWwiOiJ4YWRraWxlQGdtYWlsLmNvbSIsImVtYWlsX3ZlcmlmaWVkIjpmYWxzZSwiZmlyZWJhc2UiOnsiaWRlbnRpdGllcyI6eyJlbWFpbCI6WyJ4YWRraWxlQGdtYWlsLmNvbSJdfSwic2lnbl9pbl9wcm92aWRlciI6InBhc3N3b3JkIn19.Io3SAQdsSI1F-Uq6koLvuiBHjS8Od7ZrcRgSZFbXm9VajDWkQDSuLHmgaTuN3DJZEwS4nbgQ8yJmWhf75kBH-7tNG1yOxLdbkXyMmugk4SwBserB5Ogf0rEqFAtNlX1wWGE-N7c7d52uktBoJhA_bLejg2Rm8Nh8bS0moNAelqHolFHwDFaBHPgU0X7aG7SKb2zPd1t0RMQAE91_HSD98dYT8UCznNqfy3mR9ZyXcx8kCJSycgGCPV-7ZHzXIR0jZzza_9EKMgHA2X6bsecMYYHLDEf4Qc0Lc5j-c2JyKrADUvRQJap-z0UPB_XZZXH2PFxt_rOcvMZjjSpJlbVd6w",true);
            status ="ok";
        }catch(Exception e){
            status =e.getMessage();
        }

        return String.format("%s\n %s\n %s",
            xc.v,
            bank.deposit(),
            status);
    }
}
