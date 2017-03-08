package com.nov.openview.base;

import com.nov.openview.app.Application;
import com.nov.openview.utils.NetworkState;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by yangzhicong on 2017/2/20.
 */

public class BaseMethods {

    public static String CACHE_LOG = "cache_log";

    public static final int DEFAULT_TIMEOUT = 5;
    private OkHttpClient.Builder builder;
    //设置缓存路径
    private File httpCacheDirectory = new File(Application.getContext().getCacheDir(), "responses");
    //设置缓存 10M
    private Cache cache = new Cache(httpCacheDirectory, 20 * 1024 * 1024);

    private Interceptor interceptor = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            if (!NetworkState.networkConnected(Application.getContext())) {
                request = request.newBuilder()
                        .cacheControl(CacheControl.FORCE_CACHE)
                        .build();
            }
            Response response = chain.proceed(request);

            if (NetworkState.networkConnected(Application.getContext())) {
                String cacheControl = request.cacheControl().toString();
                response = response.newBuilder()
                        .removeHeader("Pragma")
                        .removeHeader("Cache-Control")
                        .header("Cache-Control", cacheControl)
                        .build();
            } else {
                int maxStale = 60 * 60 * 24 * 7; // 没网一周后失效
                response = response.newBuilder()
                        .removeHeader("Pragma")
                        .removeHeader("Cache-Control")
                        .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                        .build();
            }
            return response;
        }
    };

    public OkHttpClient getOkHttpClientBuilder() {
        if (builder == null) {
            builder = new OkHttpClient.Builder()
                    .addNetworkInterceptor(interceptor)
            .addInterceptor(interceptor)
            .cache(cache);
            builder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        }
        return builder.build();
    }
}
