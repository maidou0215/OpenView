package com.nov.openview.ui.Collection;

import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.nov.openview.R;
import com.nov.openview.app.Application;
import com.nov.openview.base.BaseFragment;
import com.nov.openview.bean.CollectionDetailsBean;
import com.nov.openview.db.DbObserver;
import com.nov.openview.db.GreenDaoUtils;
import com.nov.openview.utils.CustomTextView;
import com.nov.openview.utils.PullRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by yangzhicong on 2017/2/16.
 */

public class CollectionListFragment extends BaseFragment implements DbObserver, PullRefreshLayout.OnRefreshListener {

    public static String TAG = CollectionListFragment.class.getSimpleName();
    public static final int LIST_COUNT = 1;
    @BindView(R.id.main_toolbar_tv_time)
    CustomTextView mMainToolbarTvTime;
    @BindView(R.id.tv_toolbar_title)
    CustomTextView mTvToolbarTitle;
    @BindView(R.id.main_toolbar_iv_right)
    ImageButton mMainToolbarIvRight;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.toolbarAbl)
    AppBarLayout mToolbarAbl;
    @BindView(R.id.movies_listing)
    RecyclerView mMoviesListing;
    @BindView(R.id.layout_pull_refresh)
    PullRefreshLayout mPullRefreshLayout;

    private CollectionListAdapter adapter;
    private GreenDaoUtils mDaoUtils;

    public static CollectionListFragment newInstance(String string) {
        Bundle args = new Bundle();
        args.putString(TAG, string);
        CollectionListFragment fragment = new CollectionListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_movies;
    }

    @Override
    protected void initView(View view) {
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity(), LIST_COUNT);
        //TODO 测试数据
        List<CollectionDetailsBean> movieList = new ArrayList<>();
        mDaoUtils = Application.getDbUtils();
        mDaoUtils.attach(this);
        movieList = mDaoUtils.queryAllCollection();
        mMoviesListing.setLayoutManager(layoutManager);
        adapter = new CollectionListAdapter(movieList);
        adapter.setEmptyViewGroup((ViewGroup) mMoviesListing.getParent());
        mMoviesListing.setAdapter(adapter);
    }

    @Override
    protected void setListener() {
        mPullRefreshLayout.setRefreshListener(this);
    }

    @Override
    protected void setToolBar() {
//        mMainToolbarTvTime.setText("Today");
        mTvToolbarTitle.setText("Collection");
        mMainToolbarIvRight.setImageResource(R.drawable.main_search_selector);
        mToolbar.setBackgroundResource(R.color.colorPrimary);
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mDaoUtils.detach(this);
    }

    @Override
    public void updateCollection() {
        adapter.setNewData(mDaoUtils.queryAllCollection());
        refreshFinished();
    }

    @Override
    public void refreshFinished() {
        mPullRefreshLayout.refreshFinished();
    }

    @Override
    public void loadMoreFinished() {
        mPullRefreshLayout.loadMoreFinished();
    }

    @Override
    public void refresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                updateCollection();
            }
        }, 1000);
    }

    @Override
    public void loadMore() {
        mPullRefreshLayout.loadMoreFinished();
    }
}
