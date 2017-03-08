package com.nov.openview.ui.Video;

import com.nov.openview.api.methods.VideoHttpMethods;
import com.nov.openview.bean.VideoListBean;

import rx.Subscriber;

/**
 * Created by yangzhicong on 2017/2/20.
 */

public class VideoListModel implements VideoListContract.Model{

    @Override
    public Subscriber loadVideoListData(Subscriber<VideoListBean> observable, String date) {
        VideoHttpMethods.getInstance().getVideoListByType(observable, date);
        return observable;
    }
}
