package com.nov.openview.ui.Essay;

import com.nov.openview.api.methods.EssayHttpMethods;
import com.nov.openview.bean.EssayDetailBean;

import rx.Subscriber;

/**
 * Created by yangzhicong on 2017/2/20.
 */

public class EssayDetailModel implements EssayDetailContract.Model{

    @Override
    public Subscriber loadEssayDetailData(Subscriber<EssayDetailBean> subscriber, String id) {
        EssayHttpMethods.getInstance().getEssayContentById(subscriber, id);
        return subscriber;
    }
}
