package com.nov.openview.ui.Essay;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;

import com.nov.openview.R;
import com.nov.openview.base.BaseActivity;
import com.nov.openview.bean.EssayDetailBean;
import com.nov.openview.utils.EssayContentVonvert;

import butterknife.BindView;

/**
 * Created by yangzhicong on 2017/2/17.
 */

public class EssayDetailActivity extends BaseActivity<EssayDetailPresenter, EssayDetailModel> implements EssayDetailContract.View {

    @BindView(R.id.iv_essay_poster)
    ImageView mIvEssayPoster;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout mCollapsingToolbar;

    private static final String ID = "id";
    @BindView(R.id.wv_essay_details)
    WebView mWvEssayDetails;
//    @BindView(R.id.main_toolbar_iv_right)
//    ImageButton mMainToolbarIvRight;

    public static void start(Context context, String id) {
        Intent intent = new Intent();
        intent.putExtra(ID, id);
        intent.setClass(context, EssayDetailActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_essay_details;
    }

    @Override
    protected void initView() {
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        setWebView();
        initProgressDialog("正在加载...");
        mPresenter.loadEssayDetailDataRequest();
    }

    private void setWebView() {
        mWvEssayDetails.setScrollbarFadingEnabled(true);
        //能够和js交互
        mWvEssayDetails.getSettings().setJavaScriptEnabled(true);
        //缩放,设置为不能缩放可以防止页面上出现放大和缩小的图标
        mWvEssayDetails.getSettings().setBuiltInZoomControls(false);
        //缓存
        mWvEssayDetails.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        //开启DOM storage API功能
        mWvEssayDetails.getSettings().setDomStorageEnabled(true);
        //开启application Cache功能
        mWvEssayDetails.getSettings().setAppCacheEnabled(false);
    }

    @Override
    protected void setListeners() {

    }

    @Override
    protected void setToolBar() {
//        mMainToolbarTvTime.setText("Today");
//        mMainToolbarIvRight.setImageResource(R.drawable.adore_selector);
//        mTvToolbarTitle.setText(R.string.essay_string);
        mCollapsingToolbar.setTitle("  ");
        mCollapsingToolbar.setCollapsedTitleTextAppearance(R.style.CollapsedToolbar);
        mCollapsingToolbar.setExpandedTitleColor(getResources().getColor(R.color.colorWhite));
        mCollapsingToolbar.setTitleEnabled(true);
        if (mToolbar != null) {
            setSupportActionBar(mToolbar);
            ActionBar actionBar = getSupportActionBar();
            if (actionBar != null) {
                actionBar.setDisplayHomeAsUpEnabled(true);
            }
        } else {
            // Don't inflate. Tablet is in landscape mode.
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_adore_tool_bar, menu);
        return true;
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
        return getIntent().getStringExtra(ID);
    }

    @Override
    public ImageView getPosterIv() {
        return mIvEssayPoster;
    }

    @Override
    public void returnEssayDetailData(EssayDetailBean essayDetailBean) {
        setCollapsingToolbarLayoutTitle(essayDetailBean.getTitle());
        mWvEssayDetails.loadDataWithBaseURL("x-data://base", EssayContentVonvert.convertDoubanContent(essayDetailBean, this), "text/html", "utf-8", null);
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

    private void setCollapsingToolbarLayoutTitle(String title) {
        mCollapsingToolbar.setTitle(title);
    }

}
