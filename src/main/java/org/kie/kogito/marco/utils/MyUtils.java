package org.kie.kogito.marco.utils;

public class MyUtils {
    public static String getAppInfos() {
        StringBuffer sb = new StringBuffer();
        sb.append("MyProcess example\n");
        sb.append("version 1.0");        
        return sb.toString();
    }
}
