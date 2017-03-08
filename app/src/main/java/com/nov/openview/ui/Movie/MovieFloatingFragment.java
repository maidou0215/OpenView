package com.nov.openview.ui.Movie;

import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatRatingBar;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.nov.openview.R;
import com.nov.openview.bean.MovieListBean;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by yangzhicong on 2017/2/15.
 */

public class MovieFloatingFragment extends DialogFragment {

    public static final String TAG = MovieFloatingFragment.class.getSimpleName();
    private static final String MOVIE_DATA = "movie_data";

    @BindView(R.id.tv_floating_window_title)
    TextView mTvFloatingWindowTitle;
    @BindView(R.id.iv_floating_window_pic)
    ImageView mIvFloatingWindowPic;
    @BindView(R.id.tv_floating_window_time)
    TextView mTvFloatingWindowTime;
    @BindView(R.id.tv_floating_window_type)
    TextView mTvFloatingWindowType;
    @BindView(R.id.tv_floating_window_area)
    TextView mTvFloatingWindowArea;
    @BindView(R.id.btn_movie_detail)
    AppCompatButton mBtnMovieDetail;
    @BindView(R.id.tv_rating_number)
    TextView mTvRatingNumber;
    @BindView(R.id.rb_rating_bar)
    AppCompatRatingBar mRbRatingBar;

    private MovieListBean.SubjectsBean mMovieDetailsBean;

    public static MovieFloatingFragment newInstance(MovieListBean.SubjectsBean movie) {
        Bundle args = new Bundle();
        args.putSerializable(MOVIE_DATA, movie);
        MovieFloatingFragment fragment = new MovieFloatingFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void setArguments(Bundle args) {
        mMovieDetailsBean = (MovieListBean.SubjectsBean) args.getSerializable(MOVIE_DATA);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        getDialog().getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        View view = inflater.inflate(R.layout.fragment_movie_flating_window, null);
        ButterKnife.bind(this, view);
        initViewData();
        return view;
    }

    @OnClick(R.id.bg_view)
    void dismiss_fragment() {
        getDialog().dismiss();
    }

    private void initViewData() {
        mTvFloatingWindowTitle.setText(mMovieDetailsBean.getTitle());
        mTvFloatingWindowTime.setText("上映时间：" + mMovieDetailsBean.getYear());
        mTvFloatingWindowType.setText("影片类型：" + TextUtils.join("/", mMovieDetailsBean.getGenres()));
        mTvRatingNumber.setText(String.valueOf(mMovieDetailsBean.getRating().getAverage()));
        mRbRatingBar.setNumStars(5);
        mRbRatingBar.setRating((float) (mMovieDetailsBean.getRating().getAverage() / 2));
//        mTvFloatingWindowArea.setText("上映地区：" + mMovieDetailsBean.get);
        Glide.with(getActivity())
                .load(mMovieDetailsBean.getImages().getLarge())
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.RESULT)
                .placeholder(android.R.color.transparent)
                .into(mIvFloatingWindowPic);

        mBtnMovieDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MovieDetailsActivity.start(getActivity(), mMovieDetailsBean.getTitle(), mMovieDetailsBean.getId());
                getDialog().cancel();
            }
        });
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            DisplayMetrics dm = new DisplayMetrics();
            getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
            dialog.getWindow().setLayout((int) (dm.widthPixels * 0.70), (int) (dm.heightPixels * 0.70));
        }
    }
}
