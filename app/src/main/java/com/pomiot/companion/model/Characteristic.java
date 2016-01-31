package com.pomiot.companion.model;

/**
 * Created by Tomasz on 31.01.2016.
 */
public class Characteristic {

    public Characteristic(String description, String value){
        this.description = description;
        this.value = value;
    }

    private String description;

    private String value;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
