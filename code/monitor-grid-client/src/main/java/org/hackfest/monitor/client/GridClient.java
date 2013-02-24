package org.hackfest.monitor.client;

import com.hazelcast.client.ClientConfig;
import com.hazelcast.core.HazelcastInstance;
import java.util.Map;
import java.util.UUID;
import org.hackfest.monitor.domain.GridMap;
import org.hackfest.monitor.domain.griddata.OperatingSystem;
import org.hackfest.monitor.domain.griddata.UsedPort;

public class GridClient {

    public Map<UUID, UsedPort> getUsedPorts() {

        try {
            ClientConfig clientConfig = new ClientConfig();
            clientConfig.addAddress("127.0.0.1:5701");
            HazelcastInstance client = com.hazelcast.client.HazelcastClient.newHazelcastClient(clientConfig);

            return client.getMap(GridMap.USED_PORTS.name());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Map<UUID, OperatingSystem> getOperatingSystems() {

        try {
            ClientConfig clientConfig = new ClientConfig();
            clientConfig.addAddress("127.0.0.1:5701");
            HazelcastInstance client = com.hazelcast.client.HazelcastClient.newHazelcastClient(clientConfig);

            return client.getMap(GridMap.OPERATING_SYSTEM.name());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}