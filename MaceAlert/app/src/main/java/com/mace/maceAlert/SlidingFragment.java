package com.mace.maceAlert;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockFragment;

import java.util.ArrayList;

/**
 * Created by A on 5/23/14.
 */
public class SlidingFragment extends SherlockFragment implements AdapterView.OnItemClickListener, View.OnClickListener {
    ListView listView;
    ArrayList<Pojo> list_settings;
    CustomAdapter adapter;
    ImageView imageView_cancel;
    SlideFragmentCallBack sld_clbk;

    @Override

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        list_settings = new ArrayList();
        list_settings.add(new Pojo("Account", R.drawable.icon_cloud_small));
        list_settings.add(new Pojo("Locations", R.drawable.loc_marker_small));
        list_settings.add(new Pojo("Sensors", R.drawable.icon_wifi_small));
        list_settings.add(new Pojo("Zones", R.drawable.icon_zone_small));
        list_settings.add(new Pojo("Alarm setup", R.drawable.icon_speaker_small));
        list_settings.add(new Pojo("Notifications", R.drawable.icon_chat_small));
        list_settings.add(new Pojo("Accessories", R.drawable.icon_cart_small));
        list_settings.add(new Pojo("FirmWare Update", R.drawable.update_icon));

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_settings, container, false);
        listView = (ListView) v.findViewById(R.id.listView);
        imageView_cancel = (ImageView) v.findViewById(R.id.imageView_cancel);
        imageView_cancel.setOnClickListener(this);
        adapter = new CustomAdapter();
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
        return v;
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent in = null;
        switch (i) {
            case 0:
                in = new Intent(getActivity(), AccountActivity.class);
                break;
            case 2:
                in = new Intent(getActivity(), ActivitySensor.class);
                break;
            case 3:
                in = new Intent(getActivity(), ActivityZone.class);
                break;
            case 5:
                in = new Intent(getActivity(), NotificationActivity.class);
                break;
            case 4:
                in = new Intent(getActivity(), ActivityAlarm.class);
                break;
            case 1:
                in = new Intent(getActivity(), Location_change_Activity.class);
                break;
            case 7:
                in = new Intent(getActivity(), FirmwareUpdateActivity.class);
                break;
        }
        if (in != null)
            startActivity(in);
    }

    @Override
    public void onClick(View view) {
        if (view == imageView_cancel) {
            sld_clbk.closeSlide();
        }
    }

    private class CustomAdapter extends BaseAdapter {


        @Override
        public int getCount() {
            return list_settings.size();
        }

        @Override
        public Object getItem(int i) {
            return list_settings.get(i);
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
                rowview = getActivity().getLayoutInflater().inflate(R.layout.list_item_settings, viewGroup, false);
                viewHolder = new Viewholder();

                viewHolder.txt_settings = (TextView) rowview.findViewById(R.id.txt_settings);
                viewHolder.imageView = (ImageView) rowview.findViewById(R.id.imageView);

                rowview.setTag(viewHolder);

            } else {
                viewHolder = (Viewholder) rowview.getTag();
            }
            viewHolder.txt_settings.setText(list_settings.get(i).getElement_name());
            viewHolder.imageView.setImageResource(list_settings.get(i).getElement_icon());


            return rowview;


        }

    }

    private static class Viewholder {
        public TextView txt_settings;
        public ImageView imageView;
    }

    private class Pojo {
        private Pojo(String element_name, int element_icon) {
            this.element_name = element_name;
            this.element_icon = element_icon;
        }

        public String getElement_name() {
            return element_name;
        }


        public int getElement_icon() {
            return element_icon;
        }


        private String element_name;
        private int element_icon;

    }


    public interface SlideFragmentCallBack {
        public void closeSlide();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        sld_clbk = (SlideFragmentCallBack) getSherlockActivity();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        sld_clbk = null;
    }
}
