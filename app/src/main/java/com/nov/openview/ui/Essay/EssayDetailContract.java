package com.nov.openview.ui.Essay;

import android.widget.ImageView;

import com.nov.openview.base.BaseModel;
import com.nov.openview.base.BasePresenter;
import com.nov.openview.base.BaseView;
import com.nov.openview.bean.EssayDetailBean;

import rx.Subscriber;

/**
 * Created by yangzhicong on 2017/2/20.
 */

public interface EssayDetailContract {

    interface Model extends BaseModel {
        Subscriber loadEssayDetailData(Subscriber<EssayDetailBean> subscriber, String id);
    }

    interface View extends BaseView {
        String getId();

        ImageView getPosterIv();

        void returnEssayDetailData(EssayDetailBean essayDetailBean);
    }

    abstract class Presenter extends BasePresenter<View, Model> {
        abstract void loadEssayDetailDataRequest();
    }

}
