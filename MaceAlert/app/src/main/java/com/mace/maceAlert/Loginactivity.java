package com.mace.maceAlert;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.ayla.domains.Emailaccount;
import com.ayla.domains.base.MyBaseEntity;
import com.ayla.logic.LocationUt;
import com.mace.util.BusProvider;
import com.mace.util.LocationChangeEvent;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;

import hugo.weaving.DebugLog;


public class Loginactivity extends BaseLocationActivity {

    private final String TAG="login";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void actionSignin(View v)
    {
        Intent in=new Intent(Loginactivity.this,Location_Screen_Activity.class);
        startActivity(in);
    }

    public void actionForgotPassword(View v)
    {
        Intent in=new Intent(Loginactivity.this,ForgotpasswordActivity.class);
        startActivity(in);
    }

    public void actionSignUp(View v)
    {
        Intent in=new Intent(Loginactivity.this,Registration.class);
        startActivity(in);
    }


    @Subscribe
    public void onLocationChanged(LocationChangeEvent event) {
        double lat = event.lat;
        double lon = event.lon;

    }

}
