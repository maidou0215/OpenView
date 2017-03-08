package com.nov.openview.service;

import com.nov.openview.bean.VideoListBean;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by yangzhicong on 2017/2/20.
 */

public interface VideoService {

    /**
     * 获得视频内容
     * @return
     */
    @GET("feed?num=2&udid=26868b32e808498db32fd51fb422d00175e179df&vc=83")
    Observable<VideoListBean> getVideoListByDate();

}
