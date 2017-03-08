package com.nov.openview.ui.Video;

import com.nov.openview.bean.VideoListBean;

import rx.Subscriber;

/**
 * Created by yangzhicong on 2017/2/20.
 */

public class VideoListPresenter extends VideoListContract.Presenter {
    @Override
    void loadVideoListDataRequest() {
        mRxManage.add(mModel.loadVideoListData(new Subscriber<VideoListBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(VideoListBean videoListBean) {
                mView.returnVideoListData(videoListBean);
                mView.refreshFinished();
            }
        }, mView.getDate()));
    }
}
