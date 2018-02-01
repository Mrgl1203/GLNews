package com.gulei.glnews.ui;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by gl152 on 2018/1/17.
 */

public class NoScrollViewPager extends ViewPager {
    private boolean isPageEnable = true;

    public NoScrollViewPager(Context context) {
        super(context);
    }

    public NoScrollViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        //返回false不拦截事件传递，继续传递给子view处理
        return  isPageEnable;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        //返回false自己不再消费事件
        return isPageEnable;
    }

    public void setPageEnable(boolean isPageEnable) {
        this.isPageEnable = isPageEnable;
    }

}
