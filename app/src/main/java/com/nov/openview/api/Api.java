package com.nov.openview.api;

/**
 * Created by yangzhicong on 2017/2/20.
 */

public class Api {
    // 豆瓣一刻
    public static final String DOUBAN_MOMENT = "https://moment.douban.com/api/";
    // 根据日期查询消息列表
    // eg:https://moment.douban.com/api/stream/date/2016-08-11
    public static final String DOUBAN_MOMENT_LIST = "stream/date/";

    // 获取文章具体内容
    // eg:https://moment.douban.com/api/post/100484
    public static final String DOUBAN_ARTICLE_DETAIL = "post/";

    /**
     * 豆瓣API基地址
     */
    public static final String DOUBAN_BASE_URL = "https://api.douban.com/";
    public static final String MOVIE_TYPE_IN_THEATERS = "in_theaters";
    public static final String MOVIE_TYPE_COMING_SOON = "coming_soon";
    public static final String MOVIE_TYPE_TOP_250 = "top250";
    public static final String MOVIE_TYPE_NEW_MOVIES = "new_movies";
    public static final String OPEN_EYE_URL = "http://baobab.kaiyanapp.com/api/v2/";
}
