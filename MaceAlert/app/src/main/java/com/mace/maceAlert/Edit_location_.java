package com.mace.maceAlert;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.mace.View.SaveBarView;
import com.mace.util.Zone;

import java.util.ArrayList;


public class Edit_location_ extends BaseActivity implements View.OnClickListener,SaveBarView.QuickactionListener {
    EditText edt_loc_name;
    ImageView img_eye;
    EditText edt_panelnew,edt_panelold;
    Button btn_timezone;
    ArrayList<TimeZoneReference.Zones> list;
    int pos=0;
    Dialog dg;
    SaveBarView save_bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_location_);
        edt_loc_name=(EditText)findViewById(R.id.edt_zone_sensor);
        if(getIntent().getExtras().getString("name")!=null)
        edt_loc_name.setText(getIntent().getExtras().getString("name"));
        img_eye=(ImageView)findViewById(R.id.img_eye);
        img_eye.setImageLevel(0);   // default
        img_eye.setOnClickListener(this);
        edt_panelold=(EditText)findViewById(R.id.edt_panelold);
        edt_panelnew=(EditText)findViewById(R.id.edt_panelnew);
        btn_timezone=(Button)findViewById(R.id.btn_timezone);
        save_bar=(SaveBarView)findViewById(R.id.save_bar);
        save_bar.setQuickactionListener(this);
        btn_timezone.setOnClickListener(this);
        edt_panelnew.setInputType(InputType.TYPE_NUMBER_VARIATION_PASSWORD|InputType.TYPE_CLASS_NUMBER);  //default
        edt_panelold.setInputType(InputType.TYPE_NUMBER_VARIATION_PASSWORD|InputType.TYPE_CLASS_NUMBER);  //default
        list=new TimeZoneReference().getList_zones();

    }


    @Override
    public void onClick(View view) {
    if(view==img_eye)
    {
        toggle_eye();
    }else if(view==btn_timezone)
    {
    showDialog(0);

    }

    }


    private void toggle_eye() {
        if(img_eye.getDrawable().getLevel()==0)
        {
            img_eye.setImageLevel(1);
            edt_panelold.setInputType(InputType.TYPE_CLASS_NUMBER|InputType.TYPE_NUMBER_VARIATION_NORMAL);
            edt_panelold.setSelection(edt_panelold.length());
            edt_panelnew.setInputType(InputType.TYPE_CLASS_NUMBER|InputType.TYPE_NUMBER_VARIATION_NORMAL);
            edt_panelnew.setSelection(edt_panelnew.length());
        }else
        {
            img_eye.setImageLevel(0);
            edt_panelold.setInputType(InputType.TYPE_NUMBER_VARIATION_PASSWORD|InputType.TYPE_CLASS_NUMBER);
            edt_panelold.setSelection(edt_panelold.length());
            edt_panelnew.setInputType(InputType.TYPE_NUMBER_VARIATION_PASSWORD|InputType.TYPE_CLASS_NUMBER);
            edt_panelnew.setSelection(edt_panelnew.length());
        }
    }




    @Override
    public Dialog onCreateDialog(int id) {

        final AlertDialog.Builder builder = new AlertDialog.Builder(Edit_location_.this);

        LayoutInflater inflater = getLayoutInflater();

        if(id==0)  // time zone dialog
        {
            View v=inflater.inflate(R.layout.dialog_timezone, null);
            final ListView lv=(ListView)v.findViewById(R.id.listView);

            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                pos=i;
                }
            });
            Button button=(Button)v.findViewById(R.id.button);

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if(pos<0)
                    {
                        pos=0;
                    }
                    btn_timezone.setText(list.get(pos).getCountryname());
                    dg.dismiss();
                }
            });
            lv.setAdapter(new CustomAdapter());
            builder.setView(v);

        }
        dg= builder.create();
        dg.show();
        return super.onCreateDialog(id);
    }

    @Override
    public void onActionCancel(View v) {

    }

    @Override
    public void onActionSave(View v) {

    }

    @Override
    public void onActionBin(View v) {

    }


    private class CustomAdapter extends BaseAdapter
    {

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int i) {
            return list.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            View rowview = view;
            Viewholder viewHolder = null;

            if (rowview == null) {
                rowview = getLayoutInflater().inflate(R.layout.list_item_timezone,viewGroup,false);
                viewHolder=new Viewholder();
                viewHolder.textView=(TextView)rowview.findViewById(R.id.textView12);
                rowview.setTag(viewHolder);
            }else
            {
                viewHolder=(Viewholder)rowview.getTag();
            }
            viewHolder.textView.setText(list.get(i).getCountryname());
            return rowview;

        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    static class Viewholder
    {
        public TextView textView;
    }
}
