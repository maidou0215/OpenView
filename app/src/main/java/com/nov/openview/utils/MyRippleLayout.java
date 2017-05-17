package com.nov.openview.utils;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
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

public class MyRippleLayout extends FrameLayout {

    private Paint mCirclePaint;
    private Paint mPaint;
    private static final float DEFAULT_CIRCLE_RADIAL = 200;
    private static final int DEFAULT_DURATION = 2400;
    private float end_radial, start_radial, img_radial;
    private int circle_color, duration;
    private ArrayList<ValueAnimator> mAnimators;
    float[] scaleFloats = new float[]{start_radial, start_radial, start_radial, start_radial};
    int[] alphaInts = new int[]{255, 255, 255, 255};

    RippleImageView mRippleImageView;
    CircleImageView mCircleImageView;

    public MyRippleLayout(Context context) {
        super(context);
    }

    public MyRippleLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs);
    }

    private void initView(Context context, AttributeSet attrs) {
        TypedArray attributeArray = getContext().getTheme().obtainStyledAttributes(attrs, R.styleable.my_ripple_view, 0, 0);
        end_radial = attributeArray.getFloat(R.styleable.my_ripple_view_view_radius, DEFAULT_CIRCLE_RADIAL);
        circle_color = attributeArray.getColor(R.styleable.my_ripple_view_view_color, Color.WHITE);
        duration = attributeArray.getInteger(R.styleable.my_ripple_view_view_duration, DEFAULT_DURATION);
        end_radial = ViewConvertUtil.dip2px(context, end_radial);
        start_radial = end_radial / 3;
        img_radial = end_radial * 2 / 3;
        mRippleImageView = new RippleImageView(context);
        LayoutParams rippleParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        LayoutParams imgParams = new LayoutParams((int)img_radial, (int)img_radial);
        imgParams.gravity = Gravity.CENTER;
        rippleParams.gravity = Gravity.CENTER;
        mCircleImageView = new CircleImageView(context);
        mCircleImageView.setImageResource(R.drawable.ic_w);
        mCircleImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        mCircleImageView.setLayoutParams(imgParams);

        addView(mRippleImageView, rippleParams);
        addView(mCircleImageView);
    }

    public void setRippleColor(int color) {
        mRippleImageView.setRippleColor(color);
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
            mCirclePaint.setColor(circle_color);
            mCirclePaint.setStyle(Paint.Style.STROKE);
            mCirclePaint.setStrokeWidth(10);
            mPaint = new Paint();
            mPaint.setAntiAlias(true);
            mPaint.setColor(circle_color);
            mPaint.setStyle(Paint.Style.STROKE);
            mPaint.setStrokeWidth(10);
        }

        public void setRippleColor(int color) {
            circle_color = color;
            invalidate();
        }

        public void setDuration(int d) {
            duration = d;
            invalidate();
        }

        public void setRadial(float radial) {
            end_radial = radial;
            invalidate();
        }

        @Override
        protected void onDraw(final Canvas canvas) {
            super.onDraw(canvas);
            for (int i = 0; i < 4; i++) {
                mCirclePaint.setAlpha(alphaInts[i]);
                canvas.drawCircle(getWidth() / 2, getHeight() / 2, scaleFloats[i], mCirclePaint);
            }
            canvas.drawCircle(getWidth() / 2, getHeight() / 2, start_radial, mPaint);
        }

        public ArrayList<ValueAnimator> onCreateAnimators() {
            ArrayList<ValueAnimator> animators = new ArrayList<>();
            long[] delays = new long[]{0, duration / 3, duration * 2 / 3, duration};
            for (int i = 0; i < 4; i++) {
                final int index = i;
                ValueAnimator scaleAnim = ValueAnimator.ofFloat(start_radial, end_radial);
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
