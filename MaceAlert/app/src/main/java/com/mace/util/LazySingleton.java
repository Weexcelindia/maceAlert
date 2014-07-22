package com.mace.util;

import com.ayla.service.AylaService;
import com.ayla.service.lang.f;

import hugo.weaving.DebugLog;

/**
 * Created by A on 6/6/14.
 */
public class LazySingleton implements AylaService {

    private static AylaService instance;

    @DebugLog
    @Override
    public void register(String firstName, String lastName, String email, String password, String passcode, String countryCode, f successCallback, f failCallback) {

    }
    @DebugLog
    @Override
    public void login(String email, String password, f successCallback, f failCallback) {

    }

    @DebugLog
    @Override
    public void forgetPassword(String email, f successCallback, f failCallback) {

    }

    public static AylaService getInstance()
    {
        if(instance==null)
        {
            instance=new LazySingleton();
        }
        return instance;
    }

}
