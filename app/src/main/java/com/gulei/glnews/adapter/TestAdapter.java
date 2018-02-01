package com.gulei.glnews.adapter;

import android.content.Context;
import android.widget.TextView;

import com.gulei.glnews.R;
import com.gulei.glnews.adapter.baseadapter.CommonRecycleAdapter;
import com.gulei.glnews.adapter.baseadapter.ViewHolderHelper;
import com.gulei.glnews.model.Testbean;

import java.util.List;

/**
 * Created by gl152 on 2018/1/31.
 */

public class TestAdapter extends CommonRecycleAdapter<Testbean> {

    public TestAdapter(Context mContext, List<Testbean> mData) {
        super(mContext, mData, R.layout.item_test);
    }

    @Override
    public void convert(ViewHolderHelper holder, Testbean testbean) {
        TextView tvTest = holder.getView(R.id.tvTest);
        tvTest.setText(testbean.getTestMsg());
    }


}
