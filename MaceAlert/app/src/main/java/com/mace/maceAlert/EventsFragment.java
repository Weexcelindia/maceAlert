package com.mace.maceAlert;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockFragment;
import com.mace.View.LocationView;
import com.mace.util.Events;

import java.util.ArrayList;

/**
 * Created by A on 5/22/14.
 */
public class EventsFragment extends SherlockFragment implements View.OnClickListener
{

    ListView lv;
    CustomAdapter adapter;
    ArrayList<Events> list_events;
    LocationView locationView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        list_events=new ArrayList<Events>();
        list_events.add(new Events("WDS2,Low battery","Back entry sliding glass doors","11:10AM FRI 12.04.13","Zone 2,Fault","Fault"));
        list_events.add(new Events("WDS2,Low battery","Back entry sliding glass doors","11:10AM FRI 12.04.13","Zone 2,Fault","Fault"));
        list_events.add(new Events("WDS2,Low battery","Back entry sliding glass doors","11:10AM FRI 12.04.13","Zone 2,Fault","Fault"));
        list_events.add(new Events("WDS2,Low battery","Back entry sliding glass doors","11:10AM FRI 12.04.13","Zone 2,Fault","Fault"));
        list_events.add(new Events("WDS2,Low battery","Back entry sliding glass doors","11:10AM FRI 12.04.13","Zone 2,Fault","Fault"));
        list_events.add(new Events("WDS2,Low battery","Back entry sliding glass doors","11:10AM FRI 12.04.13","Zone 2,Fault","Fault"));
        list_events.add(new Events("WDS2,Low battery","Back entry sliding glass doors","11:10AM FRI 12.04.13","Zone 2,Fault","Fault"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_events, container, false);
        locationView=(LocationView)v.findViewById(R.id.locationview);
        locationView.setOnClickListener(this);
        lv=(ListView)v.findViewById(R.id.listView);
        adapter =new CustomAdapter();
        lv.setAdapter(adapter);
        return v;
    }

    @Override
    public void onClick(View view) {
        if(view==locationView)
        {
//            Intent in=new Intent(getActivity(),Location_change_Activity.class);
//            startActivity(in);
        }
    }


    private class CustomAdapter extends BaseAdapter
    {


        @Override
        public int getCount() {
            return list_events.size();
        }

        @Override
        public Object getItem(int i) {
            return list_events.get(i);
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
                rowview = getActivity().getLayoutInflater().inflate(R.layout.list_item1,viewGroup,false);
                viewHolder=new Viewholder();

                viewHolder.txt_zone=(TextView) rowview.findViewById(R.id.txt_settings);
                viewHolder.txt_time=(TextView) rowview.findViewById(R.id.txt_time);
                viewHolder.txt_action=(TextView) rowview.findViewById(R.id.txt_action);
                viewHolder.textView_door=(TextView) rowview.findViewById(R.id.textView_door);
                viewHolder.imageView=(ImageView) rowview.findViewById(R.id.imageView);

                rowview.setTag(viewHolder);

            }else
            {
                viewHolder=(Viewholder)rowview.getTag();
            }
            Events events=list_events.get(i);
            viewHolder.txt_zone.setText(events.getZone());
            viewHolder.txt_time.setText(events.getTime());
            viewHolder.txt_action.setText(events.getAction());
            viewHolder.textView_door.setText(events.getDoor());

            if(events.getAction().equals("Fault"))
            {
                viewHolder.imageView.setImageResource(R.drawable.icon_triangle);
            }else
            {
                viewHolder.imageView.setImageResource(R.drawable.icon_circule);
            }


            return rowview;


        }

    }

    private static class Viewholder
    {
        public TextView txt_zone;
        public TextView txt_time;
        public TextView txt_action;
        public TextView textView_door;
        public ImageView imageView;
    }




}
