package com.mace.maceAlert;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by A on 5/29/14.
 */
public class AccountActivity extends BaseActivity {
    Button button_credential;

    // Done Weexcel : the background is not white color, please use the ai suggested gray color


    //Done Weexcel : have you created the save animation?

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activty_account);
        button_credential = (Button) findViewById(R.id.button_credential);
        button_credential.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(AccountActivity.this, Edit_Account_.class);
                startActivity(in);
            }
        });




    }
}
