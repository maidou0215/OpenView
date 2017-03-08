package com.nov.openview.ui.Movie;

import com.nov.openview.api.methods.MovieHttpMethods;
import com.nov.openview.bean.MovieDetailsBean;

import rx.Subscriber;

/**
 * Created by yangzhicong on 2017/2/20.
 */

public class MovieDetailsModel implements MovieDetailsContract.Model {
    @Override
    public Subscriber loadMovieDetailsData(Subscriber<MovieDetailsBean> subscriber, String date) {
        MovieHttpMethods.getInstance().getMovieDetailsById(subscriber, date);
        return subscriber;
    }
}
