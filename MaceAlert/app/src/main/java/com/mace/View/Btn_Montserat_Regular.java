package com.mace.View;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;

public class Btn_Montserat_Regular extends Button {

	public Btn_Montserat_Regular(Context context) {
		super(context);
		initypeface(context);
	}

	public Btn_Montserat_Regular(Context cont, AttributeSet attrs) {
		super(cont, attrs);
		initypeface(cont);
	}

	public Btn_Montserat_Regular(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		initypeface(context);
	}

	private void initypeface(Context cont) {
		if (isInEditMode()) 
			return;
		
		setTypeface(TypefaceManager.obtaintTypeface(cont));
	}
}
