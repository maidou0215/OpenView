package com.nov.openview.db;

import java.util.ArrayList;

/**
 * Created by ChinaLHR on 2017/1/9.
 * Email:13435500980@163.com
 */

public abstract class DbSubject {
    protected ArrayList<DbObserver> observers = new ArrayList<>();

    public void attach(DbObserver dbo) {
        if (dbo == null) throw new NullPointerException();
        if (!observers.contains(dbo)) {
            observers.add(dbo);
        }
    }

    public void detach(DbObserver dbo) {
        observers.remove(dbo);
    }

    public abstract void notifyUpdateCollection();
}
