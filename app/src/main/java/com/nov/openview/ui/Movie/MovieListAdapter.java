package com.nov.openview.ui.Movie;

import android.app.Activity;
import android.graphics.Bitmap;
import android.support.v7.graphics.Palette;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.nov.openview.R;
import com.nov.openview.base.BaseRecycleViewAdapter;
import com.nov.openview.bean.MovieListBean;

import java.util.List;

/**
 * Created by yangzhicong on 2017/2/16.
 */

public class MovieListAdapter extends BaseRecycleViewAdapter<MovieListBean.SubjectsBean, BaseViewHolder> {

    public MovieListAdapter(List<MovieListBean.SubjectsBean> date) {
        super(R.layout.item_movie_grid, date);
        openLoadAnimation(BaseQuickAdapter.ALPHAIN);
    }

    @Override
    protected void convert(final BaseViewHolder helper, final MovieListBean.SubjectsBean item) {
        helper.setText(R.id.iv_movie_name_item, item.getTitle());
        helper.getView(R.id.iv_movie_img_item).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MovieFloatingFragment.newInstance(item).show(((Activity)mContext).getFragmentManager(), "floating");
            }
        });
        Glide.with(mContext).load(item.getImages().getLarge()).asBitmap()
                .diskCacheStrategy(DiskCacheStrategy.RESULT)
                .into(new BitmapImageViewTarget((ImageView) helper.getView(R.id.iv_movie_img_item))
                {
                    @Override
                    public void onResourceReady(Bitmap bitmap, GlideAnimation anim)
                    {
                        super.onResourceReady(bitmap, anim);

                        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener()
                        {
                            @Override
                            public void onGenerated(Palette palette)
                            {
                                helper.getView(R.id.bg_view).setBackgroundColor(palette.getDarkVibrantColor(mContext
                                        .getResources().getColor(R.color.black_translucent_60)));
                            }
                        });
                    }
                });

    }

}
