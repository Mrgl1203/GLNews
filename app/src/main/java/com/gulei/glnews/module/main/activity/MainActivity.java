package com.gulei.glnews.module.main.activity;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
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
    Fragment photoMainfragment;
    Fragment videoMainfragment;
    Fragment careMainfragment;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
        mImmersionBar.statusBarView(view)
                .statusBarColor(R.color.green)
                .init();
    }

    @Override
    protected void init() {
        fragments.add(newsMainfragment = new NewsMainFragment());
        fragments.add(photoMainfragment = new PhotoMainFragment());
        fragments.add(videoMainfragment = new VideoMainFragment());
        fragments.add(careMainfragment = new CareMainFragment());

        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments == null ? 0 : fragments.size();
            }

        });
        viewPager.setPageEnable(false);
        viewPager.setOffscreenPageLimit(fragments.size());

        tabViews.add(tabMain);
        tabViews.add(tabGirl);
        tabViews.add(tabVideo);
        tabViews.add(tabCare);
        changeTab(0);

    }


    @OnClick({R.id.tabMain, R.id.tabGirl, R.id.tabVideo, R.id.tabCare})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tabMain:
                changeTab(0);
                break;
            case R.id.tabGirl:
                changeTab(1);
                break;
            case R.id.tabVideo:
                changeTab(2);
                break;
            case R.id.tabCare:
                changeTab(3);
                break;
        }
    }

    int previousPosition = 0;
    int currentPosition = 0;

    private void changeTab(int position) {
        previousPosition = currentPosition;//记录之前一个tab的position
        currentPosition = position;
        viewPager.setCurrentItem(currentPosition, false);
        tabViews.get(previousPosition).setChecked(false);
        tabViews.get(currentPosition).setChecked(true);
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
