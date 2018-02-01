package com.gulei.glnews.adapter.baseadapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by gl152 on 2018/1/31.
 */

public class ViewHolderHelper extends RecyclerView.ViewHolder {

    private SparseArray<View> mViews;
    private View mConvertView;
    private int mLayoutID;
    private int position;


    private ViewHolderHelper(View itemView) {
        super(itemView);
        mConvertView = itemView;
        mViews = new SparseArray<>();
        mConvertView.setTag(this);
    }

    public static ViewHolderHelper getViewHolder(View mConvertView, int mLayoutID, Context context, ViewGroup parent) {
        if (mConvertView == null) {
            View view = LayoutInflater.from(context).inflate(mLayoutID, parent, false);
            ViewHolderHelper holder = new ViewHolderHelper(view);
            holder.mLayoutID = mLayoutID;
            return holder;
        } else {
            ViewHolderHelper holder = (ViewHolderHelper) mConvertView.getTag();
            return holder;
        }
    }

    public <T extends View> T getView(int id) {
        View view = mViews.get(id);
        if (view == null) {
            view = mConvertView.findViewById(id);
            mViews.put(id, view);
        }
        return (T) view;

    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getCurrentPosition() {
        return position;
    }

    public int getLayoutID() {
        return mLayoutID;
    }


}
