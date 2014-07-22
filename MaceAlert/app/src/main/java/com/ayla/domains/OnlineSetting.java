package com.ayla.domains;

import android.content.Context;

import com.ayla.domains.base.MyBaseEntity;
import com.orm.SugarRecord;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by IntelliJ IDEA.
 * User: billy
 * Date: 2014/6/19
 * Time: 下午 12:50
 */

public class OnlineSetting extends SugarRecord<OnlineSetting> {

    public String dsn;
    public String zone_oneSensorIds;
    public String zone_twoSensorIds;
    public String zone_threeSensorIds;
    public String zone_fourSensorIds;
    public String zone_fiveSensorIds;
    public String zone_sixSensorIds;
    public String zone_sevenSensorIds;
    public String zone_eightSensorIds;
    public String zone_oneName;
    public String zone_twoName;
    public String zone_threeName;
    public String zone_fourName;
    public String zone_fiveName;
    public String zone_sixName;
    public String zone_sevenName;
    public String zone_eightName;
    public String zone_oneMode;
    public String zone_twoMode;
    public String zone_threeMode;
    public String zone_fourMode;
    public String zone_fiveMode;
    public String zone_sixMode;
    public String zone_sevenMode;
    public String zone_eightMode;
    public String emergencyPhoneNumber;
    public String emailSignature;
    public String zimeZone;
    public String notificationMode;
    public String passwordProtected;
    public String updateTime;
    public String lastUpdateTime;

    public OnlineSetting(Context context) {
        super(context);
    }

    public OnlineSetting(Context context, String dsn, String zone_oneSensorIds, String zone_twoSensorIds, String zone_threeSensorIds, String zone_fourSensorIds, String zone_fiveSensorIds, String zone_sixSensorIds, String zone_sevenSensorIds, String zone_eightSensorIds, String zone_oneName, String zone_twoName, String zone_threeName, String zone_fourName, String zone_fiveName, String zone_sixName, String zone_sevenName, String zone_eightName, String zone_oneMode, String zone_twoMode, String zone_threeMode, String zone_fourMode, String zone_fiveMode, String zone_sixMode, String zone_sevenMode, String zone_eightMode, String emergencyPhoneNumber, String emailSignature, String zimeZone, String notificationMode, String passwordProtected, String updateTime, String lastUpdateTime) {
        super(context);
        this.dsn = dsn;
        this.zone_oneSensorIds = zone_oneSensorIds;
        this.zone_twoSensorIds = zone_twoSensorIds;
        this.zone_threeSensorIds = zone_threeSensorIds;
        this.zone_fourSensorIds = zone_fourSensorIds;
        this.zone_fiveSensorIds = zone_fiveSensorIds;
        this.zone_sixSensorIds = zone_sixSensorIds;
        this.zone_sevenSensorIds = zone_sevenSensorIds;
        this.zone_eightSensorIds = zone_eightSensorIds;
        this.zone_oneName = zone_oneName;
        this.zone_twoName = zone_twoName;
        this.zone_threeName = zone_threeName;
        this.zone_fourName = zone_fourName;
        this.zone_fiveName = zone_fiveName;
        this.zone_sixName = zone_sixName;
        this.zone_sevenName = zone_sevenName;
        this.zone_eightName = zone_eightName;
        this.zone_oneMode = zone_oneMode;
        this.zone_twoMode = zone_twoMode;
        this.zone_threeMode = zone_threeMode;
        this.zone_fourMode = zone_fourMode;
        this.zone_fiveMode = zone_fiveMode;
        this.zone_sixMode = zone_sixMode;
        this.zone_sevenMode = zone_sevenMode;
        this.zone_eightMode = zone_eightMode;
        this.emergencyPhoneNumber = emergencyPhoneNumber;
        this.emailSignature = emailSignature;
        this.zimeZone = zimeZone;
        this.notificationMode = notificationMode;
        this.passwordProtected = passwordProtected;
        this.updateTime = updateTime;
        this.lastUpdateTime = lastUpdateTime;
    }

    /**
     * done Weexcel should have a easy to json method to print object out
     * can be implement in MyBaseEntity or just in here onlineSetting
     */

    public void toJson() {
        toString();
    }

    @Override
    /**
     * Print object out
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("***** OnlineSetting Details *****\n");
        sb.append("dsn=" + getId() + "\n");

        sb.append("zone_oneName=" + zone_oneName + "\n");
        sb.append("zone_twoName=" + zone_twoName + "\n");
        sb.append("zone_threeName=" + zone_threeName + "\n");
        sb.append("zone_fourName=" + zone_fourName + "\n");
        sb.append("zone_fiveName=" + zone_fiveName + "\n");
        sb.append("zone_sixName=" + zone_sixName + "\n");
        sb.append("zone_sevenName=" + zone_sevenName + "\n");
        sb.append("zone_eightName=" + zone_eightName + "\n");

        sb.append("zone_oneMode=" + zone_oneMode + "\n");
        sb.append("zone_twoMode=" + zone_twoMode + "\n");
        sb.append("zone_threeMode=" + zone_threeMode + "\n");
        sb.append("zone_fourMode=" + zone_fourMode + "\n");
        sb.append("zone_fiveMode=" + zone_fiveMode + "\n");
        sb.append("zone_sixMode=" + zone_sixMode + "\n");
        sb.append("zone_sevenMode=" + zone_sevenMode + "\n");
        sb.append("zone_eightMode=" + zone_eightMode + "\n");

        sb.append("zone_oneSensorIds=" + zone_oneSensorIds + "\n");
        sb.append("zone_twoSensorIds=" + zone_twoSensorIds + "\n");
        sb.append("zone_threeSensorIds=" + zone_threeSensorIds + "\n");
        sb.append("zone_fourSensorIds=" + zone_fourSensorIds + "\n");
        sb.append("zone_fiveSensorIds=" + zone_fiveSensorIds + "\n");
        sb.append("zone_sixSensorIds=" + zone_sixSensorIds + "\n");
        sb.append("zone_sevenSensorIds=" + zone_sevenSensorIds + "\n");
        sb.append("zone_eightSensorIds=" + zone_eightSensorIds + "\n");


        sb.append("emergencyPhoneNumber=" + emergencyPhoneNumber + "\n");
        sb.append("emailSignature=" + emailSignature + "\n");
        sb.append("zimeZone=" + zimeZone + "\n");
        sb.append("passwordProtected=" + passwordProtected + "\n");
        sb.append("updateTime=" + updateTime + "\n");
        sb.append("lastUpdateTime=" + lastUpdateTime + "\n");
        sb.append("notificationMode=" + notificationMode + "\n");
        sb.append("*****************************");

        return sb.toString();
    }

    /**
     * done Weexcel should have a deserializer from json ,can be static method or class method
     *
     * @param json
     */

    public void fromJson(JSONObject json) {
        try {
            dsn = json.getString("dsn");
            zone_oneSensorIds = json.getString("zone_oneSensorIds");
            zone_twoSensorIds = json.getString("zone_twoSensorIds");
            zone_threeSensorIds = json.getString("zone_threeSensorIds");
            zone_fourSensorIds = json.getString("zone_fourSensorIds");
            zone_fiveSensorIds = json.getString("zone_fiveSensorIds");
            zone_sixSensorIds = json.getString("zone_sixSensorIds");
            zone_sevenSensorIds = json.getString("zone_sevenSensorIds");
            zone_eightSensorIds = json.getString("zone_eightSensorIds");
            zone_oneMode = json.getString("zone_oneMode");
            zone_twoMode = json.getString("zone_twoMode");
            zone_threeMode = json.getString("zone_threeMode");
            zone_fourMode = json.getString("zone_fourMode");
            zone_fiveMode = json.getString("zone_fiveMode");
            zone_sixMode = json.getString("zone_sixMode");
            zone_sevenMode = json.getString("zone_sevenMode");
            zone_eightMode = json.getString("zone_eightMode");
            zone_oneName = json.getString("zone_oneName");
            zone_twoName = json.getString("zone_twoName");
            zone_threeName = json.getString("zone_threeName");
            zone_fourName = json.getString("zone_fourName");
            zone_fiveName = json.getString("zone_fiveName");
            zone_sixName = json.getString("zone_sixName");
            zone_sevenName = json.getString("zone_sevenName");
            zone_eightName = json.getString("zone_eightName");
            emergencyPhoneNumber = json.getString("emergencyPhoneNumber");
            emailSignature = json.getString("emailSignature");
            zimeZone = json.getString("zimeZone");
            notificationMode = json.getString("notificationMode");
            passwordProtected = json.getString("passwordProtected");
            updateTime = json.getString("updateTime");
            lastUpdateTime = json.getString("lastUpdateTime");

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }


    public String getDsn() {
        return dsn;
    }

    public String getZone_oneSensorIds() {
        return zone_oneSensorIds;
    }

    public String getZone_twoSensorIds() {
        return zone_twoSensorIds;
    }

    public String getZone_threeSensorIds() {
        return zone_threeSensorIds;
    }

    public String getZone_fourSensorIds() {
        return zone_fourSensorIds;
    }

    public String getZone_fiveSensorIds() {
        return zone_fiveSensorIds;
    }

    public String getZone_sixSensorIds() {
        return zone_sixSensorIds;
    }

    public String getZone_sevenSensorIds() {
        return zone_sevenSensorIds;
    }

    public String getZone_eightSensorIds() {
        return zone_eightSensorIds;
    }

    public String getZone_oneName() {
        return zone_oneName;
    }

    public String getZone_twoName() {
        return zone_twoName;
    }

    public String getZone_threeName() {
        return zone_threeName;
    }

    public String getZone_fourName() {
        return zone_fourName;
    }

    public String getZone_fiveName() {
        return zone_fiveName;
    }

    public String getZone_sixName() {
        return zone_sixName;
    }

    public String getZone_sevenName() {
        return zone_sevenName;
    }

    public String getZone_eightName() {
        return zone_eightName;
    }

    public String getZone_oneMode() {
        return zone_oneMode;
    }

    public String getZone_twoMode() {
        return zone_twoMode;
    }

    public String getZone_threeMode() {
        return zone_threeMode;
    }

    public String getZone_fourMode() {
        return zone_fourMode;
    }

    public String getZone_fiveMode() {
        return zone_fiveMode;
    }

    public String getZone_sixMode() {
        return zone_sixMode;
    }

    public String getZone_sevenMode() {
        return zone_sevenMode;
    }

    public String getZone_eightMode() {
        return zone_eightMode;
    }

    public String getEmergencyPhoneNumber() {
        return emergencyPhoneNumber;
    }

    public String getEmailSignature() {
        return emailSignature;
    }

    public String getZimeZone() {
        return zimeZone;
    }

    public String getNotificationMode() {
        return notificationMode;
    }

    public String getPasswordProtected() {
        return passwordProtected;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public String getLastUpdateTime() {
        return lastUpdateTime;
    }
}
