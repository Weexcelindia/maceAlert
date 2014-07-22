package com.mace.maceAlert;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.mace.util.Contact;

import java.util.ArrayList;

/**
 * Created by A on 7/1/14.
 */
public class SetupScreen extends SherlockActivity{
    ListView listView;
    ArrayList<String> list;
    CustomAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setupscreen);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listView=(ListView)findViewById(R.id.listView);
        list=new ArrayList<String>();
        list.add("MShomeWireless");
        list.add("MShomeWireless1");
        list.add("MShomeWireless2");
        list.add("MShomeWireless3");
        list.add("MShomeWireless4");

        adapter=new CustomAdapter();
        listView.setAdapter(adapter);
    }

    public void actionScan(View view) {


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
                rowview = getLayoutInflater().inflate(R.layout.list_item_scan_devices,viewGroup,false);
                viewHolder=new Viewholder();

                viewHolder.txt_name=(TextView) rowview.findViewById(R.id.txt_name);

                rowview.setTag(viewHolder);

            }else
            {
                viewHolder=(Viewholder)rowview.getTag();
            }
            viewHolder.txt_name.setText(list.get(i));




            return rowview;


        }

    }

    private static class Viewholder
    {
        public TextView txt_name;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getSupportMenuInflater().inflate(R.menu.setup,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (item.getItemId() == android.R.id.home) {
            finish();
            overridePendingTransition(R.anim.move_to_back, R.anim.slide_out_lright);
        }else if(item.getItemId()==R.id.cancel)
        {

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.move_to_back, R.anim.slide_out_lright);

    }

}
