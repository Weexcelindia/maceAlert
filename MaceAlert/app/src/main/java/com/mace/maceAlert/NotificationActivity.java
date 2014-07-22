package com.mace.maceAlert;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

/**
 * Created by A on 5/29/14.
 */

public class NotificationActivity extends BaseActivity implements View.OnClickListener,CompoundButton.OnCheckedChangeListener{

    Button button_contact;
    ToggleButton toggleButton_text,toggleButton_email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        button_contact=(Button)findViewById(R.id.button_contacts);
        button_contact.setOnClickListener(this);
        toggleButton_text=(ToggleButton)findViewById(R.id.toggleButton_arm);
        toggleButton_email=(ToggleButton)findViewById(R.id.toggleButton_email);
        toggleButton_email.setOnCheckedChangeListener(this);
        toggleButton_text.setOnCheckedChangeListener(this);

    }


    @Override
    public void onClick(View view) {
        if(view==button_contact)
        {
            Intent in=new Intent(NotificationActivity.this,ActivityContact.class);
            startActivity(in);
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

        if(b)
        {
            compoundButton.setTextColor(getResources().getColor(R.color.white));
        }else
        {
            compoundButton.setTextColor(getResources().getColor(R.color.blue_sky));

        }

    }
}
