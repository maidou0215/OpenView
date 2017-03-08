package com.nov.openview.ui.Movie;

import com.nov.openview.base.BaseModel;
import com.nov.openview.base.BasePresenter;
import com.nov.openview.base.BaseView;
import com.nov.openview.bean.MovieListBean;

import rx.Subscriber;

/**
 * Created by yangzhicong on 2017/2/20.
 */

public interface MovieListContract {

    interface Model extends BaseModel {
        Subscriber loadMovieListData(Subscriber<MovieListBean> observable, String date);
    }

    interface View extends BaseView {
        String getType();
        void returnMovieListData(MovieListBean essayListBean);
    }

    abstract class Presenter extends BasePresenter<View, Model> {
        abstract void loadMovieListDataRequest();
    }
}
