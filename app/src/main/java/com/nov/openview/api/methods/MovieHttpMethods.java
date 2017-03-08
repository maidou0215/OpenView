package com.nov.openview.api.methods;

import com.nov.openview.api.Api;
import com.nov.openview.base.BaseMethods;
import com.nov.openview.bean.MovieDetailsBean;
import com.nov.openview.bean.MovieListBean;
import com.nov.openview.service.MovieService;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by yangzhicong on 2017/2/20.
 */

public class MovieHttpMethods extends BaseMethods{
    private MovieService mMovieService;
    private Retrofit mRetrofit;

    public static final MovieHttpMethods getInstance() {
        MovieHttpMethods methods = new MovieHttpMethods();
        return methods;
    }

    private MovieHttpMethods() {
        mRetrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(Api.DOUBAN_BASE_URL)
                .client(getOkHttpClientBuilder())
                .build();
        mMovieService = mRetrofit.create(MovieService.class);
    }

    public void getMovieListByType(Subscriber<MovieListBean> subscriber, String type) {
        mMovieService.getListFilmByType(type)
                .onErrorReturn(new Func1<Throwable, MovieListBean>() {
                    @Override
                    public MovieListBean call(Throwable throwable) {
                        return null;
                    }
                })
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void getMovieDetailsById(Subscriber<MovieDetailsBean> subscriber, String id) {
        mMovieService.getFilmDetail(id)
                .onErrorReturn(new Func1<Throwable, MovieDetailsBean>() {
                    @Override
                    public MovieDetailsBean call(Throwable throwable) {
                        return null;
                    }
                })
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

}
