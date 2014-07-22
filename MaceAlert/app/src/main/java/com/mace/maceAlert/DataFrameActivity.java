package com.mace.maceAlert;

import android.os.Bundle;

import com.ayla.domains.DevicePoint;
import com.ayla.domains.OnlineSetting;
import com.ayla.domains.Panel;
import com.ayla.domains.base.MyBaseEntity;
import com.ayla.logic.DataFrameParser;
import com.ayla.service.AylaService;
import com.mace.util.LazySingleton;

/**
 * Created by IntelliJ IDEA.
 * User: billy
 * Date: 2014/6/19
 * Time: 下午 01:20
 * interact with the cluod
 */

public class DataFrameActivity extends HelpActivity {
    AylaService service;
    DataFrameParser parser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        service= LazySingleton.getInstance();
        parser= DataFrameParser.getInstance();
    }



    public void logout(){
        //DOne Weexcel
        //should delete all locally sql stored
        // DevicePoint,OnlineSetting,Panel

        MyBaseEntity.deleteAll(DevicePoint.class);
        MyBaseEntity.deleteAll(OnlineSetting.class);
        MyBaseEntity.deleteAll(Panel.class);

        //keeping only emailAccount


    }

}
