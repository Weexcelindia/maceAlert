package com.mace.util;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.os.ParcelableCompat;

import java.io.Serializable;

/**
 * Created by A on 7/1/14.
 */
public class Firmware implements Parcelable{
    private int id;
    private String firmwareName;

    public Firmware(int id, String firmwareName) {
        this.id = id;
        this.firmwareName = firmwareName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirmwareName() {
        return firmwareName;
    }

    public void setFirmwareName(String firmwareName) {
        this.firmwareName = firmwareName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

    }

    public Firmware(Parcel in) {
        super();
        readFromParcel(in);
    }

    public static final Parcelable.Creator<Firmware> CREATOR = new Parcelable.Creator<Firmware>() {
        public Firmware createFromParcel(Parcel in) {
            return new Firmware(in);
        }

        public Firmware[] newArray(int size) {

            return new Firmware[size];
        }

    };

    public void readFromParcel(Parcel in) {
        String[] result = new String[23];
        in.readStringArray(result);
        this.id = Integer.parseInt(result[0]);
        this.firmwareName = result[1];


    }


}
