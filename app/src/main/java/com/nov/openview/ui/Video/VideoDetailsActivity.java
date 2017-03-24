package com.nov.openview.ui.Video;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.nov.openview.R;
import com.nov.openview.base.BaseActivity;
import com.nov.openview.utils.CustomTextView;
import com.shuyu.gsyvideoplayer.GSYPreViewManager;
import com.shuyu.gsyvideoplayer.GSYVideoPlayer;
import com.shuyu.gsyvideoplayer.listener.LockClickListener;
import com.shuyu.gsyvideoplayer.utils.OrientationUtils;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;

import butterknife.BindView;

/**
 * Created by yangzhicong on 2017/2/17.
 */

public class VideoDetailsActivity extends BaseActivity {

    private static final String MOVIE_ID = "video_id";
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

    public static final String BUNDLE_TITLE = "bundle_title";
    public static final String BUNDLE_TIME = "bundle_time";
    /** 描述*/
    public static final String BUNDLE_DESC = "bundle_desc";
    /**模糊图片地址*/
    public static final String BUNDLE_BLURRED = "bundle_blurred";
    /**图片地址*/
    public static final String BUNDLE_FEED = "bundle_feed";
    /**播放地址*/
    public static final String BUNDLE_VIDEO = "bundle_video";

    private String feed;
    private String title;
    private String time;
    private String desc;
    private String blurred;
    private String video;
    private boolean isPause;
    private boolean isPlay;
    private ImageView imageView;
    private OrientationUtils orientationUtils;

    public static void start(Context context, Bundle bundle) {
        Intent intent = new Intent();
        intent.putExtras(bundle);
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
        feed = getIntent().getStringExtra(BUNDLE_FEED);//背景图片
        title = getIntent().getStringExtra(BUNDLE_TITLE);
        time = getIntent().getStringExtra(BUNDLE_TIME);//时间
        desc = getIntent().getStringExtra(BUNDLE_DESC);//视频详情
        blurred = getIntent().getStringExtra(BUNDLE_BLURRED);//模糊图片
        video = getIntent().getStringExtra(BUNDLE_VIDEO);//视频播放地址
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
    }

    private void playerSet() {
        orientationUtils = new OrientationUtils(this, mVideoPlay);
        mVideoPlay.setThumbImageView(imageView);
        mVideoPlay.getTitleTextView().setVisibility(View.GONE);
        mVideoPlay.getBackButton().setVisibility(View.GONE);
        mVideoPlay.setUp(video, true, null, title);
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
//        getMenuInflater().inflate(R.menu.menu_adore_tool_bar, menu);
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
    protected void onDestroy() {
        GSYVideoPlayer.releaseAllVideos();
        GSYPreViewManager.instance().releaseMediaPlayer();
        if (orientationUtils != null)
            orientationUtils.releaseListener();
        super.onDestroy();
    }
}
