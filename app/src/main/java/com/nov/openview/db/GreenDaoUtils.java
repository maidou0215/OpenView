package com.nov.openview.db;

import android.content.Context;

import com.nov.openview.bean.CollectionDetailsBean;

import java.util.Collections;
import java.util.List;

/**
 * Created by ChinaLHR on 2017/1/8.
 * Email:13435500980@163.com
 */

public class GreenDaoUtils extends DbSubject {

    public static String TYPE_MOVIE = "movie";
    public static String TYPE_ESSAY = "essay";
    public static String TYPE_VIDEO = "video";

    private GreenDaoHelper mHelper;

    public GreenDaoUtils(Context context) {
        mHelper = GreenDaoHelper.getInstance(context);
    }

    /**
     * 插入收藏
     *
     * @param collectionDetailsBean
     * @return
     */
    public boolean insertCollection(CollectionDetailsBean collectionDetailsBean) {
        long insert = mHelper.getDaoSession().getCollectionDetailsBeanDao().insert(collectionDetailsBean);
        if (insert != 0) {
            notifyUpdateCollection();
            return true;
        } else {
            return false;
        }
    }

    /**
     * 删除收藏
     *
     * @param url
     */
    public boolean deleteCollection(String url) {
        List<CollectionDetailsBean> list = mHelper.getDaoSession().getCollectionDetailsBeanDao().queryBuilder()
                .where(CollectionDetailsBeanDao.Properties.Url.eq(url))
                .build()
                .list();
        for (CollectionDetailsBean movie : list) {
            mHelper.getDaoSession().getCollectionDetailsBeanDao().delete(movie);
        }
        if (!list.isEmpty()) {
            notifyUpdateCollection();
        }
        return !list.isEmpty();
    }

    /**
     * 查询所有收藏
     *
     * @return
     */
    public List<CollectionDetailsBean> queryAllCollection() {
        List<CollectionDetailsBean> movie_dbs = mHelper.getDaoSession().getCollectionDetailsBeanDao().loadAll();
        Collections.reverse(movie_dbs);
        return movie_dbs;
    }

    /**
     * 根据Title查询收藏
     *
     * @param title
     * @return
     */
    public boolean queryCollectionbyTitle(String title) {
        List<CollectionDetailsBean> list = mHelper.getDaoSession().getCollectionDetailsBeanDao().queryBuilder()
                .where(CollectionDetailsBeanDao.Properties.Title.eq(title))
                .build()
                .list();
        return !list.isEmpty();
    }

    public boolean queryCollection(String url) {
        List<CollectionDetailsBean> list = mHelper.getDaoSession().getCollectionDetailsBeanDao().queryBuilder()
                .where(CollectionDetailsBeanDao.Properties.Url.eq(url))
                .build()
                .list();
        return !list.isEmpty();
    }

    @Override
    public void notifyUpdateCollection() {
        for (Object o : observers) {
            ((DbObserver) o).updateCollection();
        }
    }

}
