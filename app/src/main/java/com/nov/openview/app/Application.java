package com.nov.openview.app;

import android.content.Context;

/**
 * Created by yangzhicong on 16/6/25.
 */
public class Application extends android.app.Application {

    public static final String TAG = Application.class.getSimpleName();

    private static Application context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
    }

    public static synchronized Context getContext() {
        return context;
    }

}
