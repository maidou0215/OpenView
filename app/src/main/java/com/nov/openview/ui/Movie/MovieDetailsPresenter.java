package com.nov.openview.ui.Movie;

import com.nov.openview.bean.MovieDetailsBean;

import rx.Subscriber;

/**
 * Created by yangzhicong on 2017/2/20.
 */

public class MovieDetailsPresenter extends MovieDetailsContract.Presenter {

    @Override
    void loadMovieDetailsDataRequest() {
        mView.showLoading("");
        mRxManage.add(mModel.loadMovieDetailsData(new Subscriber<MovieDetailsBean>() {
            @Override
            public void onCompleted() {
                mView.stopLoading();
            }

            @Override
            public void onError(Throwable e) {
                mView.showErrorTip("发生错误");
            }

            @Override
            public void onNext(MovieDetailsBean movieDetailsBean) {
                mView.returnMovieDetailsData(movieDetailsBean);
            }
        }, mView.getId()));
    }
}
