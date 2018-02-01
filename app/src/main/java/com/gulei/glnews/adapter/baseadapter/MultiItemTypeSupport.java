package com.gulei.glnews.adapter.baseadapter;

/**
 * Created by gl152 on 2018/2/1.
 */

public interface MultiItemTypeSupport<T> {

    int getItemViewType(int position, T t);

}
