package com.rokid.animationsdk.anim;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.animation.Interpolator;

import com.rokid.animationsdk.AnimationApplication;
import com.rokid.animationsdk.interfaces.AnimationInterface;

/**
 * Created by lijiacheng on 16/5/16.
 */
public class AnimationUtils implements AnimationInterface {
    private static AnimationUtils animation = null;
    private static Context mContext = null;

    public AnimationUtils() {

    }

    public static AnimationUtils getInstance() {
        if (animation == null) {
            animation = new AnimationUtils();
            mContext = AnimationApplication.getInstance().getApplicationContext();
        }
        return animation;
    }

    public ObjectAnimator translationX(View view, int duration, float... values) {
        return translationX(view, duration, null, null, values);
    }

    public ObjectAnimator translationX(View view, int duration, Animator.AnimatorListener listener, float... values) {
        return translationX(view, duration, listener, null, values);
    }

    public ObjectAnimator translationX(View view, int duration, Interpolator interpolator, float... values) {
        return translationX(view, duration, null, interpolator, values);
    }

    @Override
    public ObjectAnimator translationX(View view, int duration, Animator.AnimatorListener listener, Interpolator interpolator, float... values) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(view, "translationX", values);
        animator.setDuration(duration);
        if (listener != null)
            animator.addListener(listener);
        if (interpolator != null)
            animator.setInterpolator(interpolator);
        return animator;
    }

    public ObjectAnimator translationY(View view, int duration, float... values) {
        return translationY(view, duration, null, null, values);
    }

    public ObjectAnimator translationY(View view, int duration, Animator.AnimatorListener listener, float... values) {
        return translationY(view, duration, listener, null, values);
    }

    public ObjectAnimator translationY(View view, int duration, Interpolator interpolator, float... values) {
        return translationY(view, duration, null, interpolator, values);
    }

    @Override
    public ObjectAnimator translationY(View view, int duration, Animator.AnimatorListener listener, Interpolator interpolator, float... values) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(view, "translationY", values);
        animator.setDuration(duration);
        if (listener != null)
            animator.addListener(listener);
        if (interpolator != null)
            animator.setInterpolator(interpolator);
        return animator;
    }

    public ObjectAnimator scaleX(View view, int duration, float... values) {
        return scaleX(view, duration, null, null, values);
    }

    public ObjectAnimator scaleX(View view, int duration, Animator.AnimatorListener listener, float... values) {
        return scaleX(view, duration, listener, null, values);
    }

    public ObjectAnimator scaleX(View view, int duration, Interpolator interpolator, float... values) {
        return scaleX(view, duration, null, interpolator, values);
    }

    @Override
    public ObjectAnimator scaleX(View view, int duration, Animator.AnimatorListener listener, Interpolator interpolator, float... values) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(view, "scaleX", values);
        animator.setDuration(duration);
        if (listener != null)
            animator.addListener(listener);
        if (interpolator != null)
            animator.setInterpolator(interpolator);
        return animator;
    }

    public ObjectAnimator scaleY(View view, int duration, float... values) {
        return scaleY(view, duration, null, null, values);
    }

    public ObjectAnimator scaleY(View view, int duration, Animator.AnimatorListener listener, float... values) {
        return scaleY(view, duration, listener, null, values);
    }

    public ObjectAnimator scaleY(View view, int duration, Interpolator interpolator, float... values) {
        return scaleY(view, duration, null, interpolator, values);
    }

    @Override
    public ObjectAnimator scaleY(View view, int duration, Animator.AnimatorListener listener, Interpolator interpolator, float... values) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(view, "scaleY", values);
        animator.setDuration(duration);
        if (listener != null)
            animator.addListener(listener);
        if (interpolator != null)
            animator.setInterpolator(interpolator);
        return animator;
    }

    public ObjectAnimator rotation(View view, int duration, float... values) {
        return rotation(view, duration, null, null, values);
    }

    public ObjectAnimator rotation(View view, int duration, Animator.AnimatorListener listener, float... values) {
        return rotation(view, duration, listener, null, values);
    }

    public ObjectAnimator rotation(View view, int duration, Interpolator interpolator, float... values) {
        return rotation(view, duration, null, interpolator, values);
    }

    @Override
    public ObjectAnimator rotation(View view, int duration, Animator.AnimatorListener listener, Interpolator interpolator, float... values) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(view, "rotation", values);
        animator.setDuration(duration);
        if (listener != null)
            animator.addListener(listener);
        if (interpolator != null)
            animator.setInterpolator(interpolator);
        return animator;
    }

    public ObjectAnimator alpha(View view, int duration, float... values) {
        return alpha(view, duration, null, null, values);
    }

    public ObjectAnimator alpha(View view, int duration, Animator.AnimatorListener listener, float... values) {
        return alpha(view, duration, listener, null, values);
    }

    public ObjectAnimator alpha(View view, int duration, Interpolator interpolator, float... values) {
        return alpha(view, duration, null, interpolator, values);
    }

    @Override
    public ObjectAnimator alpha(View view, int duration, Animator.AnimatorListener listener, Interpolator interpolator, float... values) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(view, "alpha", values);
        animator.setDuration(duration);
        if (listener != null)
            animator.addListener(listener);
        if (interpolator != null)
            animator.setInterpolator(interpolator);
        return animator;
    }
}
