package com.gulei.glnews.adapter.baseadapter;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;

/**
 * Created by gl152 on 2018/1/31.
 */

public class AlphaAnimation implements BaseAnimation {
    private static final float DEFAULT_ALPHA = 0f;
    private float mFrom;

    public AlphaAnimation() {
        this(DEFAULT_ALPHA);
    }

    public AlphaAnimation(float mFrom) {
        this.mFrom = mFrom;
    }

    @Override
    public Animator[] getAnimations(View view) {
        ObjectAnimator alpha = ObjectAnimator.ofFloat(view, "alpha", mFrom, 1f);
        return new ObjectAnimator[]{alpha};
    }
}
