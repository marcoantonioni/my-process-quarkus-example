package org.kie.kogito.marco.model;

import java.io.Serializable;

public class RequestData implements Serializable {
    private String key = "";
    private boolean useRules = false;
    private boolean ruleResult = false;
    private boolean showResult = false;
    private String message;

    public boolean isShowResult() {
        return showResult;
    }
    public void setShowResult(boolean showResult) {
        this.showResult = showResult;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public boolean isRuleResult() {
        return ruleResult;
    }
    public void setRuleResult(boolean ruleResult) {
        this.ruleResult = ruleResult;
    }
    public RequestData() {
    }
    public RequestData(String key, boolean useRules) {
        this.key = key;
        this.useRules = useRules;
    }
    public String getKey() {
        return key;
    }
    public void setKey(String key) {
        this.key = key;
    }
    public boolean isUseRules() {
        return useRules;
    }
    public void setUseRules(boolean useRules) {
        this.useRules = useRules;
    }
    
    @Override
    public String toString() {
        return "RequestData: key["+key+"] useRules["+useRules+"] ruleResult["+ruleResult+"]";
    }
}
