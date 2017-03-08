package com.nov.openview.utils;

import android.content.Context;
import android.text.TextUtils;

import com.bumptech.glide.Glide;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by yangzhicong on 2017/2/27.
 */

public class CustomImageView extends CircleImageView {
    public CustomImageView(Context context) {
        super(context);
    }
    //=============================================================glide method:
    public void loadImage(String imgUrl, boolean needFade, int placeholderRes) {
        if (TextUtils.isEmpty(imgUrl)) return;
        if (!(this instanceof CircleImageView)) {
            if (needFade) {
                if (placeholderRes == 0) {
                    Glide.with(getContext()).load(imgUrl).dontAnimate().crossFade().into(this);
                }
                else {
                    Glide.with(getContext())
                            .load(imgUrl)
                            .dontAnimate()
                            .crossFade()
                            .placeholder(placeholderRes)
                            .into(this);
                }
            }
            else {
                if (placeholderRes == 0) {
                    Glide.with(getContext()).load(imgUrl).dontAnimate().into(this);
                }
                else {
                    Glide.with(getContext()).load(imgUrl).placeholder(placeholderRes).dontAnimate().into
                            (this);
                }
            }
        }else {
            if (needFade) {
                if (placeholderRes == 0) {
                    Glide.with(getContext()).load(imgUrl).crossFade().dontAnimate().into(this);
                }
                else {
                    Glide.with(getContext())
                            .load(imgUrl)
                            .crossFade()
                            .dontAnimate()
                            .placeholder(placeholderRes)
                            .into(this);
                }
            }
            else {
                if (placeholderRes == 0) {
                    Glide.with(getContext()).load(imgUrl).dontAnimate().into(this);
                }
                else {
                    Glide.with(getContext()).load(imgUrl).dontAnimate().placeholder(placeholderRes).into
                            (this);
                }
            }
        }
    }

    public void loadImageNoFade(String url, int placeholder) {
        this.loadImage(url, false, placeholder);
    }

    public void loadImageNoPlaceHolder(String url, boolean fade) {
        this.loadImage(url, fade, 0);
    }

    public void loadImageDefault(String url) {
        this.loadImage(url, true, 0);
    }

    public void loadLocalImage(int res){
        Glide.with(getContext()).load(res).into(this);
    }
}
