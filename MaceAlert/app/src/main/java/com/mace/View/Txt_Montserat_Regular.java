package com.mace.View;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

    public class Txt_Montserat_Regular extends TextView {

	public Txt_Montserat_Regular(Context context) {
		super(context);
		initypeface(context);
	}

	public Txt_Montserat_Regular(Context cont, AttributeSet attrs) {
		super(cont, attrs);
		initypeface(cont);
	}

	public Txt_Montserat_Regular(Context context, AttributeSet attrs, int defStyle) {
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

