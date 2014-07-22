package com.mace.maceAlert;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.actionbarsherlock.app.SherlockFragmentActivity;


public class MainActivity extends SherlockFragmentActivity {

    private final int SPLASH_TIME=2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent in=new Intent(MainActivity.this,Loginactivity.class);
                startActivity(in);
                finish();
            }
        }, SPLASH_TIME);



    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed(); no back pressing during splash
    }



}
