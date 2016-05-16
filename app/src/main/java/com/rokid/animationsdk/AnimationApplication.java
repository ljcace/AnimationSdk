package com.rokid.animationsdk;

import android.app.Application;

/**
 * Created by lijiacheng on 16/5/16.
 */
public class AnimationApplication extends Application {
    public static AnimationApplication animationApplication = null;

    @Override
    public void onCreate() {
        super.onCreate();
        animationApplication = this;
    }

    public static AnimationApplication getInstance() {
        return animationApplication;
    }
}
