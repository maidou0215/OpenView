package com.nov.openview.ui.Movie;

import com.nov.openview.api.methods.MovieHttpMethods;
import com.nov.openview.bean.MovieListBean;

import rx.Subscriber;

/**
 * Created by yangzhicong on 2017/2/20.
 */

public class MovieListModel implements MovieListContract.Model {
    @Override
    public Subscriber loadMovieListData(Subscriber<MovieListBean> subscriber, String date) {
        MovieHttpMethods.getInstance().getMovieListByType(subscriber, date);
        return subscriber;
    }
}
