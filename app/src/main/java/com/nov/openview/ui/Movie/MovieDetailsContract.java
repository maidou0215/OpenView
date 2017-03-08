package com.nov.openview.ui.Movie;

import com.nov.openview.base.BaseModel;
import com.nov.openview.base.BasePresenter;
import com.nov.openview.base.BaseView;
import com.nov.openview.bean.MovieDetailsBean;

import rx.Subscriber;

/**
 * Created by yangzhicong on 2017/2/20.
 */

public interface MovieDetailsContract {

    interface Model extends BaseModel {
        Subscriber loadMovieDetailsData(Subscriber<MovieDetailsBean> subscriber, String date);
    }

    interface View extends BaseView {
        String getId();
        void returnMovieDetailsData(MovieDetailsBean movieDetailsBean);
    }

    abstract class Presenter extends BasePresenter<View, Model> {
        abstract void loadMovieDetailsDataRequest();
    }
}
