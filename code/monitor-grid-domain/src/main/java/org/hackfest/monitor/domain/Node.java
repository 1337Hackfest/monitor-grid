package org.hackfest.monitor.domain;

import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Node implements Serializable{
    
    private String localAddress;
    private List<Resource> resources;
    private String operatingSystemName;
    private String operatingSystemArchitecture;
    private String operatingSystemVersion;

    public String getLocalAddress() {
        return localAddress;
    }

    public void setLocalAddress(String localAddress) {
        this.localAddress = localAddress;
    }

    public List<Resource> getResources() {
        return resources;
    }

    public void setResources(List<Resource> resources) {
        this.resources = resources;
    }

    public String getOperatingSystemName() {
        return operatingSystemName;
    }

    public void setOperatingSystemName(String operatingSystemName) {
        this.operatingSystemName = operatingSystemName;
    }

    public String getOperatingSystemArchitecture() {
        return operatingSystemArchitecture;
    }

    public void setOperatingSystemArchitecture(String operatingSystemArchitecture) {
        this.operatingSystemArchitecture = operatingSystemArchitecture;
    }

    public String getOperatingSystemVersion() {
        return operatingSystemVersion;
    }

    public void setOperatingSystemVersion(String operatingSystemVersion) {
        this.operatingSystemVersion = operatingSystemVersion;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + (this.localAddress != null ? this.localAddress.hashCode() : 0);
        hash = 13 * hash + (this.resources != null ? this.resources.hashCode() : 0);
        hash = 13 * hash + (this.operatingSystemName != null ? this.operatingSystemName.hashCode() : 0);
        hash = 13 * hash + (this.operatingSystemArchitecture != null ? this.operatingSystemArchitecture.hashCode() : 0);
        hash = 13 * hash + (this.operatingSystemVersion != null ? this.operatingSystemVersion.hashCode() : 0);
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
        final Node other = (Node) obj;
        if ((this.localAddress == null) ? (other.localAddress != null) : !this.localAddress.equals(other.localAddress)) {
            return false;
        }
        if (this.resources != other.resources && (this.resources == null || !this.resources.equals(other.resources))) {
            return false;
        }
        if ((this.operatingSystemName == null) ? (other.operatingSystemName != null) : !this.operatingSystemName.equals(other.operatingSystemName)) {
            return false;
        }
        if ((this.operatingSystemArchitecture == null) ? (other.operatingSystemArchitecture != null) : !this.operatingSystemArchitecture.equals(other.operatingSystemArchitecture)) {
            return false;
        }
        if ((this.operatingSystemVersion == null) ? (other.operatingSystemVersion != null) : !this.operatingSystemVersion.equals(other.operatingSystemVersion)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Node{" + "localAddress=" + localAddress + ", resources=" + resources + ", operatingSystemName=" + operatingSystemName + ", operatingSystemArchitecture=" + operatingSystemArchitecture + ", operatingSystemVersion=" + operatingSystemVersion + '}';
    }

    
}
