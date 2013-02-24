package org.hackfest.monitor.server;

import com.hazelcast.core.Hazelcast;
import java.net.Socket;
import java.util.Map;
import java.util.UUID;
import org.hackfest.monitor.domain.GridMap;
import org.hackfest.monitor.domain.griddata.UsedPort;
import org.joda.time.DateTime;


public class PortScanner {

    public void scan(int startPort, int endPort) {
        
        Map<UUID, UsedPort> mapResources = Hazelcast.getMap(GridMap.USED_PORTS.name());
        System.out.println("Map Size:" + mapResources.size());
        
        int startPortRange = startPort;
        int stopPortRange = endPort;
        UsedPort port;

        for (int i = startPortRange; i <= stopPortRange; i++) {
            try {
                Socket serverSocket = new Socket("127.0.0.1", i);
                port = new UsedPort();
                port.setDiscoveredtime(DateTime.now());
                port.setInetAddress(serverSocket.getInetAddress());
                port.setLocalAddress(serverSocket.getLocalAddress());
                port.setLocalPort(serverSocket.getLocalPort());
                port.setPort(serverSocket.getPort());
                port.setSocketAddress(serverSocket.getRemoteSocketAddress());
                
                serverSocket.close();
                mapResources.put(UUID.randomUUID(), port);
                System.out.println("Added element to grid! Port: " + i);
            } catch (Exception e) {
                System.out.println("Port not used: " + i);
            }
        }
    }
}
