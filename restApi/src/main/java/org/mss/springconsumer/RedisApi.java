package org.mss.springconsumer;

import org.bitbucket.xadkile.sandwich.redis.connection.provider.RedisConnectorProviderConst;
import org.mss.rest.RProp;
import org.osgi.service.cdi.ServiceScope;
import org.osgi.service.cdi.annotations.*;
import org.osgi.service.component.annotations.Component;
import redis.clients.jedis.Jedis;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/redisApi")
@Dependent
@Service
@ServiceInstance(ServiceScope.PROTOTYPE)
@RProp
@Component
public class RedisApi {

    @Inject
    @Reference(target = RedisConnectorProviderConst.LOCAL_REDIS_OSGI_COMP_PROP)
    Jedis jedis;

    // http://localhost:8181/redisApi/run
    @GET
    @Path("/run")
    @Produces("application/json")
    public String runApi() throws Exception {
        return String.format("{\"x\":%s}", jedis.get("myKey"));
    }
}
