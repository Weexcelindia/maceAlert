package com.mace.util;

/**
 * Created by A on 6/25/14.
 */
public class LocationChangeEvent {
    public final double lat;
    public final double lon;

    public LocationChangeEvent(double lat, double lon) {
        this.lat = lat;
        this.lon = lon;
    }

    @Override public String toString() {
        return new StringBuilder("(")
                .append(lat)
                .append(", ")
                .append(lon)
                .append(")")
                .toString();
    }

}
