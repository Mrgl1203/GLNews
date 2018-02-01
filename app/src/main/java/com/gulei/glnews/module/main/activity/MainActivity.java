package com.gulei.glnews.module.main.activity;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;

import com.gulei.glnews.BaseActivity;
import com.gulei.glnews.R;
import com.gulei.glnews.module.care.fragment.CareMainFragment;
import com.gulei.glnews.module.girl.fragment.PhotoMainFragment;
import com.gulei.glnews.module.main.fragment.NewsMainFragment;
import com.gulei.glnews.module.video.fragment.VideoMainFragment;
import com.gulei.glnews.ui.NoScrollViewPager;
import com.gulei.glnews.ui.TabView;
import com.gulei.glnews.util.Mlog;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R.id.viewPager)
    NoScrollViewPager viewPager;
    @BindView(R.id.tabMain)
    TabView tabMain;
    @BindView(R.id.tabGirl)
    TabView tabGirl;
    @BindView(R.id.tabVideo)
    TabView tabVideo;
    @BindView(R.id.tabCare)
    TabView tabCare;
    @BindView(R.id.LinearBottom)
    LinearLayout LinearBottom;
    @BindView(R.id.view)
    View view;

    List<TabView> tabViews = new ArrayList<>();
    List<Fragment> fragments = new ArrayList<>();
    Fragment newsMainfragment;
    Fragment photosMainfragment;
    Fragment videoMainfragment;
    Fragment careMainfragment;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }


    @Override
    protected void init() {
        fragments.add(newsMainfragment = new NewsMainFragment());
        fragments.add(photosMainfragment = new PhotoMainFragment());
        fragments.add(videoMainfragment = new VideoMainFragment());
        fragments.add(careMainfragment = new CareMainFragment());

        viewPager.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments == null ? 0 : fragments.size();
            }

        });
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                changeTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        viewPager.setPageEnable(true);
        viewPager.setOffscreenPageLimit(fragments.size());

        tabViews.add(tabMain);
        tabViews.add(tabGirl);
        tabViews.add(tabVideo);
        tabViews.add(tabCare);
        changeTab(0);

    }

    public void changeImmersionBar(int color) {
        mImmersionBar.fitsSystemWindows(true).statusBarColor(color).init();
    }


    @OnClick({R.id.tabMain, R.id.tabGirl, R.id.tabVideo, R.id.tabCare})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tabMain:
                viewPager.setCurrentItem(0,false);
                break;
            case R.id.tabGirl:
                viewPager.setCurrentItem(1,false);
                break;
            case R.id.tabVideo:
                viewPager.setCurrentItem(2,false);
                break;
            case R.id.tabCare:
                viewPager.setCurrentItem(3,false);
                break;
        }
    }

    int previousPosition = 0;
    int currentPosition = 0;

    private void changeTab(int position) {
        Mlog.e("position=" + position);
        previousPosition = currentPosition;//记录之前一个tab的position
        currentPosition = position;
        tabViews.get(previousPosition).setChecked(false);
        tabViews.get(currentPosition).setChecked(true);

        switch (position) {
            //首页
            case 0:
                changeImmersionBar(R.color.main_color);
                break;
            //美女
            case 1:
                changeImmersionBar(R.color.red);
                break;
            //视频
            case 2:
                changeImmersionBar(R.color.green);
                break;
            //关注
            case 3:
                changeImmersionBar(R.color.blue);
                break;
            default:
                break;

        }

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.KEYCODE_BACK) {
            /**
             * onRoot=false→ 仅当activity为task根（即首个activity例如启动activity之类的）时才生效
             * nonRoot=true→ 忽略上面的限制
             */
            moveTaskToBack(false);
        }
        return super.onKeyDown(keyCode, event);
    }
}
