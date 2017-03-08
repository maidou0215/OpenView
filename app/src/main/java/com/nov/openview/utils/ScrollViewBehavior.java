package com.nov.openview.utils;

import android.animation.ValueAnimator;
import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;

import com.nov.openview.R;
import com.nov.openview.app.AppConstant;
import com.nov.openview.demo.MyDotView;
import com.nov.openview.rx.RxBus;

/**
 * Created by yangzhicong on 2017/2/26.
 */
public class ScrollViewBehavior extends AppBarLayout.ScrollingViewBehavior {

    private static final String TAG = "overScrollScale";
    /**目标拖动的View*/
    private View mTargetScalingView;
    /** 下拉刷新TextView*/
    private MyDotView mMyDotView;
    /** 初始高度*/
    private int mOriginalHeight;
    /** 最大拖拽尺寸*/
    private int MAX_SCROLL_HEIGHT = 80;
    private int mTotalDyUnconsumed = 0;
    private ViewGroup.LayoutParams params;
    private ValueAnimator scaleAnim;
    private boolean animationStart = false;

    public ScrollViewBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ScrollViewBehavior() {
        super();
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        return dependency instanceof AppBarLayout;
    }

    @Override
    public boolean onLayoutChild(CoordinatorLayout parent, View abl, int layoutDirection) {
        boolean superLayout = super.onLayoutChild(parent, abl, layoutDirection);
        if (mTargetScalingView == null) {
            mTargetScalingView = parent.findViewById(R.id.appbar_layout);
            mMyDotView = (MyDotView) parent.findViewById(R.id.tv_pull_to_refresh);
            params = mTargetScalingView.getLayoutParams();
            mOriginalHeight = params.height;
        }
        return superLayout;
    }


    @Override
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, View child, View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        if (mTargetScalingView == null || dyConsumed != 0) {
            super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed);
            return;
        }
        Log.i(TAG, "child.height=" + child.getHeight());
        Log.i(TAG, "target.height=" + target.getHeight());
        Log.i(TAG, "params.height=" + params.height);
        Log.i(TAG, "mTargetScalingView.height=" + mTargetScalingView.getHeight());
        Log.i(TAG, "mOriginalHeight=" + mOriginalHeight);
        Log.i(TAG, "dyConsumed=" + dyConsumed);
        Log.i(TAG, "dyUnconsumed=" + dyUnconsumed);
        Log.i(TAG, "parentHeight=" + ((ViewGroup)mTargetScalingView.getParent()).getHeight());
        Log.i(TAG, "TopAndBottomOffset=" + getTopAndBottomOffset());

        if (dyUnconsumed < 0 && params.height >= MAX_SCROLL_HEIGHT && mTargetScalingView.getVisibility() == View.VISIBLE && params.height >= mOriginalHeight) {
            int absDyUnconsumed = Math.abs(dyUnconsumed);
            mTotalDyUnconsumed += absDyUnconsumed;
            params.width = ViewGroup.LayoutParams.MATCH_PARENT;
            params.height = mOriginalHeight + mTotalDyUnconsumed;
            mTargetScalingView.setLayoutParams(params);
            mMyDotView.setVisibility(View.VISIBLE);
            if (!animationStart) {
                mMyDotView.startAnimators();
                animationStart = true;
            }
        }

    }



    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View child, View directTargetChild, View target, int nestedScrollAxes) {
        return nestedScrollAxes == View.SCROLL_AXIS_VERTICAL;
    }


    @Override
    public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, View child, View target) {
        super.onStopNestedScroll(coordinatorLayout, child, target);
        if (params.height != mOriginalHeight) {
            cancelScroll(params.height);
        }
    }

    private void cancelScroll(int height) {
        scaleAnim = ValueAnimator.ofInt(height, mOriginalHeight);
        scaleAnim.setDuration(500);
        scaleAnim.setInterpolator(new LinearInterpolator());
        scaleAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                params.height = (int) valueAnimator.getAnimatedValue();
                mTargetScalingView.setLayoutParams(params);
            }
        });
        mTotalDyUnconsumed = 0;
        scaleAnim.start();
        mMyDotView.setVisibility(View.GONE);
        if (animationStart) {
            mMyDotView.stopAnimators();
            animationStart = false;
        }
    }

    private void postToRefresh() {
        RxBus.getInstance().post(AppConstant.REQUEST_FOR_ESSAY_REFRESH, null);
    }
}
