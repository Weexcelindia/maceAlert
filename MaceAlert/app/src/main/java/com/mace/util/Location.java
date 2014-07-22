package com.mace.util;

/**
 * Created by A on 6/26/14.
 */
public class Location {

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Location(String desc, int id, boolean online) {
        this.desc = desc;
        this.id = id;
        this.online = online;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String desc;
    private int id;
    private boolean online;


    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }
}

