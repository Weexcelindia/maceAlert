package com.mace.View;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RadioGroup;

import com.mace.maceAlert.R;

public class SegmentedRadioGroup extends RadioGroup {

	public SegmentedRadioGroup(Context context) {
		super(context);
	}

	public SegmentedRadioGroup(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	protected void onFinishInflate() {
		super.onFinishInflate();
		changeButtonsImages();
	}

	private void changeButtonsImages() {
		int count = super.getChildCount();
		if(isInEditMode())
		return;
//		for (int i = 0; i < count; i++) {
//			if(i==0)
//            {
//                super.getChildAt(i).setBackgroundResource(R.drawable.tab1_selector);
//            }else if(i==1)
//            {
//                super.getChildAt(i).setBackgroundResource(R.drawable.tab2_selector);
//            }else
//            {
//                super.getChildAt(i).setBackgroundResource(R.drawable.tab3_selector);
//            }
//		}

		// if(count > 1){
		// super.getChildAt(0).setBackgroundResource(R.drawable.segment_tab);
		// for(int i=1; i < count-1; i++){
		// super.getChildAt(i).setBackgroundResource(R.drawable.segment_tab);
		// }
		// super.getChildAt(count-1).setBackgroundResource(R.drawable.segment_tab);
		// }else if (count == 1){
		// super.getChildAt(0).setBackgroundResource(R.drawable.segment_tab);
		// }
	}
}