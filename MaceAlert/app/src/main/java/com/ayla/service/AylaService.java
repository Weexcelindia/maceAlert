package com.ayla.service;

import com.ayla.service.lang.f;

/**
 * Created by IntelliJ IDEA.
 * User: billy
 * Date: 2014/6/3
 * Time: 上午 01:02
 */
public interface AylaService {


    public void register(String  firstName,String lastName,String email,String password,String passcode, String countryCode,f successCallback,f failCallback);

    public void login(String  email,String password,f successCallback,f failCallback);

    public void forgetPassword(String  email,f successCallback,f failCallback);

}
