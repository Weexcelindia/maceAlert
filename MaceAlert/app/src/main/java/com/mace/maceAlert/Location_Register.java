package com.mace.maceAlert;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class Location_Register extends BaseActivity {

    Button button_next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location__register);
        button_next=(Button)findViewById(R.id.button_next);


        button_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in =new Intent(Location_Register.this,Addc_location.class);
                startActivity(in);
            }
        });

    }


}
