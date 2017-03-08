package com.nov.openview.ui.Movie;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.nov.openview.R;
import com.nov.openview.base.BaseActivity;
import com.nov.openview.bean.MovieDetailsBean;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by yangzhicong on 2017/2/17.
 */

public class MovieDetailsActivity extends BaseActivity<MovieDetailsPresenter, MovieDetailsModel> implements MovieDetailsContract.View {

    @BindView(R.id.iv_movie_poster)
    ImageView mIvMoviePoster;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout mCollapsingToolbar;
    @BindView(R.id.appbar)
    AppBarLayout mAppbar;
    @BindView(R.id.tv_movie_name)
    TextView mTvMovieName;
    @BindView(R.id.tv_movie_year)
    TextView mTvMovieYear;
    @BindView(R.id.tv_movie_rating)
    TextView mTvMovieRating;
    @BindView(R.id.tv_movie_description)
    TextView mTvMovieDescription;
    @BindView(R.id.trailers_label)
    TextView mTrailersLabel;
    @BindView(R.id.trailers)
    LinearLayout mTrailers;
    @BindView(R.id.trailers_container)
    HorizontalScrollView mTrailersContainer;
    @BindView(R.id.reviews_label)
    TextView mReviewsLabel;
    @BindView(R.id.reviews)
    LinearLayout mReviews;
    @BindView(R.id.scrolling_container)
    NestedScrollView mScrollingContainer;
    @BindView(R.id.main_content)
    CoordinatorLayout mMainContent;

    private static final String MOVIE_TITLE = "movie_title";
    private static final String MOVIE_ID = "movie_id";
    private String mTitle;
    private String mId;

    public static void start(Context context, String title, String id) {
        Intent intent = new Intent();
        intent.putExtra(MOVIE_ID, id);
        intent.putExtra(MOVIE_TITLE, title);
        intent.setClass(context, MovieDetailsActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_movie_details;
    }

    @Override
    protected void initView() {
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        initProgressDialog("正在加载...");
        Intent it = getIntent();
        mTitle = it.getStringExtra(MOVIE_TITLE);
        mId = it.getStringExtra(MOVIE_ID);
        mPresenter.loadMovieDetailsDataRequest();
    }

    @Override
    protected void setListeners() {

    }

    @Override
    protected void setToolBar() {
        mCollapsingToolbar.setTitle(" ");
        mCollapsingToolbar.setCollapsedTitleTextAppearance(R.style.CollapsedToolbar);
        mCollapsingToolbar.setExpandedTitleTextAppearance(R.style.ExpandedToolbar);
        mCollapsingToolbar.setTitleEnabled(true);

        if (mToolbar != null)
        {
            setSupportActionBar(mToolbar);

            ActionBar actionBar = getSupportActionBar();
            if (actionBar != null)
            {
                actionBar.setDisplayHomeAsUpEnabled(true);
            }
        } else
        {
            // Don't inflate. Tablet is in landscape mode.
        }
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    public void finish() {
        super.finish();
    }

    @Override
    public String getId() {
        return mId;
    }

    @Override
    public void returnMovieDetailsData(MovieDetailsBean movieDetailsBean) {
        Glide.with(mContext)
                .load(movieDetailsBean.getImages().getLarge())
                .asBitmap()
                .diskCacheStrategy(DiskCacheStrategy.RESULT)
                .placeholder(android.R.color.transparent)
                .into(mIvMoviePoster);
        mCollapsingToolbar.setTitle(movieDetailsBean.getTitle());
        mTvMovieName.setText(movieDetailsBean.getTitle());
        mTvMovieYear.setText("上映年份：" + movieDetailsBean.getYear());
        mTvMovieRating.setText("豆瓣评分：" + String.valueOf(movieDetailsBean.getRating().getAverage()) + "/10");
        mTvMovieDescription.setText(movieDetailsBean.getSummary());
        setTrailers(movieDetailsBean.getCasts(), movieDetailsBean.getDirectors());
    }

    private void setTrailers(List<MovieDetailsBean.CastsBean> casts, List<MovieDetailsBean.DirectorsBean> directors) {
        if (casts.isEmpty()) {
            mTrailersLabel.setVisibility(View.GONE);
            mTrailers.setVisibility(View.GONE);
            mTrailersContainer.setVisibility(View.GONE);
        } else {
            mTrailers.removeAllViews();
            LayoutInflater inflater = getLayoutInflater();
            Picasso picasso = Picasso.with(mContext);

            for (MovieDetailsBean.DirectorsBean item : directors) {
                View thumbContainer = inflater.inflate(R.layout.item_movie_cast, mTrailers, false);
                ImageView thumbView = ButterKnife.findById(thumbContainer, R.id.iv_cast_pic);
                TextView castName = ButterKnife.findById(thumbContainer, R.id.tv_cast_name);
                thumbView.setTag(item.getAvatars().getMedium());
                thumbView.requestLayout();
                picasso
                        .load(item.getAvatars().getMedium())
                        .resizeDimen(R.dimen.video_width, R.dimen.video_height)
                        .centerCrop()
                        .placeholder(R.color.colorPrimary)
                        .into(thumbView);
                castName.setText("(导演)" + item.getName());
                mTrailers.addView(thumbContainer);
            }

            for (MovieDetailsBean.CastsBean item : casts) {
                View thumbContainer = inflater.inflate(R.layout.item_movie_cast, mTrailers, false);
                ImageView thumbView = ButterKnife.findById(thumbContainer, R.id.iv_cast_pic);
                TextView castName = ButterKnife.findById(thumbContainer, R.id.tv_cast_name);
                thumbView.setTag(item.getAvatars().getMedium());
                thumbView.requestLayout();
                picasso
                        .load(item.getAvatars().getMedium())
                        .resizeDimen(R.dimen.video_width, R.dimen.video_height)
                        .centerCrop()
                        .placeholder(R.color.colorPrimary)
                        .into(thumbView);
                castName.setText(item.getName());
                mTrailers.addView(thumbContainer);
            }
        }
    }

    @Override
    public void showLoading(String title) {
        progressDialog.show();
    }

    @Override
    public void stopLoading() {
        progressDialog.cancel();
    }

    @Override
    public void showErrorTip(String msg) {
        toast(msg);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_adore_tool_bar, menu);
        return true;
    }
}
