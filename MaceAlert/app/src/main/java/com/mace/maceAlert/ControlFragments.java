package com.mace.maceAlert;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockFragment;
import com.mace.View.LocationView;
import com.mace.util.Constants;

/**
 * Created by A on 5/22/14.
 */

public class ControlFragments extends SherlockFragment implements View.OnClickListener,View.OnTouchListener{
    Button button_change_mode;
    float pointer_up_x =0, pointer_up_y =0;
    private static final float minimum_distance= 200.0f;
    OnSwipeMode swipeMode;
    TextView txt_mode,txt_des;
    ImageView img_mode;
    SharedPreferences pref;
    Button imageView_on_off,imageView_emergency;
    LocationView locationview;
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        swipeMode= (OnSwipeMode)activity;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_control,container,false);
        locationview=(LocationView)v.findViewById(R.id.locationview);
        locationview.setState_active(true);
        locationview.setOnClickListener(this);
        button_change_mode=(Button)v.findViewById(R.id.button_change_mode);
        button_change_mode.setOnTouchListener(this);
        txt_mode=(TextView)v.findViewById(R.id.textView_mode);
        txt_des=(TextView)v.findViewById(R.id.textView_mode_desc);
        img_mode=(ImageView)v.findViewById(R.id.imageView_mode);
        imageView_emergency=(Button)v.findViewById(R.id.imageView_emergency);
        imageView_emergency.setOnClickListener(this);
        imageView_on_off=(Button)v.findViewById(R.id.imageView_on_off);
        imageView_on_off.setOnClickListener(this);
        return v;
    }

    @Override
    public void onResume() {
       super.onResume();
       pref=getSherlockActivity().getSharedPreferences(Constants.PREFERENCE_NAME, Context.MODE_PRIVATE);
       int mode=pref.getInt(Constants.SELECTED_MODE,0);
       txt_mode.setText(ChangeModeFragment.Mode.values()[mode].getMode());
       txt_des.setText(ChangeModeFragment.Mode.values()[mode].getDesc());

        switch (ChangeModeFragment.Mode.values()[mode].getId())
        {
            case R.drawable.ic_level_icon_lock:
                img_mode.setImageResource(R.drawable.btn_arm);
            break;
            case R.drawable.ic_level_icon_home:
                img_mode.setImageResource(R.drawable.btn_home);
                break;
            case R.drawable.ic_level_icon_chime:
                img_mode.setImageResource(R.drawable.btn_alert);
                break;
            case R.drawable.ic_level_icon_disarm:
                img_mode.setImageResource(R.drawable.btn_lock);
                break;
            case R.drawable.ic_level_icon_panic:
                img_mode.setImageResource(R.drawable.btn_panic);
                break;

        }
    }

    @Override
    public void onClick(View view) {
    if(view==locationview)
    {
        Toast.makeText(getActivity(),"CLicked",300).show();
    }

    }

    //only for button_change_mode
    @Override
    public boolean onTouch(View view,MotionEvent event) {
        int eventaction = event.getAction();

        switch (eventaction) {
            case MotionEvent.ACTION_DOWN:
                // finger touches the screen
                pointer_up_x =event.getX();
                pointer_up_y =event.getY();
                view.setPressed(true);
                break;

            case MotionEvent.ACTION_MOVE:
                // finger moves on the screen

                break;

            case MotionEvent.ACTION_UP:
                // finger leaves the screen
                float dx= (pointer_up_x-event.getX());
                float dy= (pointer_up_y-event.getY());
                if(Math.abs(dx)>minimum_distance)
                {
                        Log.v("TRIGGER","TRIGGER");
                    swipeMode.onSwipe();

                }
                view.setPressed(false);
                break;
        }

        return true;
    }

    public interface OnSwipeMode
    {
        void onSwipe();
    }

    @Override
        public void onDetach() {
        super.onDetach();
        swipeMode=null;
    }
}
