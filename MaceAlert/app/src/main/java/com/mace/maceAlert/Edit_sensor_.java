package com.mace.maceAlert;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ToggleButton;

import com.mace.View.LocationView;
import com.mace.View.SaveBarView;

/**
 * Created by A on 5/30/14.
 */
public class Edit_sensor_ extends BaseActivity implements CompoundButton.OnCheckedChangeListener,SaveBarView.QuickactionListener{
    EditText edt_zone_sensor;
    ToggleButton toggleButton_sensor;
    LocationView locationview;
    SaveBarView save_bar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_sensor);
        edt_zone_sensor=(EditText)findViewById(R.id.edt_zone_sensor);
        edt_zone_sensor.setText(getIntent().getExtras().getString("name"));
        getSupportActionBar().setTitle(getIntent().getExtras().getString("title"));
        toggleButton_sensor=(ToggleButton)findViewById(R.id.toggleButton_sensor);
        toggleButton_sensor.setOnCheckedChangeListener(this);
        locationview=(LocationView)findViewById(R.id.locationview);
        save_bar=(SaveBarView)findViewById(R.id.save_bar);
        save_bar.setQuickactionListener(this);
        save_bar.hideBin();
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        if(!b)
        {
            compoundButton.setTextColor(getResources().getColor(R.color.blue_sky));
        }else
        {
            compoundButton.setTextColor(getResources().getColor(R.color.white));

        }
    }


    @Override
    public void onActionCancel(View v) {

    }

    @Override
    public void onActionSave(View v) {

    }

    @Override
    public void onActionBin(View v) {

    }
}
