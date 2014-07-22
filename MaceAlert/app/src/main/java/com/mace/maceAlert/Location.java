package com.mace.maceAlert;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


public class Location extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.move_to_back, R.anim.slide_out_lright);
    }


    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment implements View.OnClickListener{

        TextView textView2;
        LinearLayout linear_mode;
        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_location, container, false);
            textView2=(TextView)rootView.findViewById(R.id.txt_time);
            linear_mode=(LinearLayout)rootView.findViewById(R.id.linear_mode);

            textView2.setOnClickListener(this);
            linear_mode.setOnClickListener(this);
            return rootView;
        }


        @Override
        public void onClick(View view) {
            if(view==textView2)
            {
                Intent in=new Intent(getActivity(),Location_Register.class);
                startActivity(in);
            }else if(view==linear_mode)
            {
                Intent in=new Intent(getActivity(),MainTabActivity.class);
                startActivity(in);
            }


        }
    }
}
