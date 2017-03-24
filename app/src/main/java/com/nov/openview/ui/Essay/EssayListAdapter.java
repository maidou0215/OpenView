package com.nov.openview.ui.Essay;

import android.view.View;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.chad.library.adapter.base.BaseViewHolder;
import com.nov.openview.R;
import com.nov.openview.base.BaseRecycleViewAdapter;
import com.nov.openview.bean.EssayListBean;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by yangzhicong on 2017/2/17.
 */

public class EssayListAdapter extends BaseRecycleViewAdapter<EssayListBean.PostsBean, BaseViewHolder> {

    public EssayListAdapter(List date) {
        super(R.layout.item_essay_list, date);
    }

    @Override
    protected void convert(BaseViewHolder helper, final EssayListBean.PostsBean item) {
        helper.setText(R.id.tv_essay_title, item.getTitle())
                .setText(R.id.tv_essay_summary, item.getAbstractX());
        if (!item.getThumbs().isEmpty()) {
            Glide.with(mContext)
                    .load(item.getThumbs().get(0).getSmall().getUrl())
                    .asBitmap()
                    .diskCacheStrategy(DiskCacheStrategy.RESULT)
                    .placeholder(android.R.color.transparent)
                    .into((CircleImageView) helper.getView(R.id.iv_essay_img));
        } else {
            helper.getView(R.id.iv_essay_img).setVisibility(View.GONE);
        }
        helper.getView(R.id.ll_moban).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "";
                if (!item.getThumbs().isEmpty()) {
                    url = item.getThumbs().get(0).getSmall().getUrl();
                }
                EssayDetailActivity.start(mContext, String.valueOf(item.getId()), url, String.valueOf(item.getTitle()));
            }
        });
    }

}
