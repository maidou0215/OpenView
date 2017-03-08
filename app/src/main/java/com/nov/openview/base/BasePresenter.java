package com.nov.openview.base;

import android.content.Context;

import com.nov.openview.rx.RxManager;

/**
 * Created by yangzhicong on 2017/2/20.
 */

public abstract class BasePresenter<T, E> {
    public Context mContext;
    public E mModel;
    public T mView;
    public RxManager mRxManage = new RxManager();

    public void setVM(T v, E m) {
        this.mView = v;
        this.mModel = m;
        this.onStart();
    }
    public void onStart(){
    };
    public void onDestroy() {
        mRxManage.clear();
    }
}
