package com.nov.openview.app;

import android.database.sqlite.SQLiteDatabase;

import com.nov.openview.db.GreenDaoUtils;

/**
 * Created by yangzhicong on 16/6/25.
 */
public class Application extends android.app.Application {

    public static final String TAG = Application.class.getSimpleName();
    private static GreenDaoUtils mDaoUtils;
    private SQLiteDatabase db;
    private static Application context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        mDaoUtils = new GreenDaoUtils(context);
    }

    public static synchronized Application getContext() {
        return context;
    }

    public static GreenDaoUtils getDbUtils() {
        return mDaoUtils;
    }
}
