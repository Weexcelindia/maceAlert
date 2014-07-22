package com.ayla.logic;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.location.Location;
import android.location.LocationManager;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.location.LocationClient;
import com.google.android.gms.location.LocationRequest;
import com.mace.util.BusProvider;
import com.mace.util.LocationChangeEvent;
import com.squareup.otto.Bus;
import com.squareup.otto.Produce;

public class LocationUt extends Service implements GooglePlayServicesClient.ConnectionCallbacks,
        GooglePlayServicesClient.OnConnectionFailedListener,com.google.android.gms.location.LocationListener{


    private static final LocationRequest REQUEST = LocationRequest.create()
            .setInterval(30 * 1000)  // request interval after 30 seconds
            .setFastestInterval(30* 1000)   // 1 second
            .setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);

    private LocationClient mLocationClient;
    double lastLatitude,lastLongitude;
    private final IBinder mBinder = new LocalBinder();


    @Override
    public void onConnected(Bundle bundle) {
        Log.d("FusedLocationService", "Fused Location Provider got connected successfully");
        Location loc=mLocationClient.getLastLocation();
        if(loc!=null)
        {
            lastLatitude=loc.getLatitude();
            lastLongitude=loc.getLongitude();
            BusProvider.getInstance().post(produceLocationEvent());  // sending the lastlocation to all registered activities
        }
        mLocationClient.requestLocationUpdates(REQUEST,this);

    }

    @Override
    public void onDisconnected() {
        Log.d("FusedLocationService","Fused Location Provider got disconnected successfully");
        stopSelf();
    }

    @Override
    public void onLocationChanged(Location location) {
        lastLatitude=location.getLatitude();
        lastLongitude=location.getLongitude();
        BusProvider.getInstance().post(produceLocationEvent());   // sending event to all registered components
        Toast.makeText(getApplicationContext(),"Location CHanged",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        Toast.makeText(getApplicationContext(),"Play service error",Toast.LENGTH_SHORT).show();
    }


    @Override
    public IBinder onBind(Intent intent) {
        mLocationClient = new LocationClient(this, this, this);
        mLocationClient.connect();
        return mBinder;
    }

    @Produce
    public LocationChangeEvent produceLocationEvent() {
        return new LocationChangeEvent(lastLatitude, lastLongitude);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
//      BusProvider.getInstance().unregister(this);
        mLocationClient.disconnect();
        Log.v("Ondestroy","servicedestroyed");
    }

    public class LocalBinder extends Binder {
        public LocationUt getService() {
            // Return this instance of LocalService so clients can call public methods
            return LocationUt.this;
        }
    }

    public double[] getUserLocation()
    {
        return new double[]{lastLatitude, lastLongitude};
    }


}
