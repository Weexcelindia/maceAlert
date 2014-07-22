package com.mace.maceAlert;

import android.os.Bundle;

import com.mace.View.SaveBarView;

/**
 * Created by A on 5/31/14.
 */
public class ActivityAlarm extends BaseActivity{
    SaveBarView save_bar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);
        save_bar=(SaveBarView)findViewById(R.id.save_bar);
        save_bar.hideBin();

    }
}
