package org.hackfest.monitor;

import junit.framework.Assert;
import org.hackfest.monitor.domain.Resource;

public class ResourceTest {
    
    public void testGetSet(){
        
        Resource resource = new Resource();
        
        Assert.assertNull(resource.getName());
        Assert.assertNull(resource.getValue());
        
        resource.setName("testName");
        resource.setValue("testValue");
        
        Assert.assertEquals("testName", resource.getName());
        Assert.assertEquals("testValue", resource.getValue());
    }
    
}
