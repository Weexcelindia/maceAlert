package com.mace.maceAlert;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ayla.service.lang.f;
import com.mace.util.CountryCOde;
import com.mace.util.Validation;

import androidqa.IosSpinner;
import hugo.weaving.DebugLog;


public class Registration extends BaseActivity implements View.OnClickListener{

    EditText edt_passcode,edt_pswd,edt_email,edt_lastname,edt_firstname;
    Button btn_register,edt_country;
    CountryCOde cd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_registration);
        init();

        edt_country.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(Registration.this, IosSpinner.class);
                in.putExtra(IosSpinner.PICKER,IosSpinner.COUNTRYCODE);
                startActivityForResult(in,101);
                overridePendingTransition(R.anim.slidebtm_to_top, R.anim.dummy);
            }
        });
    }

    @Override
    public void onClick(View view) {
        if(view==btn_register)
        {
            reigsterPressed();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(requestCode==101&&resultCode==RESULT_OK)
        {
            edt_country.setError(null);
            cd=new CountryCOde(data.getExtras().getString("country"),data.getExtras().getString("code"));
            cd.setCode(data.getExtras().getString("code"));
            edt_country.setText(cd.getCountryname());
        }
        super.onActivityResult(requestCode, resultCode, data);

    }


    private void init() {
        edt_firstname=(EditText)findViewById(R.id.edt_firstname);
        edt_lastname=(EditText)findViewById(R.id.edt_lastname);
        edt_country=(Button)findViewById(R.id.edt_country);
        edt_passcode=(EditText)findViewById(R.id.edt_passcode);
        edt_pswd=(EditText)findViewById(R.id.edt_pswd);
        edt_email=(EditText)findViewById(R.id.edt_email);
        btn_register=(Button)findViewById(R.id.btn_register);
        btn_register.setOnClickListener(this);
    }


    public void reigsterPressed(){

        //Done Weexcel:Should valid email is valid address or not, if not prompt alert
        //check fort first name ,country,, lastname, password, cannot be empty,should prompty alert if missing

        boolean should_register =false;
        if(Validation.hasText(edt_firstname)&&Validation.hasText(edt_lastname)&&Validation.isEmailAddress(edt_email,true)&&Validation.hasText(edt_pswd)&&Validation.hasText(edt_passcode))
        {
            if(cd!=null)
            {
                should_register = true;
            }else
            {
                edt_country.setError("Required");
            }
        }

        //Done Weexcel: collect ui change & call register
        if(should_register)
        {
            register(edt_firstname.getText().toString(), edt_lastname.getText().toString(), edt_email.getText().toString(), edt_pswd.getText().toString(), edt_passcode.getText().toString(), cd.getCode());
        }

    }


    public void register(String firstName,String lastName,String email,String password,String passcode, String countryCode){

        Log.v("Tag",firstName+" "+lastName+" "+email+" "+password+" "+passcode+" "+countryCode);

            service.register(firstName,lastName,email,password,passcode,countryCode,new f(){
                @Override
                public void run() {
                    //run after successful registration
                }
            },new f(){
                @Override
                public void run() {
                    //run after failed registration
                }
            });
    }

}
