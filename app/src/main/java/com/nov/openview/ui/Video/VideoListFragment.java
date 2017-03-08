package com.nov.openview.ui.Video;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.nov.openview.R;
import com.nov.openview.base.BaseFragment;
import com.nov.openview.bean.VideoListBean;
import com.nov.openview.utils.PullRefreshLayout;
import com.nov.openview.utils.CustomTextView;

import butterknife.BindView;

/**
 * Created by yangzhicong on 2017/2/17.
 */

public class VideoListFragment extends BaseFragment<VideoListPresenter, VideoListModel> implements VideoListContract.View{

    public static final int LIST_COUNT = 1;
    @BindView(R.id.movies_listing)
    RecyclerView mMoviesListing;
    @BindView(R.id.main_toolbar_tv_time)
    CustomTextView mMainToolbarTvTime;
    @BindView(R.id.tv_toolbar_title)
    CustomTextView mTvToolbarTitle;
    @BindView(R.id.main_toolbar_iv_right)
    ImageButton mMainToolbarIvRight;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.layout_pull_refresh)
    PullRefreshLayout mPullRefreshLayout;
    private VideoListAdapter adapter;

    public static VideoListFragment newInstance(String string) {
        Bundle args = new Bundle();
        args.putString(TAG, string);
        VideoListFragment fragment = new VideoListFragment();
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
        mPresenter.loadVideoListDataRequest();
        mMoviesListing.setLayoutManager(layoutManager);
    }

    @Override
    protected void setListener() {
        mPullRefreshLayout.setRefreshListener(this);
    }

    @Override
    protected void setToolBar() {
        mTvToolbarTitle.setText("Video");
//        mMainToolbarIvRight.setImageResource(R.drawable.main_search_selector);
        mToolbar.setBackgroundResource(R.color.colorPrimary);
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    public String getDate() {
        return null;
    }

    @Override
    public void returnVideoListData(VideoListBean essayListBean) {
        adapter = new VideoListAdapter(essayListBean.getIssueList().get(0).getItemList());
        adapter.setEmptyViewGroup((ViewGroup) mMoviesListing.getParent());
        mMoviesListing.setAdapter(adapter);
    }

    @Override
    public void showLoading(String title) {

    }

    @Override
    public void stopLoading() {

    }

    @Override
    public void showErrorTip(String msg) {

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
                mPresenter.loadVideoListDataRequest();
            }
        }, 1000);
    }

    @Override
    public void loadMore() {
        mPullRefreshLayout.loadMoreFinished();
    }
}
