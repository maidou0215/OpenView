package com.nov.openview.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * 自定义字体TextView
 * Created by xhb on 2016/2/29.
 * 自定义TextView
 */
public class CustomTextView extends android.support.v7.widget.AppCompatTextView {
    public CustomTextView(Context context) {
        super(context);
        init(context);
    }

    public CustomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public CustomTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    /**
     * 设置字体
     * @param context
     */
    private void init(Context context){
        AssetManager assets = context.getAssets();
        Typeface font = Typeface.createFromAsset(assets, "fonts/RBNo2Light_a.otf");
        setTypeface(font);
    }
}
