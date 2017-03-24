package com.nov.openview.base;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

import com.nov.openview.R;
import com.nov.openview.app.AppManager;
import com.nov.openview.rx.RxManager;
import com.nov.openview.utils.TUtil;
import com.nov.openview.utils.ToastUtil;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by yangzhicong on 16/6/27.
 */
public abstract class BaseActivity<T extends BasePresenter, E extends BaseModel> extends AppCompatActivity {

    public ProgressDialog progressDialog;
    public T mPresenter;
    public E mModel;
    public Context mContext;
    public RxManager mRxManager;
    private Unbinder mUnbinder;

    /**
     * 获得页面布局R.layout.*
     * @return
     */
    protected abstract int getContentView();

    /**
     * 初始化页面数据
     */
    protected abstract void initView();

    /**
     * 设置监听
     */
    protected abstract void setListeners();

    /**
     * 初始化标题栏
     */
    protected abstract void setToolBar();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppManager.getAppManager().addActivity(this);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(getContentView());
        mUnbinder = ButterKnife.bind(this);
        setToolBar();
        mRxManager=new RxManager();
        mContext = this;
        mPresenter = TUtil.getT(this, 0);
        mModel= TUtil.getT(this,1);
        if(mPresenter!=null){
            mPresenter.mContext=this;
        }
        initPresenter();
        initView();
        setListeners();
    }

    //简单页面无需mvp就不用管此方法即可,完美兼容各种实际场景的变通
    public abstract void initPresenter();

    public void toast(String msg){
        ToastUtil.showToast(mContext, msg);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        AppManager.getAppManager().removeActivity(this);
        mRxManager.clear();
        mUnbinder.unbind();
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }

    /**
     * 设置默认ProgressDialog
     * @param msg
     */
    public void initProgressDialog(String msg) {
        progressDialog = new ProgressDialog(this, R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage(msg);
        progressDialog.setCanceledOnTouchOutside(false);
    }
}
