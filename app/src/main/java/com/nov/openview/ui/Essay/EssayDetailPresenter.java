package com.nov.openview.ui.Essay;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.nov.openview.R;
import com.nov.openview.bean.EssayDetailBean;

import rx.Subscriber;

/**
 * Created by yangzhicong on 2017/2/20.
 */

public class EssayDetailPresenter extends EssayDetailContract.Presenter {
    @Override
    void loadEssayDetailDataRequest() {
        mView.showLoading("");
        mRxManage.add(mModel.loadEssayDetailData(new Subscriber<EssayDetailBean>() {
            @Override
            public void onCompleted() {
                mView.stopLoading();
            }

            @Override
            public void onError(Throwable e) {
                mView.showErrorTip("发生错误");
            }

            @Override
            public void onNext(EssayDetailBean essayDetailBean) {
                mView.returnEssayDetailData(essayDetailBean);
                if (essayDetailBean.getThumbs().size() != 0) {
                    Glide.with(mContext)
                            .load(essayDetailBean.getThumbs().get(0).getSmall().getUrl())
                            .crossFade()
                            .diskCacheStrategy(DiskCacheStrategy.RESULT)
                            .placeholder(R.color.colorGray)
                            .into(mView.getPosterIv());
                }
            }
        },mView.getId()));
    }
}
