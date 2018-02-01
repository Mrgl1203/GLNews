package com.gulei.glnews.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gulei.glnews.R;

/**
 * Created by gl152 on 2018/1/15.
 */

public class TabView extends LinearLayout {
    ImageView ivTab;
    TextView tvTab;
    int srcChecked, srcUnChecked;
    int txtCheckedColor, txtUnCheckedColor;
    String title;
    boolean isChecked = false;

    public TabView(Context context) {
        this(context, null);
    }

    public TabView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);

    }

    public TabView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        View view = LayoutInflater.from(context).inflate(R.layout.tab_view, this);

        ivTab = view.findViewById(R.id.ivTab);
        tvTab = view.findViewById(R.id.tvTab);

        TypedArray array = context.obtainStyledAttributes(attrs,R.styleable.TabView);
        srcChecked = array.getResourceId(R.styleable.TabView_srcChecked, R.mipmap.ic_launcher);
        srcUnChecked = array.getResourceId(R.styleable.TabView_srcUnChecked, R.mipmap.ic_launcher);
        txtCheckedColor = array.getColor(R.styleable.TabView_txtCheckedColor, 0xFA7C20);
        txtUnCheckedColor = array.getColor(R.styleable.TabView_txtUnCheckedColor, 0x808080);
        title = array.getString(R.styleable.TabView_title);

        if (TextUtils.isEmpty(title)) {
            tvTab.setVisibility(GONE);
        } else {
            tvTab.setVisibility(VISIBLE);
            tvTab.setText(title);
            tvTab.setTextColor(txtUnCheckedColor);
        }
        ivTab.setImageResource(srcUnChecked);

        array.recycle();
    }


    public void setChecked(boolean isChecked) {
        this.isChecked = isChecked;
        if (isChecked) {
            tvTab.setTextColor(txtCheckedColor);
            ivTab.setImageResource(srcChecked);
        } else {
            tvTab.setTextColor(txtUnCheckedColor);
            ivTab.setImageResource(srcUnChecked);
        }
    }

    public void setTitle(String text) {
        this.title = text;
        tvTab.setText(text);
    }


}
