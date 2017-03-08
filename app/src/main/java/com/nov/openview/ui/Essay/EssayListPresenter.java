package com.nov.openview.ui.Essay;

import com.nov.openview.app.AppConstant;
import com.nov.openview.bean.EssayListBean;

import rx.Subscriber;
import rx.functions.Action1;

/**
 * Created by yangzhicong on 2017/2/20.
 */

public class EssayListPresenter extends EssayListContract.Presenter {

    @Override
    public void onStart() {
        super.onStart();
        mRxManage.on(AppConstant.REQUEST_FOR_ESSAY_REFRESH, new Action1<Object>() {
            @Override
            public void call(Object o) {
                loadEssayListDataRequest();
            }
        });
    }

    @Override
    void loadEssayListDataRequest() {
        mRxManage.add(mModel.loadEssayListData(new Subscriber<EssayListBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(EssayListBean essayListBean) {
                mView.returnEssayListData(essayListBean);
            }
        }, mView.getTimeDate()));
    }
}
