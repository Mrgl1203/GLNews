package com.gulei.glnews.module.girl.fragment;


import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.gulei.glnews.BaseFragment;
import com.gulei.glnews.R;
import com.gulei.glnews.adapter.TestAdapter;
import com.gulei.glnews.model.Testbean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class PhotoMainFragment extends BaseFragment {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    TestAdapter testAdapter;
    List<Testbean> data = new ArrayList<>();
    @BindView(R.id.view)
    View view;


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_photo_main;
    }


    @Override
    protected void init() {
        initData();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);

        testAdapter = new TestAdapter(getActivity(), data);
//        testAdapter.openAnimator(new ScaleAnimation());
        recyclerView.setAdapter(testAdapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

    }


    private void initData() {
        for (int i = 0; i < 100; i++) {
            Testbean testbean = new Testbean("第" + i + "条数据");
            data.add(testbean);
        }
    }


    @OnClick({R.id.but_add, R.id.but_delete, R.id.but_update})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.but_add:
                break;
            case R.id.but_delete:
                break;
            case R.id.but_update:
                break;
        }
    }
}
