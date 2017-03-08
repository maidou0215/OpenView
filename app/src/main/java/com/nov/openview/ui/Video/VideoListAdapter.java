package com.nov.openview.ui.Video;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.nov.openview.R;
import com.nov.openview.base.BaseRecycleViewAdapter;
import com.nov.openview.bean.VideoListBean;

import java.util.List;

/**
 * Created by yangzhicong on 2017/2/17.
 */

public class VideoListAdapter extends BaseRecycleViewAdapter<VideoListBean.IssueListBean.ItemListBean, BaseViewHolder> {

    public VideoListAdapter(List date) {
        super(R.layout.item_vedio_list, date);
        openLoadAnimation(BaseQuickAdapter.ALPHAIN);
    }

    @Override
    protected void convert(BaseViewHolder helper, final VideoListBean.IssueListBean.ItemListBean item) {
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
        Glide.with(mContext)
                .load(item.getData().getCover().getFeed())
                .asBitmap()
                .diskCacheStrategy(DiskCacheStrategy.RESULT)
                .placeholder(android.R.color.transparent)
                .into((ImageView) helper.getView(R.id.iv_video));
        helper.getView(R.id.ll_moban).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString(VideoDetailsActivity.BUNDLE_TITLE, item.getData().getTitle());
                bundle.putString(VideoDetailsActivity.BUNDLE_TIME, "#" + stringTime);
                bundle.putString(VideoDetailsActivity.BUNDLE_DESC, item.getData().getDescription());//视频描述
                bundle.putString(VideoDetailsActivity.BUNDLE_BLURRED, item.getData().getCover().getBlurred());//模糊图片地址
                bundle.putString(VideoDetailsActivity.BUNDLE_FEED, item.getData().getCover().getFeed());//图片地址
                bundle.putString(VideoDetailsActivity.BUNDLE_VIDEO, item.getData().getPlayUrl());//视频播放地址
                VideoDetailsActivity.start(mContext, bundle);
            }
        });
    }
}
