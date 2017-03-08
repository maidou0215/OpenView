package com.nov.openview.ui.Essay;

import com.nov.openview.api.methods.EssayHttpMethods;
import com.nov.openview.bean.EssayListBean;

import rx.Subscriber;

/**
 * Created by yangzhicong on 2017/2/20.
 */

public class EssayListModel implements EssayListContract.Model {

    @Override
    public Subscriber loadEssayListData(Subscriber<EssayListBean> subscriber, String date) {
        EssayHttpMethods.getInstance().getEssayListByDate(subscriber, date);
        return subscriber;
    }
}
