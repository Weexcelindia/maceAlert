package com.mace.View;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ToggleButton;

public class Tggl_Montserat_regular extends ToggleButton {

    public Tggl_Montserat_regular(Context context) {
        super(context);
        initypeface(context);
    }

    public Tggl_Montserat_regular(Context cont, AttributeSet attrs) {
        super(cont, attrs);
        initypeface(cont);
    }

    public Tggl_Montserat_regular(Context context, AttributeSet attrs, int defStyle) {
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

