package com.mace.maceAlert;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;

import androidqa.IosSpinner;

/**
 * Created by A on 6/30/14.
 */
public class FirmwareUpdateActivity extends BaseActivity {


    TextView textView_firmware;
    ArrayList<String> firmwarelist;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.firmware_update);
        getSupportActionBar().setTitle("Current Version : 202");
        textView_firmware=(TextView)findViewById(R.id.textView_firmware);
        progressBar=(ProgressBar)findViewById(R.id.progressBar);
        firmwarelist=new ArrayList<String>();
        firmwarelist.add("Firmware 1");
        firmwarelist.add("Firmware 2");
        firmwarelist.add("Firmware 3");
        firmwarelist.add("Firmware 4");
        firmwarelist.add("Firmware 5");
        progressBar.setVisibility(View.VISIBLE);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent in =new Intent(FirmwareUpdateActivity.this, IosSpinner.class);
                in.putExtra(IosSpinner.PICKER,IosSpinner.MYLIST);
                in.putStringArrayListExtra(IosSpinner.LISTEXTRA,firmwarelist);
                startActivityForResult(in,104);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        progressBar.setVisibility(View.GONE);

                    }
                });
            }
        },3000);

        textView_firmware.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              if(progressBar.getVisibility()==View.GONE)
              {
                  Intent in = new Intent(FirmwareUpdateActivity.this, IosSpinner.class);
                  in.putExtra(IosSpinner.PICKER, IosSpinner.MYLIST);
                  in.putStringArrayListExtra(IosSpinner.LISTEXTRA, firmwarelist);
                  startActivityForResult(in, 104);
              }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK)
        {
            if(requestCode==104)
            {
                String name=data.getExtras().getString("firmwarename");
                textView_firmware.setText(name);
            }
        }
    }

    public void actionStartUpdate(View view) {
    }

    public void actionCancelUpdate(View view) {
    }
}
