package com.mace.util;

/**
 * Created by A on 5/23/14.
 */
public class Events {

    private String action;
    private String door;      // back door etc
    private String time;      // log time
    private String zone;      // zone 1,2
    private String eventType;  // like Alarm or Fault

    public Events(String action, String door, String time, String zone, String eventType) {
        this.action = action;
        this.door = door;
        this.time = time;
        this.zone = zone;
        this.eventType = eventType;
    }


    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getDoor() {
        return door;
    }

    public void setDoor(String door) {
        this.door = door;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }
}
