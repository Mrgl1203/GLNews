package com.gulei.glnews.adapter.baseadapter;

import android.content.Context;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by gl152 on 2018/2/1.
 */

public abstract class MultiItemRecycleViewAdapter<T> extends CommonRecycleAdapter<T> {

    private MultiItemTypeSupport multiItemTypeSupport;

    public MultiItemRecycleViewAdapter(Context mContext, List<T> mData, int mLayoutID) {
        super(mContext, mData, mLayoutID);
    }

    @Override
    public int getItemViewType(int position) {
        if (multiItemTypeSupport != null)
            return multiItemTypeSupport.getItemViewType(position, mData.get(position));
        return super.getItemViewType(position);
    }

    @Override
    public ViewHolderHelper onCreateViewHolder(ViewGroup parent, int viewType) {

        return super.onCreateViewHolder(parent, viewType);
    }
}
