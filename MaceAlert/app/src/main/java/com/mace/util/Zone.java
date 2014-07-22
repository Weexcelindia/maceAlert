package com.mace.util;

/**
 * Created by A on 5/27/14.
 */
public class Zone {
    String name;
    String desc;

    public Zone(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

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
