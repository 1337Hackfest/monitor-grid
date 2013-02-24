package org.hackfest.monitor.server;

import com.hazelcast.core.Hazelcast;
import java.net.Socket;
import java.util.Map;
import java.util.UUID;
import org.hackfest.monitor.domain.GridMap;
import org.hackfest.monitor.domain.griddata.OperatingSystem;
import org.hackfest.monitor.domain.griddata.UsedPort;
import org.joda.time.DateTime;


public class PortScanner {

    public void scan(int startPort, int endPort) {
        
        Map<UUID, UsedPort> mapResources = Hazelcast.getMap(GridMap.USED_PORTS.name());
        System.out.println("Map Size:" + mapResources.size());
        
        int startPortRange = startPort;
        int stopPortRange = endPort;
        UsedPort port;
        
        String localAddress = null; 

        for (int i = startPortRange; i <= stopPortRange; i++) {
            try {
                Socket serverSocket = new Socket("127.0.0.1", i);
                port = new UsedPort();
                port.setDiscoveredtime(DateTime.now());
                port.setInetAddress(serverSocket.getInetAddress());
                port.setLocalAddress(serverSocket.getLocalAddress());
                if(localAddress == null && serverSocket.getLocalAddress() != null){
                    localAddress = serverSocket.getLocalAddress().getHostAddress();
                }
                port.setLocalPort(serverSocket.getLocalPort());
                port.setPort(serverSocket.getPort());
                port.setSocketAddress(serverSocket.getRemoteSocketAddress());
                
                serverSocket.close();
                mapResources.put(UUID.randomUUID(), port);
                System.out.println("Added element to grid! Port: " + i);
                setOsInfo(localAddress);
                System.out.println("OS information added to grid");
            } catch (Exception e) {
                System.out.println("Port not used: " + i);
            }
        }
        
        
    }
    
    public void setOsInfo(String localAddress) {

        try{
        String nameOS = "os.name";
        String versionOS = "os.version";
        String architectureOS = "os.arch";
        
        OperatingSystem os = new OperatingSystem();
        os.setArchitecture(System.getProperty(architectureOS));
        os.setName(System.getProperty(nameOS));
        os.setVersion(System.getProperty(versionOS));
        os.setLocalAddress(localAddress);
        
        Map<UUID, OperatingSystem> mapResources = Hazelcast.getMap(GridMap.OPERATING_SYSTEM.name());
        mapResources.put(UUID.randomUUID(), os); }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
