package com.nov.openview.demo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.nov.openview.R;

/**
 * http://blog.csdn.net/u013647382/article/details/58092102#参考文章
 * Created by yangzhicong on 2017/3/7.
 */

public class PullRefreshLayout extends ViewGroup {

    private int lastChildIndex;
    private View mHeader;
    private View mFooter;
    private TextView mHeaderText;
    private TextView mFooterText;
    private ProgressBar mFooterProgressBar;
    private ProgressBar mHeaderProgressBar;
    private int mLayoutContentHeight;
    private int mEffectiveHeaderHeight;
    private Status mStatus;
    private int mLastMoveY;
    private int mLastMoveYIntercept;
    private int mEffictiveFooterHeight;

    public PullRefreshLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PullRefreshLayout(Context context) {
        super(context);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        mLayoutContentHeight = 0;

        for (int j = 0; j < getChildCount(); j++) {
            View child = getChildAt(j);
            if (child == mHeader) {
                child.layout(0, 0 - child.getMeasuredHeight(), child.getMeasuredWidth(), 0);
            } else if (child == mFooter) {
                child.layout(0, mLayoutContentHeight, child.getMeasuredWidth(), 0);
                mEffectiveHeaderHeight = child.getHeight();
            } else {
                child.layout(0, mLayoutContentHeight, child.getMeasuredWidth(), mLayoutContentHeight+child.getMeasuredHeight());
                if (j < getChildCount()) {
                    if (child instanceof ScrollView) {
                        mLayoutContentHeight += getMeasuredHeight();
                        continue;
                    }
                    mLayoutContentHeight += child.getMeasuredHeight();
                }
            }
        }
    }

    /**
     * 当所有child从xml中初始化后调用
     */
    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        lastChildIndex = getChildCount() - 1;

        addHeader();
        addFooter();
    }

    private void addHeader() {
        mHeader = LayoutInflater.from(getContext()).inflate(R.layout.header, null);
        mHeader = LayoutInflater.from(getContext()).inflate(R.layout.pull_header, null, false);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        addView(mHeader, params);

        mHeaderText = (TextView) findViewById(R.id.header_text);
        mHeaderProgressBar = (ProgressBar) findViewById(R.id.header_progressbar);
    }

    private void addFooter() {
        mFooter = LayoutInflater.from(getContext()).inflate(R.layout.pull_footer, null, false);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        addView(mFooter, params);
        mFooterText = (TextView) findViewById(R.id.footer_text);
        mFooterProgressBar = (ProgressBar) findViewById(R.id.footer_progressbar);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        for (int i = 0; i < getChildCount(); i++) {
            View child = getChildAt(i);
            measureChild(child, widthMeasureSpec, heightMeasureSpec);
        }
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        boolean intercept = false;
        int y = (int) ev.getY();
        if (mStatus == Status.REFRESHING || mStatus == Status.LOADING) {
            return false;
        }

        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mLastMoveY = y;
                intercept = true;
                break;
            case MotionEvent.ACTION_MOVE:
                if (y > mLastMoveYIntercept) {
                    View child = getChildAt(0);
                    intercept = getRefreshIntercept(child);

                    if (intercept) {
                        updateStatus(mStatus.PULL_TO_REFRESH);
                    }
                } else if (y < mLastMoveYIntercept) {
                    View child = getChildAt(lastChildIndex);
                    intercept = getLoadMoreIntercept(child);
                    if (intercept) {
                        updateStatus(mStatus.LOADING_MORE);
                    }
                } else {
                    intercept = false;
                }
                break;
            case MotionEvent.ACTION_UP:
                intercept = false;
                break;
        }
        mLastMoveYIntercept = y;
        return intercept;
    }

    private boolean getLoadMoreIntercept(View child) {
        boolean intercept = false;

        if (child instanceof AdapterView) {
            intercept = adapterViewLoadMoreIntercept(child);
        } else if (child instanceof ScrollView) {
            intercept = scrollViewLoadMoreIntercept(child);
        } else if (child instanceof RecyclerView) {
            intercept = recyclerViewLoadMoreIntercept(child);
        }
        return intercept;
    }

    private void updateStatus(Status pullToRefresh) {

    }

    private boolean getRefreshIntercept(View child) {
        boolean intercept = false;
        if (child instanceof AdapterView) {
            intercept = adapterViewRefreshIntercept(child);
        } else if (child instanceof ScrollView) {
            intercept = scrollViewRefreshIntercept(child);
        } else if (child instanceof RecyclerView) {
            intercept = recyclerViewRefreshIntercept(child);
        }
        return intercept;
    }

     /*汇总判断 刷新和加载是否拦截*/

    /*具体判断各种View是否应该拦截*/
    // 判断AdapterView下拉刷新是否拦截
    private boolean adapterViewRefreshIntercept(View child) {
        boolean intercept = true;
        AdapterView adapterChild = (AdapterView) child;
        if (adapterChild.getFirstVisiblePosition() != 0
                || adapterChild.getChildAt(0).getTop() != 0) {
            intercept = false;
        }
        return intercept;
    }

    // 判断AdapterView加载更多是否拦截
    private boolean adapterViewLoadMoreIntercept(View child) {
        boolean intercept = false;
        AdapterView adapterChild = (AdapterView) child;
        if (adapterChild.getLastVisiblePosition() == adapterChild.getCount() - 1 &&
                (adapterChild.getChildAt(adapterChild.getChildCount() - 1).getBottom() >= getMeasuredHeight())) {
            intercept = true;
        }
        return intercept;
    }

    // 判断ScrollView刷新是否拦截
    private boolean scrollViewRefreshIntercept(View child) {
        boolean intercept = false;
        if (child.getScrollY() <= 0) {
            intercept = true;
        }
        return intercept;
    }

    // 判断ScrollView加载更多是否拦截
    private boolean scrollViewLoadMoreIntercept(View child) {
        boolean intercept = false;
        ScrollView scrollView = (ScrollView) child;
        View scrollChild = scrollView.getChildAt(0);

        if (scrollView.getScrollY() >= (scrollChild.getHeight() - scrollView.getHeight())) {
            intercept = true;
        }
        return intercept;
    }

    // 判断RecyclerView刷新是否拦截
    private boolean recyclerViewRefreshIntercept(View child) {
        boolean intercept = false;

        RecyclerView recyclerView = (RecyclerView) child;
        if (recyclerView.computeVerticalScrollOffset() <= 0) {
            intercept = true;
        }
        return intercept;
    }

    // 判断RecyclerView加载更多是否拦截
    private boolean recyclerViewLoadMoreIntercept(View child) {
        boolean intercept = false;

        RecyclerView recyclerView = (RecyclerView) child;
        if (recyclerView.computeVerticalScrollExtent() + recyclerView.computeVerticalScrollOffset()
                >= recyclerView.computeVerticalScrollRange()) {
            intercept = true;
        }

        return intercept;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int y = (int) event.getY();

        if (mStatus == Status.REFRESHING || mStatus == Status.LOADING) {
            return true;
        }

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mLastMoveY = y;
                break;

            case MotionEvent.ACTION_MOVE:
                int dy = mLastMoveY - y;//向下滑动了多少距离

                if (getScaleY() <= 0 && dy <= 0) {
                    //TODO scrollBy ?
                    if (mStatus == Status.LOADING_MORE) {
                        scrollBy(0, dy / 100);
                    } else {
                        scrollBy(0, dy / 3);
                    }
                } else if (getScrollY() >= 0 && dy >= 0) {
                    if (mStatus == Status.PULL_TO_REFRESH) {
                        scrollBy(0, dy / 100);
                    } else {
                        scrollBy(0, dy / 3);
                    }
                } else {
                    scrollBy(0, dy / 3);
                }
                beforeRefreshing();
                beforeLoadMore();
            case MotionEvent.ACTION_UP:
                // 下拉刷新，并且到达有效长度
                if (getScrollY() <= -mEffectiveHeaderHeight) {
                    releaseWithStatusRefresh();
                    if (mRefreshListener != null) {
                        mRefreshListener.refreshFinished();
                    }
                }
                // 上拉加载更多，达到有效长度
                else if (getScrollY() >= mEffictiveFooterHeight) {
                    releaseWithStatusLoadMore();
                    if (mRefreshListener != null) {
                        mRefreshListener.loadMoreFinished();
                    }
                } else {
                    releaseWithStatusTryRefresh();
                    releaseWithStatusTryLoadMore();
                }
                break;
        }

        mLastMoveY = y;
        return super.onTouchEvent(event);
    }

    private void beforeLoadMore() {
        if (getScrollY() <= -mEffectiveHeaderHeight) {
            mHeaderText.setText("松开刷新");
        } else {
            mHeaderText.setText("下拉刷新");
        }
    }

    private void beforeRefreshing() {
        if (getScrollY() >= mEffectiveHeaderHeight) {
            mFooterText.setText("松开加载更多");
        } else {
            mFooterText.setText("上拉加载更多");
        }
    }

    private void releaseWithStatusTryRefresh() {
        scrollBy(0, -getScrollY());
        mHeaderText.setText("下拉刷新");
        updateStatus(Status.NORMAL);
    }

    private void releaseWithStatusTryLoadMore() {
        scrollBy(0, -getScrollY());
        mFooterText.setText("上拉加载更多");
        updateStatus(Status.NORMAL);
    }

    private void releaseWithStatusRefresh() {
        scrollTo(0, -mEffectiveHeaderHeight);
        mHeaderProgressBar.setVisibility(VISIBLE);
        mHeaderText.setText("正在刷新");
        updateStatus(Status.REFRESHING);
    }

    private void releaseWithStatusLoadMore() {
        scrollTo(0, mEffictiveFooterHeight);
        mFooterText.setText("正在加载");
        mFooterProgressBar.setVisibility(VISIBLE);
        updateStatus(Status.LOADING);
    }

    public void refreshFinished() {
        scrollTo(0, 0);
        mHeaderText.setText("下拉刷新");
        mHeaderProgressBar.setVisibility(GONE);
        updateStatus(Status.NORMAL);
    }

    public void loadMoreFinished() {
        mFooterText.setText("上拉加载");
        mFooterProgressBar.setVisibility(GONE);
        scrollTo(0, 0);
        updateStatus(Status.NORMAL);
    }
}
