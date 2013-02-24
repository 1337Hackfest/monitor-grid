package org.hackfest.monitor.domain;

import java.io.Serializable;
import java.net.InetAddress;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Resource implements Serializable{
    
    private String localAddress;
    private int port;

    public String getLocalAddress() {
        return localAddress;
    }

    public void setLocalAddress(String localAddress) {
        this.localAddress = localAddress;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + (this.localAddress != null ? this.localAddress.hashCode() : 0);
        hash = 13 * hash + this.port;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Resource other = (Resource) obj;
        if (this.localAddress != other.localAddress && (this.localAddress == null || !this.localAddress.equals(other.localAddress))) {
            return false;
        }
        if (this.port != other.port) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Resource{" + "localAddress=" + localAddress + ", port=" + port + '}';
    }

    
}
