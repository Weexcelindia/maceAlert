package com.mace.View;

import android.content.Context;
import android.graphics.Typeface;

public class TypefaceManager2 {

    private static Typeface myTypeface;

    /**Returns typeface
     * @param context
     * @return
     */
    public static Typeface obtaintTypeface(Context context){
        if (myTypeface == null) {
            myTypeface =  Typeface.createFromAsset(context.getAssets(), "MontserratBold.ttf");
        }
        return myTypeface;
    }

}
