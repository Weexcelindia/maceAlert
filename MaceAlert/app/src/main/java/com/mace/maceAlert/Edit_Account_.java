package com.mace.maceAlert;

import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.mace.View.SaveBarView;

/**
 * Created by A on 5/29/14.
 */
public class Edit_Account_ extends BaseActivity implements CompoundButton.OnCheckedChangeListener,View.OnClickListener,SaveBarView.QuickactionListener {
    ToggleButton toggleButton_pswd_prtcn;
    ImageView img_eye;
    EditText edt_password;
    SaveBarView save_bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_credential);

        toggleButton_pswd_prtcn=(ToggleButton)findViewById(R.id.toggleButton_arm);
        toggleButton_pswd_prtcn.setOnCheckedChangeListener(this);
        toggleButton_pswd_prtcn.setChecked(false);
        img_eye=(ImageView)findViewById(R.id.img_eye);
        img_eye.setImageLevel(0);   // default
        img_eye.setOnClickListener(this);
        edt_password=(EditText)findViewById(R.id.edt_password);
        edt_password.setInputType(129);  //default
        save_bar=(SaveBarView)findViewById(R.id.save_bar);
        save_bar.hideBin();
        save_bar.setQuickactionListener(this);
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
    public void onClick(View view) {
            if(view==img_eye)
        {
            toggle_eye();
        }
    }

    private void toggle_eye() {
        if(img_eye.getDrawable().getLevel()==0)
        {
            img_eye.setImageLevel(1);
            edt_password.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
            edt_password.setSelection(edt_password.length());
        }else
        {
            img_eye.setImageLevel(0);
            edt_password.setInputType(129);
            edt_password.setSelection(edt_password.length());

        }
    }

    @Override
    public void onActionCancel(View v) {
        finish();
    }

    @Override
    public void onActionSave(View v) {

    }

    @Override
    public void onActionBin(View v) {

    }
}
