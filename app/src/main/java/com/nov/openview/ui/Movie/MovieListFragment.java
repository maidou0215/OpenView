package com.nov.openview.ui.Movie;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.PopupMenu;

import com.nov.openview.R;
import com.nov.openview.api.Api;
import com.nov.openview.base.BaseFragment;
import com.nov.openview.bean.MovieListBean;
import com.nov.openview.utils.PullRefreshLayout;
import com.nov.openview.utils.CustomTextView;

import butterknife.BindView;

/**
 * Created by yangzhicong on 2017/2/16.
 */

public class MovieListFragment extends BaseFragment<MovieListPresenter, MovieListModel> implements MovieListContract.View{

    public static String TAG = MovieListFragment.class.getSimpleName();
    public static final int LIST_COUNT = 3;

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

    private MovieListAdapter adapter;

    private String mType = Api.MOVIE_TYPE_IN_THEATERS;

    public static MovieListFragment newInstance(String string) {
        Bundle args = new Bundle();
        args.putString(TAG, string);
        MovieListFragment fragment = new MovieListFragment();
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
        mPresenter.loadMovieListDataRequest();
        mMoviesListing.setLayoutManager(layoutManager);
    }

    @Override
    protected void setListener() {
        mPullRefreshLayout.setRefreshListener(this);
        mMainToolbarTvTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popup = new PopupMenu(getActivity(), mMainToolbarTvTime);
                popup.getMenuInflater()
                        .inflate(R.menu.menu_movie_tool_bar, popup.getMenu());
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        int id = item.getItemId();
                        switch (id) {
                            case R.id.in_theaters:
                                mType = Api.MOVIE_TYPE_IN_THEATERS;
                                mMainToolbarTvTime.setText("In Theaters");
                                mPresenter.loadMovieListDataRequest();
                                break;
                            case R.id.coming_soon:
                                mType = Api.MOVIE_TYPE_COMING_SOON;
                                mMainToolbarTvTime.setText("Coming Soon");
                                mPresenter.loadMovieListDataRequest();
                                break;
                            case R.id.top_250:
                                mType = Api.MOVIE_TYPE_TOP_250;
                                mMainToolbarTvTime.setText("Top250");
                                mPresenter.loadMovieListDataRequest();
                                break;
                        }
                        return true;
                    }
                });

                popup.show(); //showing popup menu
            }
        });
    }


    @Override
    protected void setToolBar() {
        mTvToolbarTitle.setText("Movie");
        mMainToolbarTvTime.setText("In Theaters");
//        mMainToolbarIvRight.setImageResource(R.drawable.main_search_selector);
        mToolbar.setBackgroundResource(R.color.colorPrimary);
//        mToolbar.inflateMenu(R.menu.menu_movie_tool_bar);
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    public String getType() {
        return mType;
    }

    @Override
    public void returnMovieListData(MovieListBean essayListBean) {
        adapter = new MovieListAdapter(essayListBean.getSubjects());
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
               mPresenter.loadMovieListDataRequest();
            }
        }, 1000);
    }

    @Override
    public void loadMore() {
        mPullRefreshLayout.loadMoreFinished();
    }
}
