package org.hackfest.monitor.client;

import com.hazelcast.client.ClientConfig;
import com.hazelcast.core.HazelcastInstance;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import org.hackfest.monitor.domain.Resource;


@Path("/monitor")
@Stateless 
public class GridClient {

    @GET
    @Path("/resources")
    @Produces("application/json")
    public List<Resource> getResources() {

        ClientConfig clientConfig = new ClientConfig(); 
        clientConfig.addAddress("127.0.0.1:5701");
        HazelcastInstance client = com.hazelcast.client.HazelcastClient.newHazelcastClient(clientConfig);
        
        
        Map<Long, Resource> mapResources = client.getMap("resources");
        
        List<Resource> resources = new ArrayList<Resource>();
        
        
        Set<Long> keys = mapResources.keySet();
        for(Long key : keys){
            resources.add(mapResources.get(key));
        }
        
        
        return resources;
    }
}