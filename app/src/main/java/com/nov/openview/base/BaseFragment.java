package com.nov.openview.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.nov.openview.rx.RxManager;
import com.nov.openview.utils.TUtil;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by yangzhicong on 16/6/27.
 */
public abstract class BaseFragment<T extends BasePresenter, E extends BaseModel> extends Fragment {

    public static String TAG = BaseFragment.class.getSimpleName();
    protected View rootView;
    public T mPresenter;
    public E mModel;
    public RxManager mRxManager;
    private Unbinder mUnbinder;

    /**
     * 获得布局Layout
     * @return
     */
    protected abstract int getFragmentLayout();

    protected abstract void initView(View view);

    protected abstract void setListener();

    protected abstract void setToolBar();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView == null)
            rootView = inflater.inflate(getFragmentLayout(), container, false);
        mRxManager = new RxManager();
        mUnbinder = ButterKnife.bind(this, rootView);
        mPresenter = TUtil.getT(this, 0);
        mModel= TUtil.getT(this,1);
        if(mPresenter!=null){
            mPresenter.mContext=this.getActivity();
        }
        setToolBar();
        initPresenter();
        initView(rootView);
        setListener();
        return rootView;
    }

    public void toast(String msg){
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
    }

    //简单页面无需mvp就不用管此方法即可,完美兼容各种实际场景的变通
    public abstract void initPresenter();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mPresenter != null)
            mPresenter.onDestroy();
        mRxManager.clear();
        mUnbinder.unbind();
    }
}
