package com.nov.openview.ui.Main;

import android.os.Handler;

import com.nov.openview.R;
import com.nov.openview.base.BaseActivity;
import com.nov.openview.utils.MyRippleView;

import butterknife.BindView;

/**
 * Created by yangzhicong on 2017/1/22.
 */

public class SplashActivity extends BaseActivity {

    @BindView(R.id.rv_demo)
    MyRippleView mRippleImageView;

    @Override
    protected int getContentView() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initView() {
        mRippleImageView.startAnimation();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                MainActivity.start(SplashActivity.this);
                finish();
            }
        }, 2000);
    }

    @Override
    protected void onDestroy() {
        mRippleImageView.stopAnimation();
        super.onDestroy();
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
