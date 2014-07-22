package com.mace.maceAlert;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by A on 5/23/14.
 */
public class HelpFragment extends SherlockFragment implements View.OnClickListener
{
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    HelpFragmentCallBack hlpclb;
    ImageView imageView2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.activity_main,container,false);
        expListView = (ExpandableListView)v.findViewById(R.id.lvExp);
        imageView2=(ImageView)v.findViewById(R.id.imageView2);
        imageView2.setOnClickListener(this);
        prepareListData();
        listAdapter = new com.mace.util.ExpandableListAdapter(getActivity(), listDataHeader, listDataChild);
        expListView.setAdapter(listAdapter);
        return v;
    }


    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();
        listDataHeader.add("Help topic 1");
        listDataHeader.add("Help topic 2");
        listDataHeader.add("Help topic 3");
        listDataHeader.add("Help topic 4");
        listDataHeader.add("Help topic 5");

        // Adding child data
        List<String> helptopic1 = new ArrayList<String>();
        helptopic1.add("A contextual menu offers actions that affect a specific item or context frame in the UI. You can provide a context menu for any view, but they are most often used for items in a ListView, GridView, or other view collections in which the user can perform direct actions on each item");

        List<String> helptopic2 = new ArrayList<String>();
        helptopic2.add("A contextual menu offers actions that affect a specific item or context frame in the UI. You can provide a context menu for any view, but they are most often used for items in a ListView, GridView, or other view collections in which the user can perform direct actions on each item");


        List<String> helptopic3 = new ArrayList<String>();
        helptopic3.add("A contextual menu offers actions that affect a specific item or context frame in the UI. You can provide a context menu for any view, but they are most often used for items in a ListView, GridView, or other view collections in which the user can perform direct actions on each item");

        List<String> helptopic4 = new ArrayList<String>();
        helptopic4.add("A contextual menu offers actions that affect a specific item or context frame in the UI. You can provide a context menu for any view, but they are most often used for items in a ListView, GridView, or other view collections in which the user can perform direct actions on each item");

        List<String> helptopic5 = new ArrayList<String>();
        helptopic5.add("A contextual menu offers actions that affect a specific item or context frame in the UI. You can provide a context menu for any view, but they are most often used for items in a ListView, GridView, or other view collections in which the user can perform direct actions on each item");

        listDataChild.put(listDataHeader.get(0), helptopic1);
        listDataChild.put(listDataHeader.get(1), helptopic2);
        listDataChild.put(listDataHeader.get(2), helptopic3);
        listDataChild.put(listDataHeader.get(3), helptopic4);
        listDataChild.put(listDataHeader.get(4), helptopic5);


    }

    @Override
    public void onClick(View view) {
        if(view==imageView2)
        {
            hlpclb.closeHelp();
        }
    }

    public interface HelpFragmentCallBack {
        public void closeHelp();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        hlpclb = (HelpFragmentCallBack) getSherlockActivity();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        hlpclb = null;
    }

}
