package com.nov.openview.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Unique;

/**
 * Created by yangzhicong on 2017/2/19.
 */
@Entity
public class CollectionDetailsBean {
    @Id(autoincrement = true)
    private Long id;
    @Unique
    private String url;
    private String time;
    private String type;
    private String imgUrl;
    private String title;
    @Generated(hash = 1418627003)
    public CollectionDetailsBean(Long id, String url, String time, String type,
            String imgUrl, String title) {
        this.id = id;
        this.url = url;
        this.time = time;
        this.type = type;
        this.imgUrl = imgUrl;
        this.title = title;
    }
    @Generated(hash = 230460167)
    public CollectionDetailsBean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTime() {
        return this.time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public String getType() {
        return this.type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getImgUrl() {
        return this.imgUrl;
    }
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getUrl() {
        return this.url;
    }
    public void setUrl(String url) {
        this.url = url;
    }

}
