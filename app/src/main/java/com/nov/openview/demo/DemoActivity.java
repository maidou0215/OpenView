package com.nov.openview.demo;

import com.nov.openview.R;
import com.nov.openview.base.BaseActivity;

import butterknife.BindView;

/**
 * Created by yangzhicong on 2017/2/15.
 */

public class DemoActivity extends BaseActivity {
    @BindView(R.id.tv_pull_to_refresh)
    MyDotView mRippleImageViewMy;

    @Override
    protected int getContentView() {
        return R.layout.activity_demo;
    }

    @Override
    protected void initView() {
        mRippleImageViewMy.startAnimators();
    }

    @Override
    protected void setListeners() {

    }

    @Override
    protected void setToolBar() {

    }

    @Override
    public void initPresenter() {

    }

}
