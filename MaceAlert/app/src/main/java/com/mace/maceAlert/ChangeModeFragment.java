package com.mace.maceAlert;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.actionbarsherlock.app.SherlockFragment;
import com.mace.util.Constants;

import java.util.ArrayList;

/**
 * Created by A on 5/26/14.
 */
public class ChangeModeFragment extends SherlockFragment implements AdapterView.OnItemClickListener{
    ListView listView;
    ArrayList<Mode> list;
    CustomAdapter adapter;
    SharedPreferences preferences;
    boolean state[];
    int default_checked=0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_change_mode,container,false);
        listView=(ListView)v.findViewById(R.id.listView);
        listView.setOnItemClickListener(this);
        preferences=getActivity().getSharedPreferences(Constants.PREFERENCE_NAME,Context.MODE_PRIVATE);
        default_checked=preferences.getInt(Constants.SELECTED_MODE,0);
        state=new boolean[5];
        list=new ArrayList<Mode>();
        for(int i=0;i<Mode.values().length;i++)
        {
            if(i==default_checked)
            {
                state[i]=true;
            }else
            {
                state[i]=false;
            }
            list.add(Mode.values()[i]);
        }
        adapter=new CustomAdapter();
        listView.setAdapter(adapter);
        return v;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


        Log.v("clicked","list_clicked");
       for(int j=0;j<state.length;j++)
       {
           if(i!=j)
           state[j]=false;
       }
       state[i]=true;
       adapter.changeData();
       SaveMode(i);
    }

    private void SaveMode(int i) {
        SharedPreferences.Editor edit=preferences.edit();
        edit.putInt(Constants.SELECTED_MODE, i);
        edit.commit();
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
                rowview = getActivity().getLayoutInflater().inflate(R.layout.list_item_mode,viewGroup,false);
                viewHolder=new Viewholder();

                viewHolder.txt_mode=(TextView) rowview.findViewById(R.id.textView_mode);
                viewHolder.textView_desc=(TextView)rowview.findViewById(R.id.textView_desc);
                viewHolder.img=(ImageView)rowview.findViewById(R.id.img);
                viewHolder.checkedTextView=(CheckBox)rowview.findViewById(R.id.checkedTextView);
                viewHolder.imageView_arrow=(ImageView)rowview.findViewById(R.id.imageView_arrow);
                rowview.setTag(viewHolder);

            }else
            {
                viewHolder=(Viewholder)rowview.getTag();
            }
            viewHolder.txt_mode.setText(list.get(i).getMode());
            viewHolder.textView_desc.setText(list.get(i).getDesc());
            viewHolder.img.setImageResource(list.get(i).getId());

            if(list.get(i)==Mode.ARM||list.get(i)==Mode.HOME)
            {
                viewHolder.checkedTextView.setBackgroundResource(R.drawable.list_item_selector_mode_green);
            }else if(list.get(i)==Mode.CHIME)
            {
                viewHolder.checkedTextView.setBackgroundResource(R.drawable.list_item_selector_mode_yellow);

            }else
            {
                viewHolder.checkedTextView.setBackgroundResource(R.drawable.list_item_selector_mode_red);

            }
            viewHolder.checkedTextView.setChecked(state[i]);
            if(viewHolder.checkedTextView.isChecked())
            {
                // apply chechked coloring
                viewHolder.txt_mode.setTextColor(getResources().getColor(R.color.white));
                viewHolder.textView_desc.setTextColor(Color.parseColor("#000000"));
                viewHolder.img.setImageLevel(1);
                viewHolder.imageView_arrow.setVisibility(View.VISIBLE);
            }else
            {
                viewHolder.txt_mode.setTextColor(getResources().getColor(R.color.blue_sky));
                viewHolder.textView_desc.setTextColor(getResources().getColor(R.color.grey_shade3));
                viewHolder.img.setImageLevel(0);
                viewHolder.imageView_arrow.setVisibility(View.GONE);

            }

            return rowview;


        }

        private void changeData()
        {
            notifyDataSetChanged();
        }
    }

    static class Viewholder
    {
        public TextView txt_mode,textView_desc;
        public ImageView img,imageView_arrow;
        public CheckBox checkedTextView;
    }


    public enum Mode{

        ARM("Arm","away mode",R.drawable.ic_level_icon_lock),
        HOME("Home","stay mode",R.drawable.ic_level_icon_home),
        CHIME("Chime","alert mode",R.drawable.ic_level_icon_chime),
        DISARM("Disarm","stand by mode",R.drawable.ic_level_icon_disarm),
        PANIC("Panic","instant alert mode",R.drawable.ic_level_icon_panic);

       private final String mode,desc;
        private final int id;


        Mode(String mode, String desc, int id) {
            this.mode = mode;
            this.desc = desc;
            this.id = id;
        }

        public String getMode() {
            return mode;
        }


        public String getDesc() {
            return desc;
        }


        public int getId() {
            return id;
        }

    }

}
