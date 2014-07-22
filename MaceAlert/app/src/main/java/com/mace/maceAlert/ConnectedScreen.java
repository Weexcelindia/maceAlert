package com.mace.maceAlert;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by A on 7/1/14.
 */
public class ConnectedScreen extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.connectedscreen);
    }


    public void actionSetup(View view) {
        Intent in =new Intent(ConnectedScreen.this,SetupScreen.class);
                startActivity(in);
    }
}
