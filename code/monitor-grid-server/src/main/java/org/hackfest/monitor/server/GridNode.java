package org.hackfest.monitor.server;

import com.hazelcast.core.Hazelcast;
import java.util.Map;
import javax.ejb.Stateless;
import org.hackfest.monitor.domain.Resource;

@Stateless
public class GridNode {

    public static void main(String[] args) {
        Map<Long, Resource> mapResources = Hazelcast.getMap("resources");
        System.out.println("Map Size:" + mapResources.size());

        PortScanner scanner = new PortScanner();
        scanner.scan(8079, 9000);

        
    }
}
