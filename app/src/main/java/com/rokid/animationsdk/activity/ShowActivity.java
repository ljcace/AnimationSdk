package com.rokid.animationsdk.activity;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.rokid.animationsdk.R;
import com.rokid.library.interfaces.AnimCallbackInterface;
import com.rokid.library.util.AnimationUtil;

/**
 * Created by Administrator on 2016/4/27 0027.
 */
public class ShowActivity extends Activity {
    private ImageView iv_search;
    private TextView tv_story_type, tv_story_name, tv_story_no;
    private LinearLayout ll_story;
    private VideoView vv_player;

    private float cX, cY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_show);
        InitView();
        refresh();
    }

    private void InitView() {
        ll_story = (LinearLayout) findViewById(R.id.ll_story);

        iv_search = (ImageView) findViewById(R.id.iv_search);

        tv_story_type = (TextView) findViewById(R.id.tv_story_type);
        tv_story_name = (TextView) findViewById(R.id.tv_story_name);
        tv_story_no = (TextView) findViewById(R.id.tv_story_no);

        vv_player = (VideoView) findViewById(R.id.vv_player);
    }

    private void refresh() {
        final AnimationDrawable search = AnimationUtil.searchAnimation(iv_search);
        search.start();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                search.stop();
                iv_search.clearAnimation();
                new AnimationUtil.Builder()
                        .context(ShowActivity.this)
                        .fillAfter(true)
                        .duration(500)
                        .view(iv_search)
                        .callBack(new AnimCallbackInterface() {
                            @Override
                            public void CallBack(boolean isEnd) {
                                if (isEnd)
                                    nextRotate();
                            }
                        })
                        .rotateAnimation(360f, 270f)
                        .startAnimation();
                cX = iv_search.getWidth() / 2;
                cY = iv_search.getHeight() / 2;
            }
        }, 4000);
    }

    private void nextRotate() {
        iv_search.clearAnimation();
        new AnimationUtil.Builder()
                .context(ShowActivity.this)
                .fillAfter(true)
                .duration(500)
                .view(iv_search)
                .callBack(new AnimCallbackInterface() {
                    @Override
                    public void CallBack(boolean isEnd) {
                        if (isEnd)
                            showStoryType();
                        else
                            iv_search.setImageResource(R.mipmap.b_07);
                    }
                })
                .rotateAnimation(cX, cY, 270f, 180f)
                .startAnimation();
    }

    private void showStoryType() {
        tv_story_type.clearAnimation();
        AnimationSet animSet = AnimationUtil.textYTransShowAnimation(1000);
        animSet.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                showStoryNo();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        tv_story_type.startAnimation(animSet);
        tv_story_type.setVisibility(View.VISIBLE);
    }

    private void showStoryNo() {
        tv_story_no.clearAnimation();
        AnimatorSet animSet = AnimationUtil.storyNameAnimation(tv_story_no, ShowActivity.this, 500);
        animSet.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                showStoryNname();
                UnShow(iv_search);
                UnShow(tv_story_type);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        animSet.start();
        tv_story_no.setVisibility(View.VISIBLE);
    }

    private void showStoryNname() {
        tv_story_name.clearAnimation();
        AnimatorSet animSet = AnimationUtil.storyNameAnimation(tv_story_name, ShowActivity.this, 500);
        animSet.start();
        tv_story_name.setVisibility(View.VISIBLE);
    }

    private void UnShow(View view) {
        view.clearAnimation();
        new AnimationUtil.Builder()
                .context(ShowActivity.this)
                .view(view)
                .fillAfter(true)
                .duration(500)
                .callBack(new AnimCallbackInterface() {
                    @Override
                    public void CallBack(final boolean isEnd) {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                if (isEnd)
                                    if (ll_story.isShown()) {
                                        UnShow(ll_story);
                                        ll_story.setVisibility(View.GONE);
                                    } else {
                                        vv_player.setVisibility(View.VISIBLE);
                                        playVideo();
                                    }
                            }
                        }, 500);
                    }
                })
                .hideAnimation()
                .startAnimation();
    }

    private void playVideo() {
        vv_player.setVideoURI(Uri.parse("android.resource://com.rokid.animationsdk/" + R.raw.video_day));

        /**
         * w为其提供一个控制器，控制其暂停、播放……等功能
         */
        vv_player.setMediaController(new MediaController(this));

        /**
         * 视频或者音频到结尾时触发的方法
         */
        vv_player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Log.i("通知", "完成");
            }
        });

        vv_player.setOnErrorListener(new MediaPlayer.OnErrorListener() {

            @Override
            public boolean onError(MediaPlayer mp, int what, int extra) {
                Log.i("通知", "播放中出现错误");
                return false;
            }
        });
        vv_player.start();
    }
}
