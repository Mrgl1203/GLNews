package com.gulei.glnews.adapter.baseadapter;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;

/**
 * Created by gl152 on 2018/1/31.
 */

public class ScaleAnimation implements BaseAnimation {

    private static final float DEFAULT_SCALE = 0.5f;

    private float mFrom;

    public ScaleAnimation() {
        this(DEFAULT_SCALE);
    }

    public ScaleAnimation(float mFrom) {
        this.mFrom = mFrom;
    }

    @Override
    public Animator[] getAnimations(View view) {
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(view, "scaleX", mFrom, 1f);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(view, "scaleY", mFrom, 1f);
        return new ObjectAnimator[]{scaleX, scaleY};
    }
}
