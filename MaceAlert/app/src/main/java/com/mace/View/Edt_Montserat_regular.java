package com.mace.View;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;


public class Edt_Montserat_regular extends EditText {


	public Edt_Montserat_regular(Context context) {
		super(context);
		initypeface(context);
	}

	public Edt_Montserat_regular(Context cont, AttributeSet attrs) {
		super(cont, attrs);
		initypeface(cont);
	}

	public Edt_Montserat_regular(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		initypeface(context);
	}

	private void initypeface(Context cont) {
		if(isInEditMode())
		{
			return;
		}
			setTypeface(TypefaceManager.obtaintTypeface(cont));
		}
	}

