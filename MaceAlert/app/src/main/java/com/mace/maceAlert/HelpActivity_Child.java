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

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.view.MenuItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by A on 5/23/14.
 */

public class HelpActivity_Child extends SherlockActivity implements View.OnClickListener
{
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
//  HelpFragmentCallBack hlpclb;
    ImageView imageView2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        expListView = (ExpandableListView)findViewById(R.id.lvExp);
        imageView2=(ImageView)findViewById(R.id.imageView2);
        imageView2.setOnClickListener(this);
        prepareListData();
        listAdapter = new com.mace.util.ExpandableListAdapter(this, listDataHeader, listDataChild);
        expListView.setAdapter(listAdapter);
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
            finish();
            overridePendingTransition(R.anim.move_to_back, R.anim.slide_out_lright);
        }
    }

//    public interface HelpFragmentCallBack {
//        public void closeHelp();
//    }

//    @Override
//    public void onAttach(Activity activity) {
//        super.onAttach(activity);
//        hlpclb = (HelpFragmentCallBack) getSherlockActivity();
//    }
//
//    @Override
//    public void onDetach() {
//        super.onDetach();
//        hlpclb = null;
//    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.dummy,R.anim.slide_out_lright);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            overridePendingTransition(R.anim.move_to_back, R.anim.slide_out_lright);
        }
        return super.onOptionsItemSelected(item);
    }
}
