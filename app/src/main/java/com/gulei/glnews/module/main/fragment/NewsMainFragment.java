package com.gulei.glnews.module.main.fragment;


import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.gulei.glnews.BaseFragment;
import com.gulei.glnews.R;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsMainFragment extends BaseFragment {


    @BindView(R.id.Toolbar)
    android.support.v7.widget.Toolbar Toolbar;
    @BindView(R.id.TabLayout)
    android.support.design.widget.TabLayout TabLayout;
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.view)
    View view;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_news_main;
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

    }


}
