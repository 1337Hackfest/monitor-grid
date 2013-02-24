package org.hackfest.monitor.domain.griddata;

import java.io.Serializable;
import java.net.InetAddress;
import java.net.SocketAddress;
import org.joda.time.DateTime;

public class UsedPort implements Serializable{
    
    private DateTime discoveredtime;
    private int port;
    private InetAddress inetAddress;
    private InetAddress localAddress;
    private int localPort;
    private SocketAddress socketAddress; 

    public DateTime getDiscoveredtime() {
        return discoveredtime;
    }

    public void setDiscoveredtime(DateTime discoveredtime) {
        this.discoveredtime = discoveredtime;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public InetAddress getInetAddress() {
        return inetAddress;
    }

    public void setInetAddress(InetAddress inetAddress) {
        this.inetAddress = inetAddress;
    }

    public InetAddress getLocalAddress() {
        return localAddress;
    }

    public void setLocalAddress(InetAddress localAddress) {
        this.localAddress = localAddress;
    }

    public int getLocalPort() {
        return localPort;
    }

    public void setLocalPort(int localPort) {
        this.localPort = localPort;
    }

    public SocketAddress getSocketAddress() {
        return socketAddress;
    }

    public void setSocketAddress(SocketAddress socketAddress) {
        this.socketAddress = socketAddress;
    }

    @Override
    public String toString() {
        return "UsedPort{" + "discoveredtime=" + discoveredtime + ", port=" + port + ", inetAddress=" + inetAddress + ", localAddress=" + localAddress + ", localPort=" + localPort + ", socketAddress=" + socketAddress + '}';
    }
    
    
}
