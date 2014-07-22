package com.mace.maceAlert;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class Location_change_Activity extends BaseActivity implements AdapterView.OnItemClickListener{

    ListView listView;
    ArrayList<String> list;
    CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_location);
        listView=(ListView)findViewById(R.id.listView);
        list=new ArrayList<String>();
        list.add("George and Kym's Home");
        list.add("Mace office");
        adapter=new CustomAdapter();
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent in=new Intent(this,Edit_location_.class);
        in.putExtra("name",list.get(i));
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
                rowview = getLayoutInflater().inflate(R.layout.list_items_change_loc,viewGroup,false);
                viewHolder=new Viewholder();
                viewHolder.textView=(TextView)rowview.findViewById(R.id.textView12);
                rowview.setTag(viewHolder);

            }else
            {
                viewHolder=(Viewholder)rowview.getTag();
            }
            viewHolder.textView.setText(list.get(i));



            return rowview;


        }

    }

    static class Viewholder
    {
        public TextView textView;
    }

}
