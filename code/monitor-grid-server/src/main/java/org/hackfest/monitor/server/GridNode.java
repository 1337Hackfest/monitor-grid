package org.hackfest.monitor.server;

import javax.ejb.Stateless;

@Stateless
public class GridNode {

    public static void main(String[] args) {
        
        PortScanner scanner = new PortScanner();
        scanner.scan(8079, 9000);       
    }
}
