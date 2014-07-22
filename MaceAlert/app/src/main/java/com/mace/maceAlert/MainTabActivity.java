package com.mace.maceAlert;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioGroup;

import com.actionbarsherlock.view.MenuItem;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.mace.View.CenteredRadioImageButton;
import com.mace.View.SegmentedRadioGroup;
import com.mace.util.SlideFactory;


public class MainTabActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener,SlidingMenu.OnClosedListener,ControlFragments.OnSwipeMode,SlidingFragment.SlideFragmentCallBack {
    SegmentedRadioGroup radioGrp;
    CenteredRadioImageButton tab1,tab2;
    SlideFactory factory;
    SlidingMenu slidingMenu;
    SlidingFragment slidingFragment;
    ImageButton tab3;
    boolean is_frag_one_toreplace =true;  // whether fragment control is to replace now in the tabs
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control);
        factory = new SlideFactory();
        slidingMenu = factory.getMenuRight(this);
        slidingMenu.setOnClosedListener(this);
        slidingFragment= new SlidingFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.menu_frame_right, slidingFragment).commit();

        radioGrp=(SegmentedRadioGroup)findViewById(R.id.segment_parent);
        radioGrp.setOnCheckedChangeListener(this);
        tab1=(CenteredRadioImageButton)findViewById(R.id.tab1);
        tab2=(CenteredRadioImageButton)findViewById(R.id.tab2);
        tab3=(ImageButton)findViewById(R.id.tab3);

        tab3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                slidingMenu.showMenu(true);

            }
        });
        tab1.setChecked(true);

    }




    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {

        switch (checkedId) {

            case R.id.tab1:
                if(is_frag_one_toreplace) {
                    showFragControl();
                }else
                {
                    showFragChndmd();
                }
                    break;
            case R.id.tab2:
//              is_frag_one_toreplace =getSupportFragmentManager().findFragmentByTag("control").isVisible();

                Fragment frag1=getSupportFragmentManager().findFragmentByTag("events");
                if(frag1==null)
                {
                    frag1=new EventsFragment();
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.container,new EventsFragment(),"events").commit();
                break;

    }

    }


    @Override
    public void onClosed() {

    }

    @Override
    public void onBackPressed() {
        if(slidingMenu.isMenuShowing())
        {
            slidingMenu.showContent(true);
            return;
        }else if(tab1.isChecked()&&!(is_frag_one_toreplace))
        {
            showFragControl();
            is_frag_one_toreplace=true;
            return;
        }
        super.onBackPressed();
    }

    private void showFragControl() {
        Fragment frag = getSupportFragmentManager().findFragmentByTag("control");
        if (frag == null) {
            frag = new ControlFragments();
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.container, frag, "control").commit();

    }


    @Override
    public void onSwipe() {

        showFragChndmd();
        is_frag_one_toreplace=false;
    }

    private void showFragChndmd() {
        Fragment frag = getSupportFragmentManager().findFragmentByTag("changemode");
        if (frag == null) {
            frag = new ChangeModeFragment();
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.container, frag, "changemode").commit();
    }


    @Override
    public void closeSlide() {
        slidingMenu.showContent(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId()==android.R.id.home)
        {
            if(slidingMenu.isMenuShowing())
            {
                slidingMenu.showContent(true);
                return true;
            }

        }

        return super.onOptionsItemSelected(item);
    }
}
