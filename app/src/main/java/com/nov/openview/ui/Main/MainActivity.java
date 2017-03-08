package com.nov.openview.ui.Main;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.nov.openview.R;
import com.nov.openview.base.BaseActivity;
import com.nov.openview.ui.Collection.CollectionListFragment;
import com.nov.openview.ui.Essay.EssayListFragment;
import com.nov.openview.ui.Movie.MovieListFragment;
import com.nov.openview.ui.Video.VideoListFragment;

import java.util.ArrayList;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements BottomNavigationBar.OnTabSelectedListener {

    private static final String tabsTitle[] = new String[]{"每日趣闻", "视频发现", "电影推荐", "我的收藏"};
    private static final int imageId[] = new int[]{R.mipmap.ic_essay_normal, R.mipmap.ic_video_normal,
            R.mipmap.ic_movie_normal, R.mipmap.ic_other_normal};
    private Fragment mContent;
    private ArrayList<Fragment> fragments = new ArrayList<>();
    private long mExitTime = 0;

    @BindView(R.id.bottomBar)
    BottomNavigationBar mBottomBar;

    public static void start(Context context) {
        Intent intent = new Intent();
        intent.setClass(context, MainActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        overridePendingTransition(android.R.anim.fade_in, 0);
        setNavigationBar();
    }


    @Override
    protected void setListeners() {

    }

    @Override
    protected void setToolBar() {

    }

    @Override
    public void initPresenter() {

    }

    /**
     * 导航栏设置
     */
    private void setNavigationBar() {
        mBottomBar.setActiveColor(R.color.colorWhite).setInActiveColor(R.color.colorGray);
        mBottomBar.addItem(new BottomNavigationItem(imageId[0], tabsTitle[0]))
                .addItem(new BottomNavigationItem(imageId[1], tabsTitle[1]))
                .addItem(new BottomNavigationItem(imageId[2], tabsTitle[2]))
                .addItem(new BottomNavigationItem(imageId[3], tabsTitle[3]))
                .initialise();
        fragments.add(EssayListFragment.newInstance("位置"));
        fragments.add(VideoListFragment.newInstance("位置"));
        fragments.add(MovieListFragment.newInstance("位置"));
        fragments.add(CollectionListFragment.newInstance("位置"));
        setDefaultFragment();
        mBottomBar.setTabSelectedListener(this);
    }

    /**
     * 设置默认的
     */
    private void setDefaultFragment() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        mContent = fragments.get(0);
        transaction.replace(R.id.tb, mContent);
        transaction.commit();
    }

    @Override
    public void onTabSelected(int position) {
        FragmentManager fm = this.getSupportFragmentManager();
        //开启事务
        FragmentTransaction transaction = fm.beginTransaction();
        switch (position) {
            case 0:
                switchContent(mContent, fragments.get(0), fm);
                break;
            case 1:
                switchContent(mContent, fragments.get(1), fm);
                break;
            case 2:
                switchContent(mContent, fragments.get(2), fm);
                break;
            case 3:
                switchContent(mContent, fragments.get(3), fm);
                break;
            default:
                break;
        }
        // 事务提交
        transaction.commit();
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }

    public void switchContent(Fragment from, Fragment to, android.support.v4.app.FragmentManager fm) {
        if (mContent != to) {
            mContent = to;
            android.support.v4.app.FragmentTransaction transaction = fm.beginTransaction();
            if (!to.isAdded()) {    // 先判断是否被add过
                transaction.hide(from).add(R.id.tb, to).commit(); // 隐藏当前的fragment，add下一个到Activity中
            } else {
                transaction.hide(from).show(to).commit(); // 隐藏当前的fragment，显示下一个
            }
        }
    }

    /**
     *  按两次退出程序
     * @param keyCode
     * @param event
     * @return
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if ((System.currentTimeMillis() - mExitTime) > 2000) {
                toast("再按一次退出程序");
                mExitTime = System.currentTimeMillis();
            } else {
                finish();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
