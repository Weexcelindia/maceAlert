package com.mace.maceAlert;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.mace.util.Zone;

import java.util.ArrayList;

/**
 * Created by A on 5/27/14.
 */
public class ActivityZone extends BaseActivity implements AdapterView.OnItemClickListener{

    ListView lv;
    ArrayList<Zone> list;
    CustomAdapter adapter;
    @Override

    //  TODO billy: load the zone file from db

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zones);
        lv=(ListView)findViewById(R.id.listView);
        list=new ArrayList<Zone>();
        list.add(new Zone("Zone 1","Front entry door"));
        list.add(new Zone("Zone 1","Back entry sliding glass door"));
        list.add(new Zone("Zone 1","Back entry sliding glass door"));
        list.add(new Zone("Zone 1",""));
        list.add(new Zone("Zone 1",""));
        list.add(new Zone("Zone 1",""));
        list.add(new Zone("Zone 1","Living room area"));
        list.add(new Zone("Zone 1",""));
        list.add(new Zone("Zone 1",""));
        list.add(new Zone("Zone 1",""));
        list.add(new Zone("Zone 1","Front entry door"));
        adapter=new CustomAdapter();
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent in=new Intent(ActivityZone.this,Edit_zone_.class);
        in.putExtra("name",list.get(i).getDesc());
        startActivity(in);
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
                rowview = getLayoutInflater().inflate(R.layout.list_item_zone,viewGroup,false);
                viewHolder=new Viewholder();
                viewHolder.txt_zones =(TextView) rowview.findViewById(R.id.textView12);
                viewHolder.txt_desc=(TextView) rowview.findViewById(R.id.textView_desc);
                rowview.setTag(viewHolder);

            }else
            {
                viewHolder=(Viewholder)rowview.getTag();
            }
            viewHolder.txt_zones.setText(list.get(i).getName());
            viewHolder.txt_desc.setText(list.get(i).getDesc());
            return rowview;


        }

    }

    private static class Viewholder
    {
        public TextView txt_zones,txt_desc;
    }
}
