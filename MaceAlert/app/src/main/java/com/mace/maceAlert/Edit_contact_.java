package com.mace.maceAlert;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.mace.View.CenteredRadioImageButton;
import com.mace.View.SegmentedRadioGroup;
import com.mace.util.CountryCOde;

import androidqa.IosSpinner;


public class Edit_contact_ extends BaseActivity implements RadioGroup.OnCheckedChangeListener {

    EditText edt_name;
    SegmentedRadioGroup segment_parent,segment_parent1;
    CenteredRadioImageButton tab1,tab2,tab3,tab2_1,tab2_2;
    Button edt_country;
    CountryCOde cd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_contacts);
        edt_name=(EditText)findViewById(R.id.edt_name);
        edt_country=(Button)findViewById(R.id.edt_country);
        String name=getIntent().getExtras().getString("name");
        getSupportActionBar().setTitle(name);
        edt_name.setText(name);
        segment_parent=(SegmentedRadioGroup)findViewById(R.id.segment_parent);
        segment_parent1=(SegmentedRadioGroup)findViewById(R.id.segment_parent2);
        segment_parent.setOnCheckedChangeListener(this);
        segment_parent1.setOnCheckedChangeListener(this);

        tab1=(CenteredRadioImageButton)findViewById(R.id.tab1);
        tab2=(CenteredRadioImageButton)findViewById(R.id.tab2);
        tab3=(CenteredRadioImageButton)findViewById(R.id.tab34);
        tab2_1=(CenteredRadioImageButton)findViewById(R.id.tab2_1);
        tab2_2=(CenteredRadioImageButton)findViewById(R.id.tab2_2);

        tab1.setChecked(true);
        tab1.setTextColor(getResources().getColor(R.color.white));
        tab2_1.setChecked(true);
        tab2_1.setTextColor(getResources().getColor(R.color.white));

        edt_country.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(Edit_contact_.this, IosSpinner.class);
                in.putExtra(IosSpinner.PICKER,IosSpinner.COUNTRYCODE);
                startActivityForResult(in,100);
                overridePendingTransition(R.anim.slidebtm_to_top,R.anim.dummy);

            }
        });
    }


    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {

        if(radioGroup==segment_parent) {
            tab1.setTextColor(getResources().getColor(R.color.blue_sky));
            tab2.setTextColor(getResources().getColor(R.color.blue_sky));
            tab3.setTextColor(getResources().getColor(R.color.blue_sky));
            ((CenteredRadioImageButton) radioGroup.findViewById(i)).setTextColor(getResources().getColor(R.color.white));
        }else
        {
            tab2_1.setTextColor(getResources().getColor(R.color.blue_sky));
            tab2_2.setTextColor(getResources().getColor(R.color.blue_sky));
            ((CenteredRadioImageButton) radioGroup.findViewById(i)).setTextColor(getResources().getColor(R.color.white));

        }

    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(requestCode==100&&resultCode==RESULT_OK)
        {
           cd=new CountryCOde(data.getExtras().getString("country"),data.getExtras().getString("code"));
           cd.setCode(data.getExtras().getString("code"));
           edt_country.setText(cd.getCountryname());
        }
        super.onActivityResult(requestCode, resultCode, data);

    }
}
