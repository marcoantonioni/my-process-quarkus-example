package org.kie.kogito.marco.model;

public class MyData {
    private String name;
    private String description;

    public MyData(String name, String description) {
        this.name = name;
        this.description = description;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "MyData: name["+name+"] description["+description+"]";
    }
}
