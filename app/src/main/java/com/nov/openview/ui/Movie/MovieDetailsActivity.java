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
import android.view.MenuItem;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.nov.openview.R;
import com.nov.openview.app.Application;
import com.nov.openview.base.BaseActivity;
import com.nov.openview.bean.CollectionDetailsBean;
import com.nov.openview.bean.MovieDetailsBean;
import com.nov.openview.db.GreenDaoUtils;
import com.nov.openview.utils.SystemDateUtil;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.nov.openview.R.mipmap.ic_adore_normal;
import static com.nov.openview.R.mipmap.ic_adore_pressed;

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
    private boolean isCollection = false;
    private GreenDaoUtils mDaoUtils;
    private static final String MOVIE_TITLE = "movie_title";
    private static final String MOVIE_ID = "movie_id";
    private static final String MOVIE_IMG_URL = "movie_url";
    private String mTitle;
    private String mId;
    private String imgUrl;

    public static void start(Context context, String title, String id, String imgUrl) {
        Intent intent = new Intent();
        intent.putExtra(MOVIE_ID, id);
        intent.putExtra(MOVIE_TITLE, title);
        intent.putExtra(MOVIE_IMG_URL, imgUrl);
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
        mDaoUtils = Application.getDbUtils();
        mTitle = it.getStringExtra(MOVIE_TITLE);
        mId = it.getStringExtra(MOVIE_ID);
        imgUrl = it.getStringExtra(MOVIE_IMG_URL);
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
            mToolbar.inflateMenu(R.menu.menu_adore_tool_bar);
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
        imgUrl = movieDetailsBean.getImages().getLarge();
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
        if (mDaoUtils.queryCollection(mId)) {
            menu.getItem(0).setIcon(ic_adore_pressed);
            isCollection = true;
        } else {
            menu.getItem(0).setIcon(ic_adore_normal);
            isCollection = false;
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_action_collection:
                if (isCollection) {
                    item.setIcon(ic_adore_normal);
                    isCollection = false;
                    boolean b = deleteCollection();
                    if (b) {
                        showErrorTip("取消收藏");
                    } else {
                        showErrorTip("取消收藏失败");
                    }

                } else {
                    item.setIcon(ic_adore_pressed);
                    isCollection = true;
                    boolean b = saveCollection();
                    if (b) {
                        showErrorTip("收藏");
                    } else {
                        showErrorTip("收藏失败");
                    }

                }
        }
        return false;
    }

    private boolean deleteCollection() {
        boolean deleted = mDaoUtils.deleteCollection(mId);
        return deleted;
    }

    private boolean saveCollection() {
        CollectionDetailsBean book_db = new CollectionDetailsBean();
        book_db.setTitle(mTitle);
        book_db.setType(GreenDaoUtils.TYPE_MOVIE);
        book_db.setUrl(mId);
        book_db.setImgUrl(imgUrl);
        book_db.setTime(SystemDateUtil.getStringDate());
        boolean b = mDaoUtils.insertCollection(book_db);
        return b;

    }
}
