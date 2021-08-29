package org.mss.springconsumer;

import org.bitbucket.xadkile.sandwich.redis.connection.provider.RedisConnectorProviderConst;
import org.mss.rest.RProp;
import org.osgi.service.cdi.ServiceScope;
import org.osgi.service.cdi.annotations.*;
import org.osgi.service.component.annotations.Component;
import redis.clients.jedis.Jedis;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

//@Path("/redisApi")
//@Dependent
//@Service
//@ServiceInstance(ServiceScope.PROTOTYPE)
//@RProp
@RProp
@Path("/redisApi")
@Service
@ServiceInstance(ServiceScope.PROTOTYPE)
@SingleComponent
@Named("Champ") //not working
public class RedisApi {

    @Inject
    @Reference(target = RedisConnectorProviderConst.LOCAL_REDIS_OSGI_COMP_PROP)
    Jedis jedis;

    // http://localhost:8181/redisApi/run
    @GET
    @Path("/run")
    @Produces("application/json")
    public String runApi() throws Exception {
        return String.format("{\"x1\":%s}", jedis.get("myKey"));
    }

    // http://localhost:8181/redisApi/run2
    @GET
    @Path("/run2")
    @Produces("application/json")
    public String runApi2() throws Exception {
        return String.format("{\"x2\":%s}", jedis.get("myKey"));
    }
}



