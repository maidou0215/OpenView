package com.nov.openview.base;

import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.nov.openview.R;

import java.util.List;

/**
 * Created by yangzhicong on 2017/2/25.
 */

public class BaseRecycleViewAdapter<T, E extends BaseViewHolder> extends BaseQuickAdapter<T, E> {

    public BaseRecycleViewAdapter(int layoutResId, List<T> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(E helper, T item) {

    }

    public void setEmptyViewGroup(ViewGroup viewGroup) {
        setEmptyView(R.layout.empty_view, viewGroup);
    }
}
