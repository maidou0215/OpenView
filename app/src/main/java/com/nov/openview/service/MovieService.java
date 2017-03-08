package com.nov.openview.service;


import com.nov.openview.bean.MovieDetailsBean;
import com.nov.openview.bean.MovieListBean;

import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by yangzhicong on 2017/2/20.
 */

public interface MovieService {

    /**
     * 热映中
     * @return
     */
    @Headers("Cache-Control: public, max-age=86400")
    @GET("v2/movie/{type}")
    Observable<MovieListBean> getListFilmByType(@Path("type") String type);


    /**
     * 获取top250
     * @param start
     * @param count
     * @return
     */

    @GET("v2/movie/top250")
    Observable<MovieListBean> getTop250(@Query("start")int start, @Query("count")int count);

    /**
     * 获取电影详情
     * @param id
     * @return
     */

    @GET("v2/movie/subject/{id}")
    Observable<MovieDetailsBean> getFilmDetail(@Path("id") String id);
}
