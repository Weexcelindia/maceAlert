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
public class NumberChanger extends LinearLayout implements View.OnClickListener{

    ImageView imageView_left,imageView_right;
    TextView textView_value;
    private int value=0;
    private int increment_factor=1;
    private int min_value=0,max_value=100;

    public NumberChanger(Context context) {
        super(context);
        init();
    }

    public NumberChanger(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public NumberChanger(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs);
        init();
    }

    private void init()
    {
        if (isInEditMode())
            return;

        LayoutInflater li = (LayoutInflater)getContext().getSystemService(Service.LAYOUT_INFLATER_SERVICE);
        View view = li.inflate(R.layout.numberchanger, this, false);
        imageView_left=(ImageView)view.findViewById(R.id.imageView_left);
        imageView_right=(ImageView)view.findViewById(R.id.imageView_right);
        textView_value=(TextView)view.findViewById(R.id.textView_value);
        textView_value.setText(value+"");
        imageView_left.setOnClickListener(this);
        imageView_right.setOnClickListener(this);


        addView(view);
    }


    @Override
    public void onClick(View view) {
        if(view==imageView_left)
        {
            if((value-increment_factor)>=min_value)
            {
                value=value-increment_factor;
            }

        }else
        {
            if((value-increment_factor)>=max_value)
            {
                value=value-increment_factor;
            }

            value=value+increment_factor;
        }
        textView_value.setText(value+"");
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getIncrement_factor() {
        return increment_factor;
    }

    public void setIncrement_factor(int increment_factor) {
        this.increment_factor = increment_factor;
    }

    public int getMin_value() {
        return min_value;
    }

    public void setMin_value(int min_value) {
        this.min_value = min_value;
    }

    public int getMax_value() {
        return max_value;
    }

    public void setMax_value(int max_value) {
        this.max_value = max_value;
    }
}
