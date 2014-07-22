package com.mace.util;

/**
 * Created by A on 5/28/14.
 */
public class Contact {

    private String name;

    public Contact(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    private String desc;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
