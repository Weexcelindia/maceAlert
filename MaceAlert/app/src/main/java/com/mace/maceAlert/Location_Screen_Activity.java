package com.mace.maceAlert;


import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.mace.util.EasyUtil;
import com.soundcloud.android.crop.Crop;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


/**
 * Created by IntelliJ IDEA.
 * User: billy
 * Date: 2014/6/19
 * Time: 下午 06:17
 * done weexcel should implement first screen in WS135_App UI Design (20140430) Sensor Icons.jpg
 *
 * done Weexcel, when user click on the device photo, user can choose takePhoto/chooise existing photo/ use default photo in ios version, should implement takePhoto & pinch to scale & chop funciton
 *
 */

public class Location_Screen_Activity extends SherlockFragmentActivity implements  AdapterView.OnItemClickListener,View.OnClickListener {

    ListView listView;
    ArrayList<com.mace.util.Location> list;
    CustomAdapter customAdapter;
    Uri outputFileUri;
    int imageToshowOn=-1;
    private MenuItem mProgress;
    TextView txt_header_listview;
    View add_device;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.location_screen);
        listView = (ListView) findViewById(R.id.listView);
        txt_header_listview=(TextView)findViewById(R.id.textView);
        add_device= getLayoutInflater().inflate(R.layout.adddevice, null, false);
        listView.addFooterView(add_device);
        add_device.setOnClickListener(this);
        listView.setOnItemClickListener(this);

        list = new ArrayList<com.mace.util.Location>();
        list.add(new com.mace.util.Location("Macealert", R.drawable.ic_launcher, true));

        customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);
        txt_header_listview.setText("1@intouching.com-1device");

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == EasyUtil.PICKnCAPTURE_REQUEST_CODE) {
              Uri uri=EasyUtil.getUrifromIntent(data,outputFileUri);
                Log.v("uri", uri.getPath().toString());
                new Crop(uri).output(outputFileUri).asSquare().start(Location_Screen_Activity.this);
            }else  if (requestCode == Crop.REQUEST_CROP && resultCode == RESULT_OK) {
                Log.v("uri",outputFileUri.getPath().toString());
                View v=listView.getChildAt(imageToshowOn);
                ImageView v1=(ImageView)v.findViewById(R.id.imageView);
                Picasso.with(Location_Screen_Activity.this).load(outputFileUri).noFade().into(v1);
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        if(view!=add_device)
        {
            Intent in =new Intent(Location_Screen_Activity.this,MainTabActivity.class);
            startActivity(in);
        }else
        {
        }
    }

    @Override
    public void onClick(View view) {

     if(view== add_device)
        {
            Intent in =new Intent(Location_Screen_Activity.this,Location_Register.class);
            startActivity(in);
        }
    }

    private class CustomAdapter extends BaseAdapter {
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
        public View getView(final int i, View view, ViewGroup viewGroup) {

            View rowview = view;
            Viewholder viewHolder = null;

            if (rowview == null) {
                rowview = getLayoutInflater().inflate(R.layout.list_item_location_screen, viewGroup, false);
                viewHolder = new Viewholder();
                viewHolder.textView_desc = (TextView) rowview.findViewById(R.id.textView_desc);
                viewHolder.imageView = (ImageView) rowview.findViewById(R.id.imageView);
                rowview.setTag(viewHolder);
            } else {
                viewHolder = (Viewholder) rowview.getTag();
            }
            viewHolder.textView_desc.setText(list.get(i).getDesc());
            viewHolder.imageView.setImageResource(list.get(i).getId());

            viewHolder.imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    imageToshowOn=i;
                    outputFileUri=EasyUtil.createUri("MaceAlertWs135");
                    EasyUtil.pickNcapture(Location_Screen_Activity.this,outputFileUri);

                }
            });

            return rowview;
        }

    }

    private static class Viewholder {
        public TextView textView_name, textView_desc;
        public ImageView imageView;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getSupportMenuInflater().inflate(R.menu.contacts,menu);
        this.mProgress = menu.findItem(R.id.refresh);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.refresh)
        {
            new DummyAsyncTask().execute((Void[]) null);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private class DummyAsyncTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... params) {
            SystemClock.sleep(2000);
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            Location_Screen_Activity.this.mProgress.setActionView(null);
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Location_Screen_Activity.this.mProgress.setActionView(R.layout.progress_view);
        }

    }


}
