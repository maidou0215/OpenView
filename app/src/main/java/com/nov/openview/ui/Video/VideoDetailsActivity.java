package com.nov.openview.ui.Video;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.gson.Gson;
import com.nov.openview.R;
import com.nov.openview.app.Application;
import com.nov.openview.base.BaseActivity;
import com.nov.openview.bean.CollectionDetailsBean;
import com.nov.openview.bean.VideoDataBean;
import com.nov.openview.db.GreenDaoUtils;
import com.nov.openview.utils.CustomTextView;
import com.nov.openview.utils.SystemDateUtil;
import com.shuyu.gsyvideoplayer.GSYPreViewManager;
import com.shuyu.gsyvideoplayer.GSYVideoPlayer;
import com.shuyu.gsyvideoplayer.listener.LockClickListener;
import com.shuyu.gsyvideoplayer.utils.OrientationUtils;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;

import butterknife.BindView;

import static com.nov.openview.R.mipmap.ic_adore_normal;
import static com.nov.openview.R.mipmap.ic_adore_pressed;

/**
 * Created by yangzhicong on 2017/2/17.
 */

public class VideoDetailsActivity extends BaseActivity {

    @BindView(R.id.main_toolbar_tv_time)
    CustomTextView mMainToolbarTvTime;
    @BindView(R.id.tv_toolbar_title)
    CustomTextView mTvToolbarTitle;
    @BindView(R.id.main_toolbar_iv_right)
    ImageButton mMainToolbarIvRight;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.video_play)
    StandardGSYVideoPlayer mVideoPlay;
    @BindView(R.id.video_detail_ivmo)
    ImageView mVideoDetailIvmo;
    @BindView(R.id.video_detail_title)
    TextView mVideoDetailTitle;
    @BindView(R.id.video_detail_time)
    TextView mVideoDetailTime;
    @BindView(R.id.video_detail_desc)
    TextView mVideoDetailDesc;

    private boolean isCollection = false;
    private GreenDaoUtils mDaoUtils;
    public static final String DATA = "data";
    private String mId;
    private String feed;
    private String title;
    private String time;
    private String desc;
    private String blurred;
    private String video_addr;
    private boolean isPause;
    private boolean isPlay;
    private ImageView imageView;
    private OrientationUtils orientationUtils;

    public static void start(Context context, VideoDataBean dataBean) {
        Intent intent = new Intent();
        intent.putExtra(DATA, dataBean);
        intent.setClass(context, VideoDetailsActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_video_detail;
    }

    @Override
    protected void initView() {
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        VideoDataBean video = (VideoDataBean) getIntent().getSerializableExtra(DATA);
        mDaoUtils = Application.getDbUtils();
        feed = video.getFeedUrl();//背景图片
        title = video.getTitle();
        time = video.getTime();//时间
        desc = video.getDescription();//视频详情
        blurred = video.getBlurredUrl();//模糊图片
        video_addr = video.getVideoAddr();//视频播放地址
        imageView = new ImageView(mContext);
        Glide.with(mContext)
                .load(feed)
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.RESULT)
                .placeholder(android.R.color.transparent)
                .into(imageView);
        Glide.with(mContext)
                .load(blurred)
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.RESULT)
                .placeholder(android.R.color.transparent)
                .into(mVideoDetailIvmo);
        mVideoDetailTitle.setText(title);
        mVideoDetailDesc.setText(desc);
        mVideoDetailTime.setText(time);
        playerSet();
        Gson gson = new Gson();
        mId = gson.toJson(video);
    }

    private void playerSet() {
        orientationUtils = new OrientationUtils(this, mVideoPlay);
        mVideoPlay.setThumbImageView(imageView);
        mVideoPlay.getTitleTextView().setVisibility(View.GONE);
        mVideoPlay.getBackButton().setVisibility(View.GONE);
        mVideoPlay.setUp(video_addr, true, null, title);
        mVideoPlay.setNeedShowWifiTip(false);
        mVideoPlay.setIsTouchWiget(true);
        //关闭自动旋转
        mVideoPlay.setRotateViewAuto(false);
        mVideoPlay.setLockLand(false);
        mVideoPlay.setShowFullAnimation(false);
        mVideoPlay.setNeedLockFull(true);
        mVideoPlay.getFullscreenButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //直接横屏
                orientationUtils.resolveByClick();

                //第一个true是否需要隐藏actionbar，第二个true是否需要隐藏statusbar
                mVideoPlay.startWindowFullscreen(mContext, true, true);
            }
        });

        mVideoPlay.setStandardVideoAllCallBack(new SampleListener() {
            @Override
            public void onPrepared(String url, Object... objects) {
                super.onPrepared(url, objects);
                //开始播放了才能旋转和全屏
                orientationUtils.setEnable(true);
                isPlay = true;
            }

            @Override
            public void onAutoComplete(String url, Object... objects) {
                super.onAutoComplete(url, objects);
            }

            @Override
            public void onClickStartError(String url, Object... objects) {
                super.onClickStartError(url, objects);
            }

            @Override
            public void onQuitFullscreen(String url, Object... objects) {
                super.onQuitFullscreen(url, objects);
                if (orientationUtils != null) {
                    orientationUtils.backToProtVideo();
                }
            }
        });

        mVideoPlay.setLockClickListener(new LockClickListener() {
            @Override
            public void onClick(View view, boolean lock) {
                if (orientationUtils != null) {
                    //配合下方的onConfigurationChanged
                    orientationUtils.setEnable(!lock);
                }
            }
        });
    }

    @Override
    protected void setListeners() {
    }

    @Override
    protected void setToolBar() {
//        mMainToolbarIvRight.setImageResource(R.drawable.main_search_selector);
        mTvToolbarTitle.setText(R.string.Video);
        if (mToolbar != null) {
            setSupportActionBar(mToolbar);
            ActionBar actionBar = getSupportActionBar();
            actionBar.setTitle(" ");
            if (actionBar != null) {
                actionBar.setDisplayHomeAsUpEnabled(true);
            }
        } else {
            // Don't inflate. Tablet is in landscape mode.
        }
    }

    @Override
    public void initPresenter() {

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
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        //如果旋转了就全屏
        if (isPlay && !isPause) {
            if (newConfig.orientation == ActivityInfo.SCREEN_ORIENTATION_USER) {
                if (!mVideoPlay.isIfCurrentIsFullscreen()) {
                    mVideoPlay.startWindowFullscreen(mContext, true, true);
                }
            } else {
                //新版本isIfCurrentIsFullscreen的标志位内部提前设置了，所以不会和手动点击冲突
                if (mVideoPlay.isIfCurrentIsFullscreen()) {
                    StandardGSYVideoPlayer.backFromWindowFull(this);
                }
                if (orientationUtils != null) {
                    orientationUtils.setEnable(true);
                }
            }
        }
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
                        showTip("取消收藏");
                    } else {
                        showTip("取消收藏失败");
                    }

                } else {
                    item.setIcon(ic_adore_pressed);
                    isCollection = true;
                    boolean b = saveCollection();
                    if (b) {
                        showTip("收藏");
                    } else {
                        showTip("收藏失败");
                    }

                }
        }
        return false;
    }

    private void showTip(String string) {
        toast(string);
    }


    @Override
    protected void onDestroy() {
        GSYVideoPlayer.releaseAllVideos();
        GSYPreViewManager.instance().releaseMediaPlayer();
        if (orientationUtils != null)
            orientationUtils.releaseListener();
        super.onDestroy();
    }

    private boolean deleteCollection() {
        boolean deleted = mDaoUtils.deleteCollection(mId);
        return deleted;
    }

    private boolean saveCollection() {
        CollectionDetailsBean book_db = new CollectionDetailsBean();
        book_db.setTitle(title);
        book_db.setType(GreenDaoUtils.TYPE_VIDEO);
        book_db.setUrl(mId);
        book_db.setImgUrl(feed);
        book_db.setTime(SystemDateUtil.getStringDate());
        boolean b = mDaoUtils.insertCollection(book_db);
        return b;

    }
}
