package com.nov.openview.bean;

import java.io.Serializable;

/**
 * Created by yangzhicong on 2017/3/27.
 */

public class VideoDataBean implements Serializable {

    private String feedUrl;
    private String title;
    private String time;
    private String blurredUrl;
    private String videoAddr;
    private String description;

    public VideoDataBean() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public VideoDataBean(String feedUrl, String title, String time, String blurredUrl, String videoAddr) {
        this.feedUrl = feedUrl;
        this.title = title;
        this.time = time;
        this.blurredUrl = blurredUrl;
        this.videoAddr = videoAddr;
    }

    public void setFeedUrl(String feedUrl) {
        this.feedUrl = feedUrl;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setBlurredUrl(String blurredUrl) {
        this.blurredUrl = blurredUrl;
    }

    public void setVideoAddr(String videoAddr) {
        this.videoAddr = videoAddr;
    }

    public String getFeedUrl() {
        return feedUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getTime() {
        return time;
    }

    public String getBlurredUrl() {
        return blurredUrl;
    }

    public String getVideoAddr() {
        return videoAddr;
    }
}
