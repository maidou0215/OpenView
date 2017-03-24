package com.nov.openview.ui.Essay;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;

import com.nov.openview.R;
import com.nov.openview.app.Application;
import com.nov.openview.base.BaseActivity;
import com.nov.openview.bean.CollectionDetailsBean;
import com.nov.openview.bean.EssayDetailBean;
import com.nov.openview.db.GreenDaoUtils;
import com.nov.openview.utils.EssayContentVonvert;
import com.nov.openview.utils.SystemDateUtil;

import butterknife.BindView;

import static com.nov.openview.R.mipmap.ic_adore_normal;
import static com.nov.openview.R.mipmap.ic_adore_pressed;

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

    private GreenDaoUtils mDaoUtils;
    private boolean isCollection = false;
    private static final String ID = "id";
    private static final String TITLE = "title";
    private static final String IMG_URL = "url";
    @BindView(R.id.wv_essay_details)
    WebView mWvEssayDetails;
    private String mTitle;
    private String mId;
    private String imgUrl;
//    @BindView(R.id.main_toolbar_iv_right)
//    ImageButton mMainToolbarIvRight;

    public static void start(Context context, String id, String imgUrl, String title) {
        Intent intent = new Intent();
        intent.putExtra(ID, id);
        intent.putExtra(TITLE, title);
        intent.putExtra(IMG_URL, imgUrl);
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
        Intent it = getIntent();
        mDaoUtils = Application.getDbUtils();
        mId = it.getStringExtra(ID);
        mTitle = it.getStringExtra(TITLE);
        imgUrl = it.getStringExtra(IMG_URL);
        mDaoUtils = Application.getDbUtils();
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
        book_db.setType(GreenDaoUtils.TYPE_ESSAY);
        book_db.setUrl(mId);
        book_db.setImgUrl(imgUrl);
        book_db.setTime(SystemDateUtil.getStringDate());
        boolean b = mDaoUtils.insertCollection(book_db);
        return b;

    }
}
