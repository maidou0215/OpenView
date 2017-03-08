package com.nov.openview.ui.Essay;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.nov.openview.R;
import com.nov.openview.base.BaseFragment;
import com.nov.openview.bean.EssayListBean;
import com.nov.openview.utils.CustomTextView;
import com.nov.openview.utils.DatePickerDialogView;
import com.nov.openview.utils.SystemDateUtil;

import butterknife.BindView;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by yangzhicong on 2017/2/18.
 */

public class EssayListFragment extends BaseFragment<EssayListPresenter, EssayListModel> implements EssayListContract.View{


    @BindView(R.id.essay_listing)
    RecyclerView mEssayListing;
    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout mCollapsingToolbar;
    @BindView(R.id.iv_video)
    ImageView mIvVideo;
    @BindView(R.id.tv_title)
    TextView mTvTitle;
    @BindView(R.id.iv_author_pic)
    CircleImageView mIvAuthorPic;
    @BindView(R.id.tv_author_name)
    TextView mTvAuthorName;
    @BindView(R.id.ll_moban_toolbar)
    LinearLayout mMobanTollbar;
    @BindView(R.id.main_toolbar_tv_time)
    CustomTextView mMainToolbarTvTime;
    @BindView(R.id.tv_toolbar_title)
    CustomTextView mTvToolbarTitle;
    @BindView(R.id.main_toolbar_iv_right)
    ImageButton mMainToolbarIvRight;
    @BindView(R.id.appbar_layout)
    AppBarLayout mAppBarLayout;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    private String mTimeDate;
    private EssayListAdapter mAdapter;
    private static final String TAG = EssayListFragment.class.getSimpleName();


    public static EssayListFragment newInstance(String string) {
        Bundle args = new Bundle();
        args.putString(TAG, string);
        EssayListFragment fragment = new EssayListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_essays;
    }

    @Override
    protected void initView(View view) {
        mTimeDate = SystemDateUtil.getStringDateShort();
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setAutoMeasureEnabled(true);
        mEssayListing.setLayoutManager(layoutManager);
        mEssayListing.setHasFixedSize(true);
        mEssayListing.setNestedScrollingEnabled(false);
        mAdapter = new EssayListAdapter(null);
        mEssayListing.setAdapter(mAdapter);

        mPresenter.loadEssayListDataRequest();

    }

    @Override
    protected void setListener() {
        mMainToolbarTvTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialogView.showDialog(getActivity(), new DatePickerDialogView.onDateSetListener() {
                    @Override
                    public void onDateSetComplete(int year, int month, int day) {
                        mTimeDate = String.format("%d-%d-%d", year, month, day);
                        mMainToolbarTvTime.setText(mTimeDate);
                        mPresenter.loadEssayListDataRequest();
                    }
                });
            }
        });

    }

    @Override
    protected void setToolBar() {
        mMainToolbarTvTime.setText("Today");
        mTvToolbarTitle.setText(R.string.essay_string);
        mMainToolbarIvRight.setImageResource(R.drawable.transparent);
        mCollapsingToolbar.setTitle(" ");
        mCollapsingToolbar.setContentScrimColor(ContextCompat.getColor(getContext(), R.color.colorPrimary));
        if (mToolbar != null) {
            ((AppCompatActivity) getActivity()).setSupportActionBar(mToolbar);
        }
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    public String getTimeDate() {
        return mTimeDate;
    }

    @Override
    public void returnEssayListData(EssayListBean essayListBean) {
        mAdapter.setNewData(essayListBean.getPosts());
        if (essayListBean.getPosts().size() != 0) {
            int count = essayListBean.getPosts().size()-1;
            int number = (int) (Math.random() * count);
            EssayListBean.PostsBean item = essayListBean.getPosts().get(number);
            setPoster(item);
        }
    }

    private void setPoster(final EssayListBean.PostsBean item) {
        mTvTitle.setText(item.getTitle());
        mTvAuthorName.setText(item.getAuthor()==null ? " ":item.getAuthor().getName());
        mMobanTollbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EssayDetailActivity.start(getContext(), String.valueOf(item.getId()));
            }
        });
        if (!item.getThumbs().isEmpty()) {
            Glide.with(getContext())
                    .load(item.getThumbs().get(0).getMedium().getUrl())
                    .crossFade()
                    .diskCacheStrategy(DiskCacheStrategy.RESULT)
                    .placeholder(android.R.color.transparent)
                    .into(mIvVideo);
        }
        if (!item.getAuthor().getAvatar().isEmpty()) {
            Glide.with(getContext())
                    .load(item.getAuthor().getAvatar())
                    .crossFade()
                    .diskCacheStrategy(DiskCacheStrategy.RESULT)
                    .placeholder(android.R.color.transparent)
                    .into(mIvAuthorPic);
        }
    }

    @Override
    public void showLoading(String title) {

    }

    @Override
    public void stopLoading() {

    }

    @Override
    public void showErrorTip(String msg) {

    }
}
