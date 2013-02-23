package org.hackfest.monitor.server;

import com.hazelcast.core.Hazelcast;
import java.net.Socket;
import java.util.Map;
import org.hackfest.monitor.domain.Resource;


public class PortScanner {

    public void scan(int startPort, int endPort) {
        
        Map<Long, Resource> mapResources = Hazelcast.getMap("resources");
        System.out.println("Map Size:" + mapResources.size());
        
        int startPortRange = startPort;
        int stopPortRange = endPort;

        for (int i = startPortRange; i <= stopPortRange; i++) {
            try {
                Socket serverSocket = new Socket("127.0.0.1", i);
                System.out.println("Port in use: " + i);
                serverSocket.close();
                Resource res = new Resource();
                res.setName("port");
                res.setValue(i);

                mapResources.put(System.currentTimeMillis(), res);
                System.out.println("Map Size:" + mapResources.size());
            } catch (Exception e) {
                // Could not open connection. Port not in use
            }
        }
    }
}
