package com.nov.openview.service;

import com.nov.openview.bean.EssayDetailBean;
import com.nov.openview.bean.EssayListBean;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by yangzhicong on 2017/2/20.
 */

public interface EssayService {

    /**
     * 根据日期获取豆瓣一刻的内容列表
     * @param date
     * @return
     */
    @GET("stream/date/{date}")
    Observable<EssayListBean> getEssayListByDate(@Path("date") String date);

    /**
     * 根据Id获取豆瓣一刻的内容
     * @param id
     * @return
     */
    @GET ("post/{id}")
    Observable<EssayDetailBean> getEssayContentById(@Path("id") String id);
}
