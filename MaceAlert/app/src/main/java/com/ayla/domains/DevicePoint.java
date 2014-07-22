package com.ayla.domains;

import android.content.Context;

import com.ayla.domains.base.MyBaseEntity;
import com.orm.SugarRecord;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: billy
 * Date: 2014/6/19
 * Time: 下午 12:48
 */

public class DevicePoint extends SugarRecord<DevicePoint>{

    public String checksum;
    public String createdAt;
    public String createdAtAtr;
    public int header;
    public int type;
    public int sensorType;
    //TODO should save query index on this attribute``
    public String dsn;
    public int force;
    public String sensorId;
    public String raw;
    public int datasix;
    public int dataseven;
    public int dataChange;
    public int tamper;
    public int lowVoltage;
    public int editMode;
    public int sensorLost;
    public int acPower;
    public int key;
    public int home;
    public int alert;
    public int wifiDisconnect;
    public int arm;
    public int unknown;
    public int version;
    public int disarm;
    public int panic;
    public int trigger;
    public int closeTrigger;
    public int modeArmHome;
    public int modeArm;
    public int modeAlertHome;
    public int exitDelayMinutes;
    public int exitDelaySecond;
    public int exitOnOff;
    public int entryDelayMinutes;
    public int entryDelaySecond;
    public int entryOnOff;
    public int alarmTimeMInutes;
    public int alarmOnOff;
    public int alarmTimeMinutes;
    public int onOff;
    public int modeAlert;
    public String sensorName;
    public int openTrigger;
    public int year;
    public int month;
    public int day;
    public int senhoursorName;
    public int minute;
    public int week;
    public int uploadPoint;
    public int uploadRequestNo;
    public int uploadRequestSuccess;
    public int uploadRequestContinue;
    public int uploadRequestCrcFailed;
    public int uploadRequestFailedUnknow;
    public boolean clientPoint;

    public DevicePoint(Context context) {
        super(context);
    }

    public DevicePoint(Context context, String checksum, String createdAt, String createdAtAtr, int header, int type, int sensorType, String dsn, int force, String sensorId, String raw, int datasix, int dataseven, int dataChange, int tamper, int lowVoltage, int editMode, int sensorLost, int acPower, int key, int home, int alert, int wifiDisconnect, int arm, int unknown, int version, int disarm, int panic, int trigger, int closeTrigger, int modeArmHome, int modeArm, int modeAlertHome, int exitDelayMinutes, int exitDelaySecond, int exitOnOff, int entryDelayMinutes, int entryDelaySecond, int entryOnOff, int alarmTimeMInutes, int alarmOnOff, int alarmTimeMinutes, int onOff, int modeAlert, String sensorName, int openTrigger, int year, int month, int day, int senhoursorName, int minute, int week, int uploadPoint, int uploadRequestNo, int uploadRequestSuccess, int uploadRequestContinue, int uploadRequestCrcFailed, int uploadRequestFailedUnknow, boolean clientPoint) {
        super(context);
        this.checksum = checksum;
        this.createdAt = createdAt;
        this.createdAtAtr = createdAtAtr;
        this.header = header;
        this.type = type;
        this.sensorType = sensorType;
        this.dsn = dsn;
        this.force = force;
        this.sensorId = sensorId;
        this.raw = raw;
        this.datasix = datasix;
        this.dataseven = dataseven;
        this.dataChange = dataChange;
        this.tamper = tamper;
        this.lowVoltage = lowVoltage;
        this.editMode = editMode;
        this.sensorLost = sensorLost;
        this.acPower = acPower;
        this.key = key;
        this.home = home;
        this.alert = alert;
        this.wifiDisconnect = wifiDisconnect;
        this.arm = arm;
        this.unknown = unknown;
        this.version = version;
        this.disarm = disarm;
        this.panic = panic;
        this.trigger = trigger;
        this.closeTrigger = closeTrigger;
        this.modeArmHome = modeArmHome;
        this.modeArm = modeArm;
        this.modeAlertHome = modeAlertHome;
        this.exitDelayMinutes = exitDelayMinutes;
        this.exitDelaySecond = exitDelaySecond;
        this.exitOnOff = exitOnOff;
        this.entryDelayMinutes = entryDelayMinutes;
        this.entryDelaySecond = entryDelaySecond;
        this.entryOnOff = entryOnOff;
        this.alarmTimeMInutes = alarmTimeMInutes;
        this.alarmOnOff = alarmOnOff;
        this.alarmTimeMinutes = alarmTimeMinutes;
        this.onOff = onOff;
        this.modeAlert = modeAlert;
        this.sensorName = sensorName;
        this.openTrigger = openTrigger;
        this.year = year;
        this.month = month;
        this.day = day;
        this.senhoursorName = senhoursorName;
        this.minute = minute;
        this.week = week;
        this.uploadPoint = uploadPoint;
        this.uploadRequestNo = uploadRequestNo;
        this.uploadRequestSuccess = uploadRequestSuccess;
        this.uploadRequestContinue = uploadRequestContinue;
        this.uploadRequestCrcFailed = uploadRequestCrcFailed;
        this.uploadRequestFailedUnknow = uploadRequestFailedUnknow;
        this.clientPoint = clientPoint;
    }

    public String getChecksum() {
        return checksum;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getCreatedAtAtr() {
        return createdAtAtr;
    }

    public int getHeader() {
        return header;
    }

    public int getType() {
        return type;
    }

    public int getSensorType() {
        return sensorType;
    }

    public String getDsn() {
        return dsn;
    }

    public int getForce() {
        return force;
    }

    public String getSensorId() {
        return sensorId;
    }

    public String getRaw() {
        return raw;
    }

    public int getDatasix() {
        return datasix;
    }

    public int getDataseven() {
        return dataseven;
    }

    public int getDataChange() {
        return dataChange;
    }

    public int getTamper() {
        return tamper;
    }

    public int getLowVoltage() {
        return lowVoltage;
    }

    public int getEditMode() {
        return editMode;
    }

    public int getSensorLost() {
        return sensorLost;
    }

    public int getAcPower() {
        return acPower;
    }

    public int getKey() {
        return key;
    }

    public int getHome() {
        return home;
    }

    public int getAlert() {
        return alert;
    }

    public int getWifiDisconnect() {
        return wifiDisconnect;
    }

    public int getArm() {
        return arm;
    }

    public int getUnknown() {
        return unknown;
    }

    public int getVersion() {
        return version;
    }

    public int getDisarm() {
        return disarm;
    }

    public int getPanic() {
        return panic;
    }

    public int getTrigger() {
        return trigger;
    }

    public int getCloseTrigger() {
        return closeTrigger;
    }

    public int getModeArmHome() {
        return modeArmHome;
    }

    public int getModeArm() {
        return modeArm;
    }

    public int getModeAlertHome() {
        return modeAlertHome;
    }

    public int getExitDelayMinutes() {
        return exitDelayMinutes;
    }

    public int getExitDelaySecond() {
        return exitDelaySecond;
    }

    public int getExitOnOff() {
        return exitOnOff;
    }

    public int getEntryDelayMinutes() {
        return entryDelayMinutes;
    }

    public int getEntryDelaySecond() {
        return entryDelaySecond;
    }

    public int getEntryOnOff() {
        return entryOnOff;
    }

    public int getAlarmTimeMInutes() {
        return alarmTimeMInutes;
    }

    public int getAlarmOnOff() {
        return alarmOnOff;
    }

    public int getAlarmTimeMinutes() {
        return alarmTimeMinutes;
    }

    public int getOnOff() {
        return onOff;
    }

    public int getModeAlert() {
        return modeAlert;
    }

    public String getSensorName() {
        return sensorName;
    }

    public int getOpenTrigger() {
        return openTrigger;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public int getSenhoursorName() {
        return senhoursorName;
    }

    public int getMinute() {
        return minute;
    }

    public int getWeek() {
        return week;
    }

    public int getUploadPoint() {
        return uploadPoint;
    }

    public int getUploadRequestNo() {
        return uploadRequestNo;
    }

    public int getUploadRequestSuccess() {
        return uploadRequestSuccess;
    }

    public int getUploadRequestContinue() {
        return uploadRequestContinue;
    }

    public int getUploadRequestCrcFailed() {
        return uploadRequestCrcFailed;
    }

    public int getUploadRequestFailedUnknow() {
        return uploadRequestFailedUnknow;
    }

    public boolean isClientPoint() {
        return clientPoint;
    }


}
