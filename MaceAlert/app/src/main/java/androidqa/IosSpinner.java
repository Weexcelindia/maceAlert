package androidqa;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.actionbarsherlock.app.SherlockActivity;
import com.mace.maceAlert.CountryCodeReference;
import com.mace.maceAlert.R;
import com.mace.util.CountryCOde;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by A on 6/7/14.
 */
public class IosSpinner extends SherlockActivity{

    public static final String PICKER="iospickwer";
    public static final int COUNTRYCODE=0;
    public static final int TIMEZONE=1;
    public static final int MYLIST=2;
    public static final String LISTEXTRA="listextra";
    ArrayList<CountryCOde> list_codes;
    int picker=0;
    WheelView wheel;
    Button button_done;
    ArrayList<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spinnerwheel);
        picker=getIntent().getExtras().getInt(PICKER);
        button_done=(Button)findViewById(R.id.button_done);

        if(picker==COUNTRYCODE)
        {
            CountryCodeReference codeReference=new CountryCodeReference();
            list_codes=codeReference.getList_cntrycode();
        }else
        {
            list=getIntent().getStringArrayListExtra(LISTEXTRA);
        }

        wheel = (WheelView) findViewById(R.id.spinner);
        if(picker==COUNTRYCODE)
        {
            wheel.setViewAdapter(new ArrayWheelAdapter(this,list_codes));
        }else
        {
            wheel.setViewAdapter(new ArrayWheelAdapter(this,list));
        }
        wheel.setVisibleItems(4);
        wheel.setCurrentItem(0);
//        wheel.addChangingListener(changedListener);

            wheel.addScrollingListener(new OnWheelScrollListener() {
            @Override
            public void onScrollingStarted(WheelView wheel) {

            }

            @Override
            public void onScrollingFinished(WheelView wheel) {

            }
        });

        button_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent _result = new Intent();
                if(picker==COUNTRYCODE)
                {
                    CountryCOde cd = list_codes.get(wheel.getCurrentItem());
                    _result.putExtra("code", cd.getCode());
                    _result.putExtra("country", cd.getCountryname());
                }else
                {
                    _result.putExtra("firmwarename",list.get(wheel.getCurrentItem()));
                }
                setResult(Activity.RESULT_OK, _result);
                finish();
                overridePendingTransition(R.anim.dummy,R.anim.slidetop_to_btm);
            }
        });
    }

    @Override
    public void onBackPressed() {
    }
}

