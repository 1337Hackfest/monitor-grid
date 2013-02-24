package org.hackfest.monitor.domain.griddata;

import java.io.Serializable;

public class OperatingSystem implements Serializable{
    
    private String name;
    private String version;
    private String architecture;
    private String localAddress;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getArchitecture() {
        return architecture;
    }

    public void setArchitecture(String architecture) {
        this.architecture = architecture;
    }

    public String getLocalAddress() {
        return localAddress;
    }

    public void setLocalAddress(String localAddress) {
        this.localAddress = localAddress;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + (this.name != null ? this.name.hashCode() : 0);
        hash = 97 * hash + (this.version != null ? this.version.hashCode() : 0);
        hash = 97 * hash + (this.architecture != null ? this.architecture.hashCode() : 0);
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
        final OperatingSystem other = (OperatingSystem) obj;
        if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name)) {
            return false;
        }
        if ((this.version == null) ? (other.version != null) : !this.version.equals(other.version)) {
            return false;
        }
        if ((this.architecture == null) ? (other.architecture != null) : !this.architecture.equals(other.architecture)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "OperatingSystem{" + "name=" + name + ", version=" + version + ", architecture=" + architecture + ", localAddress=" + localAddress + '}';
    }
    
    
}
