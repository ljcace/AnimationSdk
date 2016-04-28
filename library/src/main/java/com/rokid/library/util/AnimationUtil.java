package com.rokid.library.util;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.TextureView;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import com.rokid.library.R;
import com.rokid.library.anim.ClockInterpolator;
import com.rokid.library.anim.MyRotateAnimation;
import com.rokid.library.anim.Rotate3DAnim;
import com.rokid.library.anim.Rotate3dAnimation;
import com.rokid.library.interfaces.AnimCallbackInterface;
import com.rokid.library.interpolator.ElasticInterpolator;


/**
 * @author daxia
 * @created 2016/03/09 下午1:45
 */
public class AnimationUtil {
    private View view;
    private AnimationSet animSet;
    private AnimCallbackInterface callBack;

    public AnimationUtil() {
    }

    private AnimationUtil(Builder builder) {
        view = builder.view;
        animSet = builder.animSet;
        callBack = builder.callBack;
        animSet.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                if (callBack != null)
                    callBack.CallBack(false);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if (callBack != null)
                    callBack.CallBack(true);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        view.startAnimation(animSet);
    }

    public static class Builder {
        private AnimCallbackInterface callBack;
        private View view;
        private AnimationSet animSet = new AnimationSet(false);
        private int duration = 500;
        private Context context;

        public Builder context(Context context) {
            this.context = context;
            return this;
        }

        public Builder callBack(AnimCallbackInterface callBack) {
            this.callBack = callBack;
            return this;
        }

        public Builder view(View view) {
            this.view = view;
            return this;
        }

        public Builder duration(int duration) {
            this.duration = duration;
            animSet.setDuration(this.duration);
            return this;
        }

        public Builder fillAfter(boolean fillAfter) {
            animSet.setFillAfter(fillAfter);
            return this;
        }

        /**
         * View渐隐动画效果
         *
         * @return
         */
        public Builder hideAnimation() {
            if (view == null || duration < 0) {
                return null;
            }
            AlphaAnimation mHideAnimation = new AlphaAnimation(1.0f, 0.0f);
            animSet.addAnimation(mHideAnimation);
            return this;
        }

        /**
         * View渐现动画效果
         */
        public Builder showAnimation(View view) {
            if (view == null || duration < 0) {
                return null;
            }
            AlphaAnimation mShowAnimation = new AlphaAnimation(0.0f, 1.0f);
            animSet.addAnimation(mShowAnimation);
            return this;
        }

        public Builder rotateAnimation(float fDgree, float tDgree) {
            float cX = view.getWidth() / 2.0f;
            float cY = view.getHeight() / 2.0f;
            return rotateAnimation(cX, cY, fDgree, tDgree);
        }

        /**
         * ViewY轴动画效果
         */
        public Builder rotateAnimation(float cX, float cY, float fDgree, float tDgree) {
            if (view == null || duration < 0) {
                return null;
            }
            MyRotateAnimation mRotateAnimation = new MyRotateAnimation(cX, cY, fDgree, tDgree);
            animSet.addAnimation(mRotateAnimation);
            return this;
        }

        /**
         * ViewY轴3D动画效果
         */
        public Builder rotate3dAnimation(float fromDegrees, float toDegrees, boolean dithering, boolean reverse) {
            if (view == null || duration < 0) {
                return null;
            }

            Rotate3dAnimation rotate3dAnimation = new Rotate3dAnimation(fromDegrees, toDegrees, view.getWidth() / 2, view.getHeight() / 2, 100, reverse);
            if (dithering) {
                rotate3dAnimation.setInterpolator(new ElasticInterpolator(2, 0f, 0f));
            }
            animSet.addAnimation(rotate3dAnimation);
            return this;
        }

        /**
         * 位移动画
         *
         * @return
         */
        public Builder translateAnimation(float fromXDelta, float toXDelta, float fromYDelta, float toYDelta) {
            if (view == null || duration < 0) {
                return null;
            }

            TranslateAnimation translateAnimation = new TranslateAnimation(fromXDelta, toXDelta, fromYDelta, toYDelta);
            animSet.addAnimation(translateAnimation);
            return this;
        }

        public Builder AnimationUpCenter() {
            if (view == null || duration < 0) {
                return null;
            }
            Animation animation_up = AnimationUtils.loadAnimation(context, R.anim.anim_move_up_center);
            animSet.addAnimation(animation_up);
            return this;
        }

        public Builder AnimationDownCenter() {
            if (view == null || duration < 0) {
                return null;
            }
            Animation animation_down = AnimationUtils.loadAnimation(context, R.anim.anim_move_down_center);
            animSet.addAnimation(animation_down);
            return this;
        }

        public Builder AnimationUp33() {
            if (view == null || duration < 0) {
                return null;
            }
            Animation animation_up_33 = AnimationUtils.loadAnimation(context, R.anim.anim_move_up_center_33);
            animSet.addAnimation(animation_up_33);
            return this;
        }

        public Builder AnimationDown33() {
            if (view == null || duration < 0) {
                return null;
            }
            Animation animation_down_33 = AnimationUtils.loadAnimation(context, R.anim.anim_move_down_center_33);
            animSet.addAnimation(animation_down_33);
            return this;
        }

        public Builder Anim3DRotation() {
            Rotate3DAnim animation_rotation = null;
            animation_rotation =
                    new Rotate3DAnim(0, -90, view.getWidth() / 2, view.getHeight() / 2, 0.0f, true);
            animSet.addAnimation(animation_rotation);
            return this;
        }

        public Builder getAnimTime(float toDgree) {
            return this.getAnimTime(0, toDgree);
        }

        public Builder getAnimTime(float fromDgree, float toDgree) {
            RotateAnimation animation_time = null;
            animation_time = new RotateAnimation(fromDgree, toDgree, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
            animation_time.setInterpolator(new DecelerateInterpolator());
            animSet.addAnimation(animation_time);
            return this;
        }

        public AnimationUtil startAnimation() {
            return new AnimationUtil(this);
        }
    }

    public ObjectAnimator AnimQq(View v, long duration) {
        v.setPivotX(05f);
        v.setPivotY(0f);
        ObjectAnimator moveIn = ObjectAnimator.ofFloat(v, "rotationX", -90f, 0f);  //ofFloat(tv, "rotateX", -90f, 0f);

        moveIn.setDuration(duration);
        moveIn.setInterpolator(new ClockInterpolator(4, 0.6f));
        return moveIn;
    }

    public static AnimationDrawable searchAnimation(ImageView view) {
        if (view == null) {
            return null;
        }
        view.setImageResource(R.drawable.animation_search);
        AnimationDrawable searchAnimation = (AnimationDrawable) view.getDrawable();
        return searchAnimation;
    }

    public static AnimationSet textYTransShowAnimation(int duration) {
        return textYTransShowAnimation(100f, duration);
    }

    public static AnimationSet textYTransShowAnimation(float fY, int duration) {
        TranslateAnimation translateAnimation = new TranslateAnimation(0, 0, fY, 0);
        translateAnimation.setInterpolator(new BounceInterpolator());
        AlphaAnimation mShowAnimation = new AlphaAnimation(0.0f, 1.0f);
        AnimationSet animSet = new AnimationSet(false);
        animSet.addAnimation(translateAnimation);
        animSet.addAnimation(mShowAnimation);
        animSet.setDuration(duration);
        animSet.setFillAfter(true);
        return animSet;
    }

    public static AnimatorSet videoAnimation(TextureView textureView, Activity activity) {
        Animator animatorAlpha = AnimatorInflater.loadAnimator(activity, R.animator.anim_alpha);
        Animator animatorScaleX = AnimatorInflater.loadAnimator(activity, R.animator.anim_scalex);
        Animator animatorScaleY = AnimatorInflater.loadAnimator(activity, R.animator.anim_scaley);
        AnimatorSet animSet = new AnimatorSet();

        animSet.play(animatorAlpha).with(animatorScaleX).with(animatorScaleY);//.after(moveIn);
        animSet.setInterpolator(new AccelerateInterpolator());
        animSet.setTarget(textureView);
        animSet.setDuration(800);
        return animSet;
    }

    public static AnimatorSet storyNameAnimation(View view, Activity activity) {
        return storyNameAnimation(view, activity, 1000);
    }

    public static AnimatorSet storyNameAnimation(View view, Activity activity, long duration) {
        Animator animatorAlpha = AnimatorInflater.loadAnimator(activity, R.animator.anim_alpha);
        Animator animatorScaleX = AnimatorInflater.loadAnimator(activity, R.animator.anim_story_scalex);
        Animator animatorScaleY = AnimatorInflater.loadAnimator(activity, R.animator.anim_story_scaley);
        AnimatorSet animSet = new AnimatorSet();
        animSet.play(animatorAlpha).with(animatorScaleX).with(animatorScaleY);
        animSet.setTarget(view);
        animSet.setDuration(duration);
        return animSet;
    }
}
