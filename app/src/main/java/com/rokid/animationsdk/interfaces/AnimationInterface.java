package com.rokid.animationsdk.interfaces;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.Interpolator;

/**
 * Created by lijiacheng on 16/5/16.
 */
public interface AnimationInterface {
    ObjectAnimator translationX(View view, int duration, Animator.AnimatorListener listener, Interpolator interpolator, float... values);

    ObjectAnimator translationY(View view, int duration, Animator.AnimatorListener listener, Interpolator interpolator, float... values);

    ObjectAnimator scaleX(View view, int duration, Animator.AnimatorListener listener, Interpolator interpolator, float... values);

    ObjectAnimator scaleY(View view, int duration, Animator.AnimatorListener listener, Interpolator interpolator, float... values);

    ObjectAnimator rotation(View view, int duration, Animator.AnimatorListener listener, Interpolator interpolator, float... values);

    ObjectAnimator alpha(View view, int duration, Animator.AnimatorListener listener, Interpolator interpolator, float... values);

}
