package org.mss.springconsumer;

import com.example.GGAuthenInterface;
import org.mss.rest.RProp;
import org.osgi.service.cdi.ServiceScope;
import org.osgi.service.cdi.annotations.Reference;
import org.osgi.service.cdi.annotations.Service;
import org.osgi.service.cdi.annotations.ServiceInstance;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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
    GGAuthenInterface gg;
    // http://localhost:8181/springApi/verify
    @GET
    @Path("/verify")
    @Produces("application/json")
    public String runApi(){
        return String.format("{\"gg\": %s, \"tokenResult\":%s}", this.gg.hashCode(),gg.verifyToken("eyJhbGciOiJSUzI1NiIsImtpZCI6ImFlMDVlZmMyNTM2YjJjZTdjNTExZjRiMTcyN2I4NTkyYTc5ZWJiN2UiLCJ0eXAiOiJKV1QifQ.eyJuYW1lIjoiWGFkIEtpbGUiLCJwaWN0dXJlIjoiaHR0cHM6Ly93d3cuZ29vZ2xlLmNvbS9sb2dvcy9kb29kbGVzLzIwMTgvZWRpdGgtY2F2ZWxscy0xNTNyZC1iaXJ0aGRheS01OTY5NzIyMjUxMTQ5MzEyLTJ4LnBuZyIsImlzcyI6Imh0dHBzOi8vc2VjdXJldG9rZW4uZ29vZ2xlLmNvbS9tc3Nwcm9qZWN0LTMyMjMwNiIsImF1ZCI6Im1zc3Byb2plY3QtMzIyMzA2IiwiYXV0aF90aW1lIjoxNjI4OTk2MTkyLCJ1c2VyX2lkIjoiMSIsInN1YiI6IjEiLCJpYXQiOjE2Mjg5OTYxOTIsImV4cCI6MTYyODk5OTc5MiwiZW1haWwiOiJ4YWRraWxlQGdtYWlsLmNvbSIsImVtYWlsX3ZlcmlmaWVkIjpmYWxzZSwiZmlyZWJhc2UiOnsiaWRlbnRpdGllcyI6eyJlbWFpbCI6WyJ4YWRraWxlQGdtYWlsLmNvbSJdfSwic2lnbl9pbl9wcm92aWRlciI6InBhc3N3b3JkIn19.EEhxmYbfWjD3pF9bjuc2uQJdI-zKLryc_p81S5JtHy0sQ6Ic9EDxARLOkK2ZVd5qad6qmft8y_U_rG7rKXkysEmtyPeTHadXov2UBl9Y3m1bkxy4nYob9unJ32Qh0EQ6TkYFressQJG66dy9V_DyZjHLOkEK8377zf_MTvjm0FD8PURaMGOZ9cTmP171iiBJ_RKp_sOkvDyfbNvD4I4K2-41OZhN0oe-FJzfVp06GVPuyCEiTO7Q0plLQ7vhfdKiQdmm34aZHbA46rLSYtBB6zFwH6WenCCb9HexeyIgefUi7hKL9riDYGMnbOLh0qzrSMszy9rWnKfoWJvZAsMtkg"));
    }
}
