package com.nov.openview.api.methods;

import com.nov.openview.api.Api;
import com.nov.openview.base.BaseMethods;
import com.nov.openview.bean.VideoListBean;
import com.nov.openview.service.VideoService;

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

public class VideoHttpMethods extends BaseMethods{
    private VideoService mVideoService;
    private Retrofit mRetrofit;

    public static final VideoHttpMethods getInstance() {
        VideoHttpMethods methods = new VideoHttpMethods();
        return methods;
    }

    private VideoHttpMethods() {
        mRetrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(Api.OPEN_EYE_URL)
                .client(getOkHttpClientBuilder())
                .build();
        mVideoService = mRetrofit.create(VideoService.class);
    }

    public void getVideoListByType(Subscriber<VideoListBean> subscriber, String type) {
        mVideoService.getVideoListByDate()
                .onErrorReturn(new Func1<Throwable, VideoListBean>() {
                    @Override
                    public VideoListBean call(Throwable throwable) {
                        return null;
                    }
                })
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

}
