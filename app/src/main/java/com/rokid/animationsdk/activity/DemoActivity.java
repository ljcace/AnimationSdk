package com.rokid.animationsdk.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.rokid.animationsdk.R;
import com.rokid.animationsdk.interfaces.AnimCallbackInterface;
import com.rokid.animationsdk.util.AnimationUtil;

/**
 * Created by Administrator on 2016/4/27 0027.
 */
public class DemoActivity extends Activity {
    private TextView tv, click;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_demo);

        tv = (TextView) findViewById(R.id.tv);
        click = (TextView) findViewById(R.id.click);
        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.clearAnimation();
                new AnimationUtil.Builder()
                        .view(tv)
                        .duration(2000)
                        .fillAfter(true)
                        .callBack(new AnimCallbackInterface() {
                            @Override
                            public void CallBack(boolean isEnd) {
                                Log.e("test", isEnd + "");
                            }
                        })
                        .hideAnimation()
                        .translateAnimation(0, 100, 0, -200)
//                        .rotateAnimation()
                        .startAnimation();
            }
        });
    }
}
