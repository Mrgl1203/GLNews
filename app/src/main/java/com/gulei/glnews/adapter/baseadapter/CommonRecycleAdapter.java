package com.gulei.glnews.adapter.baseadapter;

import android.animation.Animator;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.Animation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gl152 on 2018/1/31.
 */

public abstract class CommonRecycleAdapter<T> extends RecyclerView.Adapter<ViewHolderHelper> implements IDataBiz<T> {
    protected Context mContext;
    protected List<T> mData = new ArrayList<>();
    protected int mLayoutID;
    protected LayoutInflater mInflater;

    //动画
    private int mlastPosition = -1;
    private int duration = 500;
    private Animation animation;
    private boolean mOpenAnimationEnable = false;
    private BaseAnimation mSelectAnimation = new AlphaAnimation();


    public CommonRecycleAdapter(Context mContext, List<T> mData, int mLayoutID) {
        this.mContext = mContext;
        this.mData = mData;
        this.mLayoutID = mLayoutID;
        mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public ViewHolderHelper onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHolderHelper holderHelper = ViewHolderHelper.getViewHolder(null, mLayoutID, mContext, parent);
        return holderHelper;
    }

    @Override
    public void onBindViewHolder(ViewHolderHelper holder, int position) {
        holder.setPosition(position);
        addAnimator(holder);
        convert(holder, mData.get(position));
    }

    public void openAnimator(BaseAnimation animation) {
        mOpenAnimationEnable = true;
        mSelectAnimation = animation;
    }

    public void closeAnimator() {
        mOpenAnimationEnable = false;
    }

    /**
     * 根据SDK中的解释，在Recyclerview 进行添加、移除item等操作时，position位置可能会变化
     * ，而所有的adapter的刷新并不总是及时的，只有这个方法返回的才是当前item经过一些变换后所处的真正位置。
     *
     * @param holder
     */
    protected void addAnimator(ViewHolderHelper holder) {
        if (mOpenAnimationEnable) {
            if (holder.getLayoutPosition() > mlastPosition) {
                if (mSelectAnimation != null) {
                    for (Animator animator : mSelectAnimation.getAnimations(holder.itemView)) {
                        startAnimation(animator);
                    }
                }
                mlastPosition = holder.getLayoutPosition();
            }
        }

    }

    protected void startAnimation(Animator animator) {
        animator.setDuration(duration).start();
    }

    public abstract void convert(ViewHolderHelper holder, T t);

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public void add(T element) {
        mData.add(element);
        notifyDataSetChanged();
    }

    @Override
    public void addAt(int position, T element) {
        mData.add(position, element);
        notifyDataSetChanged();
    }

    @Override
    public void addAll(List<T> elements) {
        mData.addAll(elements);
        notifyDataSetChanged();
    }

    @Override
    public void addAllAt(int position, List<T> elements) {
        mData.addAll(position, elements);
        notifyDataSetChanged();
    }

    @Override
    public void remove(T element) {
        mData.remove(element);
        notifyDataSetChanged();
    }

    @Override
    public void removeAt(int position) {
        mData.remove(position);
        notifyDataSetChanged();
    }

    @Override
    public void removeAll(List<T> elements) {
        mData.removeAll(elements);
        notifyDataSetChanged();
    }

    @Override
    public void clear() {
        if (mData != null && mData.size() > 0) {
            mData.clear();
            notifyDataSetChanged();
        }
    }

    @Override
    public void replace(T oldElem, T newElem) {
        int old_index = mData.indexOf(oldElem);
        replaceAt(old_index, newElem);
    }

    @Override
    public void replaceAt(int position, T oldElem) {
        mData.set(position, oldElem);
    }

    @Override
    public void replaceAll(List<T> elements) {
        if (mData != null && mData.size() > 0) {
            mData.clear();
        }
        mData.addAll(elements);
        notifyDataSetChanged();
    }

    @Override
    public T get(int position) {
        if (position > mData.size()) return null;
        return mData.get(position);
    }

    @Override
    public int getSize() {
        return mData.size();
    }

    @Override
    public List<T> getAll() {
        return mData;
    }
}
