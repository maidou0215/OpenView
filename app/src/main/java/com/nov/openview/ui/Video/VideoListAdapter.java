package com.nov.openview.ui.Video;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.nov.openview.R;
import com.nov.openview.bean.VideoDataBean;
import com.nov.openview.bean.VideoListBean;

import java.util.List;

/**
 * Created by yangzhicong on 2017/2/17.
 */

public class VideoListAdapter extends BaseMultiItemQuickAdapter<VideoListBean.IssueListBean.ItemListBean, BaseViewHolder> {

    private VideoDataBean mVideoDataBean;

    public VideoListAdapter(List date) {
        super(date);
        addItemType(VideoListBean.IssueListBean.ItemListBean.NORMAL_TYPE, R.layout.item_video_list);
        addItemType(VideoListBean.IssueListBean.ItemListBean.BANNER_TYPE, R.layout.item_video_text);
        addItemType(VideoListBean.IssueListBean.ItemListBean.HORIZONTAL_TYPE, R.layout.item_video_text);
        openLoadAnimation(BaseQuickAdapter.ALPHAIN);
    }

    @Override
    protected void convert(BaseViewHolder helper, final VideoListBean.IssueListBean.ItemListBean item) {
        switch (helper.getItemViewType()) {
            case VideoListBean.IssueListBean.ItemListBean.NORMAL_TYPE:
            helper.setText(R.id.tv_title, item.getData().getTitle());
            String category = item.getData().getCategory();
            category = "#" + category + "  /  ";
            int duration = item.getData().getDuration();

            int last = duration % 60;
            String stringLast;
            if (last <= 9) {
                stringLast = "0" + last;
            } else {
                stringLast = last + "";
            }

            String durationString;
            int minit = duration / 60;
            if (minit < 10) {
                durationString = "0" + minit;

            } else {
                durationString = "" + minit;

            }
            final String stringTime = durationString + "' " + stringLast + '"';
            helper.setText(R.id.tv_time ,category + stringTime);
            try {
                Glide.with(mContext)
                        .load(item.getData().getCover().getFeed())
                        .asBitmap()
                        .diskCacheStrategy(DiskCacheStrategy.RESULT)
                        .placeholder(android.R.color.transparent)
                        .into((ImageView) helper.getView(R.id.iv_video));
            } catch (Exception e) {
                e.printStackTrace();
                item.getType();
            }
            helper.getView(R.id.ll_moban).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
//                    Bundle bundle = new Bundle();
//                    bundle.putString(VideoDetailsActivity.BUNDLE_TITLE, item.getData().getTitle());
//                    bundle.putString(VideoDetailsActivity.BUNDLE_TIME, "#" + stringTime);
//                    bundle.putString(VideoDetailsActivity.BUNDLE_DESC, item.getData().getDescription());//视频描述
//                    bundle.putString(VideoDetailsActivity.BUNDLE_BLURRED, item.getData().getCover().getBlurred());//模糊图片地址
//                    bundle.putString(VideoDetailsActivity.BUNDLE_FEED, item.getData().getCover().getFeed());//图片地址
//                    bundle.putString(VideoDetailsActivity.BUNDLE_VIDEO, item.getData().getPlayUrl());//视频播放地址
                    mVideoDataBean = new VideoDataBean();
                    mVideoDataBean.setTitle(item.getData().getTitle());
                    mVideoDataBean.setBlurredUrl(item.getData().getCover().getBlurred());
                    mVideoDataBean.setFeedUrl(item.getData().getCover().getFeed());
                    mVideoDataBean.setTime("#" + stringTime);
                    mVideoDataBean.setVideoAddr(item.getData().getPlayUrl());
                    mVideoDataBean.setDescription(item.getData().getDescription());
                    VideoDetailsActivity.start(mContext, mVideoDataBean);
                }
            });
            break;
            case VideoListBean.IssueListBean.ItemListBean.BANNER_TYPE:
                helper.setText(R.id.tv_home_text, "-Weekend  special-");
//                helper.setVisible(R.id.tv_home_text, false);
                break;
            case VideoListBean.IssueListBean.ItemListBean.HORIZONTAL_TYPE:
                helper.setText(R.id.tv_home_text, "-Weekend  special-");
                helper.setVisible(R.id.tv_home_text, false);
                break;
        }
    }

    public void setEmptyViewGroup(ViewGroup viewGroup) {
        setEmptyView(R.layout.empty_view, viewGroup);
    }
}
