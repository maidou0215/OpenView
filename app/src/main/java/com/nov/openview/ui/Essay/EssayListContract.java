package com.nov.openview.ui.Essay;

import com.nov.openview.base.BaseModel;
import com.nov.openview.base.BasePresenter;
import com.nov.openview.base.BaseView;
import com.nov.openview.bean.EssayListBean;

import rx.Subscriber;

/**
 * Created by yangzhicong on 2017/2/20.
 */

public interface EssayListContract {

    interface Model extends BaseModel {
        Subscriber loadEssayListData(Subscriber<EssayListBean> observable, String date);
    }

    interface View extends BaseView {
        String getTimeDate();
        void returnEssayListData(EssayListBean essayListBean);
    }

    abstract class Presenter extends BasePresenter<View, Model> {
        abstract void loadEssayListDataRequest();
    }
}
