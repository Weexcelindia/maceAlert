package com.mace.maceAlert;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by A on 7/1/14.
 */
public class Addc_location extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addc_location);
    }


    public void actionDummy(View view) {
    Intent in =new Intent(Addc_location.this,ConnectedScreen.class);
        startActivity(in);
    }
}
