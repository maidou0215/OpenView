package com.nov.openview.bean;

import java.io.Serializable;

/**
 * Created by yangzhicong on 2017/2/19.
 */

public class CollectionDetailsBean implements Serializable {

    private String name;
    private String count;

    public void setName(String name) {
        this.name = name;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public String getCount() {
        return count;
    }
}
