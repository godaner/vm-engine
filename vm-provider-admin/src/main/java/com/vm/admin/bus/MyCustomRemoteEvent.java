package com.vm.admin.bus;

import org.springframework.cloud.bus.event.RemoteApplicationEvent;
  
public class MyCustomRemoteEvent extends RemoteApplicationEvent {  
    private String message;  
  
  
    //jackson序列化反序列化必须有无参构造函数  
    public MyCustomRemoteEvent() {  
    }  
  
    public MyCustomRemoteEvent(Object source, String originService, String destinationService, String message) {  
        // source is the object that is publishing the event  
        // originService is the unique context ID of the publisher  
  
        super(source, originService, destinationService);  
        this.message = message;  
    }  
  
    public String getMessage() {  
        return message;  
    }  
  
    public void setMessage(String message) {  
        this.message = message;  
    }  
}  