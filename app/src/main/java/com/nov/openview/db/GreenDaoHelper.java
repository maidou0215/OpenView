package com.nov.openview.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by ChinaLHR on 2017/1/8.
 * Email:13435500980@163.com
 */

public class GreenDaoHelper {
    private final static String dbName = "open_view_db";
    private static SQLiteDatabase db;
    private static GreenDaoHelper mInstance;
    private DaoMaster.DevOpenHelper openHelper;
    private static DaoMaster mDaoMaster;
    private static DaoSession mDaoSession;

    private GreenDaoHelper(Context context){
        openHelper = new DaoMaster.DevOpenHelper(context, dbName, null);
        db = openHelper.getWritableDatabase();
        mDaoMaster = new DaoMaster(db);
        mDaoSession = mDaoMaster.newSession();
    }

    public static GreenDaoHelper getInstance(Context context){
        if (mInstance == null) {
            synchronized (GreenDaoHelper.class) {
                if (mInstance == null) {
                    mInstance = new GreenDaoHelper(context);
                }
            }
        }
        return mInstance;
    }

    /**
     * 获取DaoSession
     * @return
     */
    public DaoSession getDaoSession() {
        return mDaoSession;
    }
    /**
     * 获取数据库
     *
     * @return
     */
    public SQLiteDatabase getDb() {
        return db;
    }

}
