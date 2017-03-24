package com.nov.openview.ui.Collection;

import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.nov.openview.R;
import com.nov.openview.bean.CollectionDetailsBean;
import com.nov.openview.db.GreenDaoUtils;
import com.nov.openview.ui.Essay.EssayDetailActivity;
import com.nov.openview.ui.Movie.MovieDetailsActivity;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by yangzhicong on 2017/2/16.
 */

public class CollectionListAdapter extends BaseQuickAdapter<CollectionDetailsBean, BaseViewHolder> {

    public CollectionListAdapter(List<CollectionDetailsBean> data) {
        super(R.layout.item_collection_list, data);
    }

    public void setEmptyViewGroup(ViewGroup viewGroup) {
        setEmptyView(R.layout.empty_view, viewGroup);
    }

    @Override
    protected void convert(BaseViewHolder helper, final CollectionDetailsBean item) {
        helper.getView(R.id.ll_moban).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (item.getType().equals(GreenDaoUtils.TYPE_ESSAY)) {
                    EssayDetailActivity.start(mContext, String.valueOf(item.getUrl()), String.valueOf(item.getUrl()), String.valueOf(item.getTitle()));
                } else {
                    MovieDetailsActivity.start(mContext, item.getTitle(), item.getUrl(), item.getImgUrl());
                }
            }
        });
        helper.setText(R.id.tv_collection_title, String.format("————%s————", item.getTitle()))
                .setText(R.id.tv_collection_time, "收藏时间：" + item.getTime());
        switch (item.getType()) {
            case "movie":
                helper.setText(R.id.tv_collection_type, "类型：电影");
                break;
            case "essay":
                helper.setText(R.id.tv_collection_type, "类型：文章");
                break;
            case "video":
                helper.setText(R.id.tv_collection_type, "类型：视频");
                break;
        }
        if (!item.getImgUrl().isEmpty()) {
            Glide.with(mContext)
                    .load(item.getImgUrl())
                    .asBitmap()
                    .diskCacheStrategy(DiskCacheStrategy.RESULT)
                    .placeholder(android.R.color.transparent)
                    .into((CircleImageView) helper.getView(R.id.iv_collection_img));
        } else {
            helper.getView(R.id.iv_collection_img).setVisibility(View.GONE);
        }
    }
}
