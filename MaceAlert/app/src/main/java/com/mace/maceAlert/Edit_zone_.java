package com.mace.maceAlert;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.ToggleButton;

import com.mace.View.CenteredRadioImageButton;
import com.mace.View.SaveBarView;
import com.mace.View.SegmentedRadioGroup;

/**
 * Created by A on 5/27/14.
 */
public class Edit_zone_ extends BaseActivity implements RadioGroup.OnCheckedChangeListener,CompoundButton.OnCheckedChangeListener, SaveBarView.QuickactionListener {
    EditText edt_zone_naem;
    SegmentedRadioGroup segment_parent;
    CenteredRadioImageButton radio_arm,radio_alert,radio_off;
    ToggleButton toggleButton_arm,toggleButton_chime;
    SaveBarView save_bar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_zone_);
        save_bar=(SaveBarView)findViewById(R.id.save_bar);
        save_bar.hideBin();
        save_bar.setQuickactionListener(this);
        edt_zone_naem=(EditText)findViewById(R.id.edt_zone_sensor);
        radio_arm=(CenteredRadioImageButton) findViewById(R.id.tab1);
        radio_alert=(CenteredRadioImageButton) findViewById(R.id.tab2);
        radio_off=(CenteredRadioImageButton)findViewById(R.id.tab34);
        toggleButton_arm=(ToggleButton)findViewById(R.id.toggleButton_arm);
        toggleButton_chime=(ToggleButton)findViewById(R.id.toggleButton_sensor);
        toggleButton_arm.setOnCheckedChangeListener(this);
        toggleButton_chime.setOnCheckedChangeListener(this);
        radio_alert.setChecked(true);
        radio_alert.setTextColor(getResources().getColor(R.color.white));
        String name=getIntent().getExtras().getString("name");
        if(name!=null)
        {
            getSupportActionBar().setTitle(name);
            edt_zone_naem.setText(name);
        }
        segment_parent=(SegmentedRadioGroup)findViewById(R.id.segment_parent);
        segment_parent.setOnCheckedChangeListener(this);
    }


    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {

        radio_arm.setTextColor(getResources().getColor(R.color.blue_sky));
        radio_alert.setTextColor(getResources().getColor(R.color.blue_sky));
        radio_off.setTextColor(getResources().getColor(R.color.blue_sky));
        ((CenteredRadioImageButton) radioGroup.findViewById(i)).setTextColor(getResources().getColor(R.color.white));
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
