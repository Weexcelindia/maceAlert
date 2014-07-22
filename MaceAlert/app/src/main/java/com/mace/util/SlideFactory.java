package com.mace.util;

import android.app.Activity;
import android.content.Context;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.mace.maceAlert.R;

public class SlideFactory {

	private SlidingMenu menu;
    private SlidingMenu menu1;

	public SlidingMenu getMenuRight(Context context) {
        //Done Weexcel : the cross button in side menu ,help button in side menu , back control in the navigation bar should close the slide menu
        //Done Weexcel: the image at the bottom of the help should be  "Learn all about your maceAlert wifi Systmem"
        //Done Weexcel: the help should be sliding on top the view, instead of parallel to existing view, please check ios version
        //the slide menu navigation should be below the view, please check ios version, also missing approiate shadow,shadow_right.png,shadow_left.png

        menu = new SlidingMenu(context);
		menu.setMode(SlidingMenu.RIGHT);
		menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
//		menu.setBehindOffsetRes(R.dimen.right_side_fragment_width);
        menu.setBehindWidthRes(R.dimen.right_side_fragment_width);
//		menu.setShadowDrawable(R.drawable.shadow);
		menu.setFadeDegree(0.35f);
		menu.setSelectorEnabled(true);
		menu.attachToActivity((Activity) context, SlidingMenu.SLIDING_CONTENT);
		menu.setMenu(R.layout.repalce_fragment);
		return menu;
	}

    public SlidingMenu getHelp(Context context) {

        menu1 = new SlidingMenu(context);
        menu1.setMode(SlidingMenu.RIGHT);
        menu1.setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);
//		menu1.setBehindOffsetRes(R.dimen.right_side_fragment_width);
      menu1.setBehindWidthRes(R.dimen.right_side_fragment_width);
//        menu1.setShadowDrawable(R.drawable.shadow);
        menu1.setFadeDegree(0.35f);
        menu1.setSelectorEnabled(true);
        menu1.attachToActivity((Activity) context, SlidingMenu.SLIDING_CONTENT);
        menu1.setMenu(R.layout.helpfragment);
//        menu1.setBehindScrollScale(0f);
        return menu1;
    }

}