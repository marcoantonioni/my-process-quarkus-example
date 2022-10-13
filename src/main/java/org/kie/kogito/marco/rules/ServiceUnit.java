package org.kie.kogito.marco.rules;

import org.kie.kogito.marco.model.RequestData;
import org.kie.kogito.rules.DataSource;
import org.kie.kogito.rules.RuleUnitData;
import org.kie.kogito.rules.SingletonStore;

public class ServiceUnit implements RuleUnitData {
    private SingletonStore<RequestData> requestData;

    public SingletonStore<RequestData> getRequestData() {
        System.out.println("===> ServiceUnit.getRequestData ");
        return requestData;
    }

    public void setRequestData(SingletonStore<RequestData> requestData) {
        System.out.println("===> ServiceUnit.setRequestData ");
        this.requestData = requestData;
    }

    public ServiceUnit() {
        this(DataSource.createSingleton());
        System.out.println("===> CTOR ServiceUnit()");
    }

    public ServiceUnit(SingletonStore<RequestData> requestData) {
        this.requestData = requestData;
        System.out.println("===> CTOR ServiceUnit(SingletonStore<RequestData>)");
    }

    //-----------------------
    public SingletonStore<RequestData> getInputData() {
        System.out.println("===> someone called me, I'm "+this.getClass().getName());
        return requestData;
    }
}
