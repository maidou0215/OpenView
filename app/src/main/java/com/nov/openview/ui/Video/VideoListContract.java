package com.nov.openview.ui.Video;

import com.nov.openview.base.BaseModel;
import com.nov.openview.base.BasePresenter;
import com.nov.openview.base.BaseView;
import com.nov.openview.bean.VideoListBean;

import rx.Subscriber;

/**
 * Created by yangzhicong on 2017/2/20.
 */

public interface VideoListContract {

    interface Model extends BaseModel {
        Subscriber loadVideoListData(Subscriber<VideoListBean> observable, String date);
    }

    interface View extends BaseView {
        String  getDate();
        void returnVideoListData(VideoListBean essayListBean);
    }

    abstract class Presenter extends BasePresenter<View, Model> {
        abstract void loadVideoListDataRequest();
    }
}
