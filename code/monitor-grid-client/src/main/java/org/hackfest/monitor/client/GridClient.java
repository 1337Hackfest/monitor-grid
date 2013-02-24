package org.hackfest.monitor.client;

import com.hazelcast.client.ClientConfig;
import com.hazelcast.core.HazelcastInstance;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import org.hackfest.monitor.domain.GridMap;
import org.hackfest.monitor.domain.Resource;
import org.hackfest.monitor.domain.griddata.UsedPort;


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
        
        
        Map<UUID, UsedPort> mapUsedPorts = client.getMap(GridMap.USED_PORTS.name());
        
        List<Resource> resources = new ArrayList<Resource>();
        
        Resource resource;
        UsedPort usedPort; 
        Set<UUID> keys = mapUsedPorts.keySet();
        System.out.println("Number of grid elements found: " + keys.size());
        for(UUID key : keys){
            usedPort = mapUsedPorts.get(key);
            System.out.println(usedPort);
            
            resource = new Resource();
            resource.setLocalAddress(usedPort.getLocalAddress().getHostAddress());
            resource.setPort(usedPort.getPort());
            
            System.out.println(resource);
           
            resources.add(resource);
        }
        
        return resources;
    }
}