package com.nov.openview.ui.Movie;

import com.nov.openview.bean.MovieListBean;

import rx.Subscriber;

/**
 * Created by yangzhicong on 2017/2/20.
 */

public class MovieListPresenter extends MovieListContract.Presenter {

    @Override
    void loadMovieListDataRequest() {
        mRxManage.add(mModel.loadMovieListData(new Subscriber<MovieListBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(MovieListBean movieListBean) {
                mView.returnMovieListData(movieListBean);
            }
        }, mView.getType()));
    }
}
