package org.kie.kogito.marco.services;

import java.util.HashMap;

import javax.enterprise.context.ApplicationScoped;

import org.kie.kogito.marco.model.MyData;
import org.kie.kogito.marco.model.RequestData;

@ApplicationScoped
public class MyService {

    private HashMap<String, MyData> map = new HashMap<String, MyData>();
    public MyService() {
        map.put("1", new MyData("One", "This is One"));
        map.put("2", new MyData("Two", "This is Two"));
    }

    public MyData getData(RequestData requestData) {
        MyData myData = map.get(requestData.getKey());
        System.out.println("===> ["+this.getClass().getName()+"] selected data: "+(myData != null? myData.toString():myData));        
        return myData;
    }
    
}
