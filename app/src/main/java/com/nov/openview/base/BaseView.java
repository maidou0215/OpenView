package com.nov.openview.base;

/**
 * Created by yangzhicong on 2017/2/20.
 */

public interface BaseView {
    void showLoading(String title);
    void stopLoading();
    void showErrorTip(String msg);
}
