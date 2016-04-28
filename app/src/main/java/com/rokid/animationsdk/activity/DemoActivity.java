package com.rokid.animationsdk.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.rokid.animationsdk.R;
import com.rokid.library.interfaces.AnimCallbackInterface;
import com.rokid.library.util.AnimationUtil;

/**
 * Created by Administrator on 2016/4/27 0027.
 */
public class DemoActivity extends Activity {
    private ImageView iv;
    private TextView tv, tv_1, tv_2, tv_3, tv_4, tv_5, tv_6, tv_show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_demo);

        iv = (ImageView) findViewById(R.id.iv);

        tv = (TextView) findViewById(R.id.tv);

        tv_1 = (TextView) findViewById(R.id.tv_1);
        tv_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv.clearAnimation();
                AnimationUtil.searchAnimation(iv);
            }
        });
        tv_2 = (TextView) findViewById(R.id.tv_2);
        tv_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.clearAnimation();
                AnimationUtil.storyNameAnimation(tv, DemoActivity.this).start();
            }
        });
        tv_3 = (TextView) findViewById(R.id.tv_3);
        tv_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.clearAnimation();
                tv.startAnimation(AnimationUtil.textYTransShowAnimation(1000));
            }
        });
        tv_4 = (TextView) findViewById(R.id.tv_4);
        tv_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.clearAnimation();
                new AnimationUtil.Builder()
                        .context(DemoActivity.this)
                        .view(tv)
                        .duration(2000)
                        .fillAfter(true)
                        .callBack(new AnimCallbackInterface() {
                            @Override
                            public void CallBack(boolean isEnd) {
                                Log.e("test", isEnd + "");
                            }
                        })
                        .Anim3DRotation()
                        .startAnimation();
            }
        });
        tv_5 = (TextView) findViewById(R.id.tv_5);
        tv_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.clearAnimation();
                new AnimationUtil.Builder()
                        .context(DemoActivity.this)
                        .view(tv)
                        .duration(2000)
                        .fillAfter(true)
                        .callBack(new AnimCallbackInterface() {
                            @Override
                            public void CallBack(boolean isEnd) {
                                Log.e("test", isEnd + "");
                            }
                        })
                        .rotateAnimation(360f, 270f)
                        .startAnimation();
            }
        });
        tv_6 = (TextView) findViewById(R.id.tv_6);
        tv_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.clearAnimation();
                new AnimationUtil.Builder()
                        .context(DemoActivity.this)
                        .view(tv)
                        .duration(2000)
                        .fillAfter(true)
                        .callBack(new AnimCallbackInterface() {
                            @Override
                            public void CallBack(boolean isEnd) {
                                Log.e("test", isEnd + "");
                            }
                        })
                        .rotateAnimation(0f, 90f)
                        .startAnimation();
            }
        });
        tv_show = (TextView) findViewById(R.id.tv_show);
        tv_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(DemoActivity.this, ShowActivity.class);
                startActivity(it);
            }
        });
    }

}
