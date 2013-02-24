package org.hackfest.monitor.client.rs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import org.hackfest.monitor.client.GridClient;
import org.hackfest.monitor.domain.Node;
import org.hackfest.monitor.domain.Resource;
import org.hackfest.monitor.domain.griddata.OperatingSystem;
import org.hackfest.monitor.domain.griddata.UsedPort;

@Path("/monitor")
@Stateless 
public class Monitor {
    
    @Inject
    private GridClient gridClient;
    
    @GET
    @Path("/resources")
    @Produces("application/json")
    public List<Resource> getResourceList() {
        
        return getResources();
    }
    
    @GET
    @Path("/nodes")
    @Produces("application/json")
    public List<Node> getNodeList() {
        
        Map<UUID, UsedPort> portMap = gridClient.getUsedPorts();
        if(portMap == null){
            return new ArrayList<Node>();
        }
        Set<UUID> keys = portMap.keySet();
        
        Map<String, Node> nodes = new HashMap<String, Node>();
        
        UsedPort usedPort;
        
        for(UUID key : keys){
            
            usedPort = portMap.get(key);
            Resource resource = new Resource();
            resource.setLocalAddress(usedPort.getLocalAddress().getHostAddress());
            resource.setPort(usedPort.getPort());
            
            Node node = nodes.get(usedPort.getLocalAddress().getHostAddress());
            
            
            
            if(node != null){
                node.getResources().add(resource);
            }else{
                node = new Node();
                node.setLocalAddress(resource.getLocalAddress());
                List<Resource> resourceList = new ArrayList<Resource>();
                resourceList.add(resource);
                node.setResources(resourceList);
                
                OperatingSystem os = getOperatingSystem(getOSInfo(), resource.getLocalAddress());
                
                if(os != null){
                    node.setOperatingSystemArchitecture(os.getArchitecture());
                    node.setOperatingSystemName(os.getName());
                    node.setOperatingSystemVersion(os.getVersion());
                }
                
                nodes.put(node.getLocalAddress(), node);
            }
        }
        
        List<Node> nodeList = new ArrayList<Node>();
        
        Set<String> nodeKeys = nodes.keySet();
        for(String key : nodeKeys){
            nodeList.add(nodes.get(key));
        }
        
        return nodeList;
    }
    
    private List<Resource> getResources(){
                
        Map<UUID, UsedPort> mapUsedPorts = gridClient.getUsedPorts();
        if(mapUsedPorts == null){
            return new ArrayList<Resource>();
        }
        
        List<Resource> resources = new ArrayList<Resource>();
        
        Resource resource;
        UsedPort usedPort; 
        Set<UUID> keys = mapUsedPorts.keySet();
        System.out.println("Number of grid elements found: " + keys.size());
        for(UUID key : keys){
            usedPort = mapUsedPorts.get(key);
            resource = new Resource();
            resource.setLocalAddress(usedPort.getLocalAddress().getHostAddress());
            resource.setPort(usedPort.getPort());
            
            resources.add(resource);
        }
        
        return resources;
    }
    
    private List<OperatingSystem> getOSInfo(){
        
        Map<UUID, OperatingSystem> mapOperatingSystem = gridClient.getOperatingSystems();
        if(mapOperatingSystem == null){
            return new ArrayList<OperatingSystem>();
        }
        
        List<OperatingSystem> operatingSystems = new ArrayList<OperatingSystem>();
        
        OperatingSystem os; 
        Set<UUID> keys = mapOperatingSystem.keySet();
        System.out.println("Number of grid elements found: " + keys.size());
        for(UUID key : keys){
            os = mapOperatingSystem.get(key);
            operatingSystems.add(os);
        }
        
        return operatingSystems;
    }
    
    private OperatingSystem getOperatingSystem(List<OperatingSystem> osList, String localAddress){
        for(OperatingSystem os : osList){
            if(localAddress.equals(os.getLocalAddress())){
                return os;
            }
        }
        return null;
    }
}
