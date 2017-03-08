package com.nov.openview.utils;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.nov.openview.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by yangzhicong on 2017/3/2.
 */

public class MyRippleView extends FrameLayout {

    private Paint mCirclePaint;
    private Paint mPaint;
    private float end_radial = ViewConvertUtil.dip2px(getContext(), 200);
    private int color = R.color.colorWhite;
    private ArrayList<ValueAnimator> mAnimators;
    float[] scaleFloats = new float[]{end_radial / 3, end_radial / 3, end_radial / 3, end_radial / 3};
    int[] alphaInts = new int[]{255, 255, 255, 255};

    RippleImageView mRippleImageView;
    CircleImageView mCircleImageView;

    public MyRippleView(Context context) {
        super(context);
    }

    public MyRippleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mRippleImageView = new RippleImageView(context);
        FrameLayout.LayoutParams rippleParams = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        FrameLayout.LayoutParams imgParams = new FrameLayout.LayoutParams((int)end_radial*2/3, (int)end_radial*2/3);
        imgParams.gravity = Gravity.CENTER;
        rippleParams.gravity = Gravity.CENTER;
        mCircleImageView = new CircleImageView(context);
        mCircleImageView.setImageResource(R.drawable.ic_w);
        mCircleImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        mCircleImageView.setLayoutParams(imgParams);
        addView(mRippleImageView, rippleParams);
        addView(mCircleImageView);
    }

    public void startAnimation() {
        mRippleImageView.startAnimators();
    }

    public void stopAnimation() {
        mRippleImageView.stopAnimators();
    }

    class RippleImageView extends View {

        public RippleImageView(Context context) {
            super(context, null);
            initPaint();
        }

        public RippleImageView(Context context, AttributeSet attrs) {
            super(context, attrs);
            initPaint();
            mAnimators = onCreateAnimators();
        }

        private void initPaint() {
            mCirclePaint = new Paint();
            mCirclePaint.setAntiAlias(true);
            mCirclePaint.setColor(getResources().getColor(color));
            mCirclePaint.setStyle(Paint.Style.STROKE);
            mCirclePaint.setStrokeWidth(10);

            mPaint = new Paint();
            mPaint.setAntiAlias(true);
            mPaint.setColor(getResources().getColor(color));
            mPaint.setStyle(Paint.Style.STROKE);
            mPaint.setStrokeWidth(10);
        }

        @Override
        protected void onDraw(final Canvas canvas) {
            super.onDraw(canvas);
            for (int i = 0; i < 4; i++) {
                mCirclePaint.setAlpha(alphaInts[i]);
                canvas.drawCircle(getWidth() / 2, getHeight() / 2, scaleFloats[i], mCirclePaint);
            }
            canvas.drawCircle(getWidth() / 2, getHeight() / 2, end_radial / 3, mPaint);
        }

        public ArrayList<ValueAnimator> onCreateAnimators() {
            ArrayList<ValueAnimator> animators = new ArrayList<>();
            long[] delays = new long[]{0, 800, 1600, 2400};
            for (int i = 0; i < 4; i++) {
                final int index = i;
                ValueAnimator scaleAnim = ValueAnimator.ofFloat(end_radial / 3, end_radial);
                scaleAnim.setDuration(2400);
                scaleAnim.setInterpolator(new LinearInterpolator());
                scaleAnim.setRepeatCount(-1);
                scaleAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        scaleFloats[index] = (float) animation.getAnimatedValue();
                        postInvalidate();
                    }
                });
                scaleAnim.setStartDelay(delays[i]);

                ValueAnimator alphaAnim = ValueAnimator.ofInt(255, 0);
                alphaAnim.setDuration(2400);
                alphaAnim.setRepeatCount(-1);
                alphaAnim.setInterpolator(new LinearInterpolator());
                alphaAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        alphaInts[index] = (int) animation.getAnimatedValue();
                        postInvalidate();
                    }
                });
                scaleAnim.setStartDelay(delays[i]);
                alphaAnim.setStartDelay(delays[i]);
                animators.add(scaleAnim);
                animators.add(alphaAnim);
            }
            return animators;
        }


        public void startAnimators() {
            for (ValueAnimator animator : onCreateAnimators()) {
                animator.start();
            }
        }

        public void stopAnimators() {
            if (mAnimators!=null){
                for (ValueAnimator animator : mAnimators) {
                    if (animator != null && animator.isStarted()) {
                        animator.removeAllUpdateListeners();
                        animator.end();
                    }
                }
            }
        }
    }
}
