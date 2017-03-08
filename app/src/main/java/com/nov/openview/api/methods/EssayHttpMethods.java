package com.nov.openview.api.methods;

import com.nov.openview.api.Api;
import com.nov.openview.base.BaseMethods;
import com.nov.openview.bean.EssayDetailBean;
import com.nov.openview.bean.EssayListBean;
import com.nov.openview.service.EssayService;

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

public class EssayHttpMethods extends BaseMethods{
    private EssayService mEssayService;
    private Retrofit mRetrofit;

    public static final EssayHttpMethods getInstance() {
        EssayHttpMethods methods = new EssayHttpMethods();
        return methods;
    }

    private EssayHttpMethods() {
        mRetrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(Api.DOUBAN_MOMENT)
                .client(getOkHttpClientBuilder())
                .build();
        mEssayService = mRetrofit.create(EssayService.class);
    }

    public void getEssayListByDate(Subscriber<EssayListBean> subscriber, String date) {
        mEssayService.getEssayListByDate(date)
                .onErrorReturn(new Func1<Throwable, EssayListBean>() {
                    @Override
                    public EssayListBean call(Throwable throwable) {
                        return null;
                    }
                })
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void getEssayContentById(Subscriber<EssayDetailBean> subscriber, String id) {
        mEssayService.getEssayContentById(id)
                .onErrorReturn(new Func1<Throwable, EssayDetailBean>() {
                    @Override
                    public EssayDetailBean call(Throwable throwable) {
                        return null;
                    }
                })
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }
}
