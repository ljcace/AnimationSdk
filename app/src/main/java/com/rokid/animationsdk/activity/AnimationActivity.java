package com.rokid.animationsdk.activity;

import android.animation.Animator;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.rokid.animationsdk.R;
import com.rokid.animationsdk.anim.AnimationUtils;

/**
 * Created by lijiacheng on 16/5/16.
 */
public class AnimationActivity extends Activity implements Animator.AnimatorListener {
    TextView textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_animation);
        textview = (TextView) findViewById(R.id.textview);
        Animator.AnimatorListener listener = this;
        AnimationUtils.getInstance().translateX(textview, 1000, listener, 0f, 1f);
    }

    @Override
    public void onAnimationStart(Animator animation) {

    }

    @Override
    public void onAnimationEnd(Animator animation) {
    }

    @Override
    public void onAnimationCancel(Animator animation) {

    }

    @Override
    public void onAnimationRepeat(Animator animation) {

    }
}
