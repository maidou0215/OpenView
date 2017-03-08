package com.nov.openview.ui.Collection;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.nov.openview.R;
import com.nov.openview.base.BaseFragment;
import com.nov.openview.bean.CollectionDetailsBean;
import com.nov.openview.utils.CustomTextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by yangzhicong on 2017/2/16.
 */

public class CollectionListFragment extends BaseFragment {

    public static String TAG = CollectionListFragment.class.getSimpleName();
    public static final int LIST_COUNT = 2;
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

    private CollectionListAdapter adapter;

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
        CollectionDetailsBean collectionDetailsBean;
//        for (int i = 0; i < 8; i++) {
//            collectionDetailsBean = new CollectionDetailsBean();
//            collectionDetailsBean.setName("Movie");
//            collectionDetailsBean.setCount(String.valueOf((int)(Math.random() * 10+1)));
//            movieList.add(collectionDetailsBean);
//        }
        mMoviesListing.setLayoutManager(layoutManager);
        adapter = new CollectionListAdapter(movieList);
        adapter.setEmptyViewGroup((ViewGroup) mMoviesListing.getParent());
        mMoviesListing.setAdapter(adapter);
    }

    @Override
    protected void setListener() {

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

}
