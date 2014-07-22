package com.mace.View;

import android.app.Service;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mace.maceAlert.R;

/**
 * Created by A on 5/30/14.
 */

public class LocationView extends LinearLayout implements View.OnClickListener{

    ImageView imageView123;
    TextView txt_time;
    View stick;

    public boolean isState_active() {
        return state_active;
    }

    public void setState_active(boolean state_active) {
        this.state_active = state_active;
        changeColor(state_active);
    }

    private boolean state_active=false;

    public LocationView(Context context) {
        super(context);
        init();
    }

    public LocationView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public LocationView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs);
        init();
    }

    private void init()
    {
        if (isInEditMode())
            return;

        LayoutInflater li = (LayoutInflater)getContext().getSystemService(Service.LAYOUT_INFLATER_SERVICE);
        View view = li.inflate(R.layout.layout_location_bar, this, false);
        imageView123=(ImageView)view.findViewById(R.id.imageView123);
        txt_time=(TextView)view.findViewById(R.id.txt_time);
        stick=(View)view.findViewById(R.id.stick);
        imageView123.setOnClickListener(this);
        addView(view);
    }


    @Override
    public void onClick(View view) {
    }

    private void changeColor(boolean state)
    {
    if(state)
    {
        txt_time.setTextColor(getResources().getColor(R.color.blue_sky));
        stick.setBackgroundColor(getResources().getColor(R.color.blue_sky));
        imageView123.setImageLevel(1);
    }else
    {
        txt_time.setTextColor(getResources().getColor(R.color.grey_shade2));
        stick.setBackgroundColor(getResources().getColor(R.color.grey_shade2));
        imageView123.setImageLevel(0);

    }
    }

    public void getText()
    {
        txt_time.getText();
    }
    public void setText(String loc)
    {
        txt_time.setText(loc+"");
    }
}
