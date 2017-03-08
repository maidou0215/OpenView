package com.nov.openview.ui.Collection;

import android.view.View;

import com.chad.library.adapter.base.BaseViewHolder;
import com.nov.openview.R;
import com.nov.openview.base.BaseRecycleViewAdapter;
import com.nov.openview.bean.CollectionDetailsBean;

import java.util.List;

/**
 * Created by yangzhicong on 2017/2/16.
 */

public class CollectionListAdapter extends BaseRecycleViewAdapter<CollectionDetailsBean, BaseViewHolder> {

    public CollectionListAdapter(List<CollectionDetailsBean> date) {
        super(R.layout.item_collection_list, date);
    }

    @Override
    protected void convert(BaseViewHolder helper, CollectionDetailsBean item) {
        helper.setText(R.id.tv_collections_name, item.getName())
                .setText(R.id.tv_collections_count, item.getCount());



        helper.getView(R.id.ll_moban).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
