package com.example.huqiang.course.ui.launcher;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatTextView;

import com.example.huqiang.course.R;
import com.example.huqiang.course.ui.main.MainActivity;

import java.text.MessageFormat;
import java.util.Timer;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import qiu.niorgai.StatusBarCompat;

public class LauncherActivity extends AppCompatActivity implements ITimer {

    @BindView(R.id.tv_launcher)
    AppCompatTextView mTvLauncher;

    private Timer mTimer = null;
    private int mCounts = 5;

    private final static Handler mHandler = new Handler();

    @OnClick(R.id.tv_launcher)
    public void onTimerClick() {
        if (mTimer != null) {
            mTimer.cancel();
            mTimer = null;
            goToMain();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
        ButterKnife.bind(this);
        StatusBarCompat.translucentStatusBar(this, true);
        initTimer();
    }

    private void initTimer() {
        mTimer = new Timer();
        final BaseTimerTask task = new BaseTimerTask(this);
        mTimer.schedule(task, 0, 1000);
    }

    private void goToMain() {
        final Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        finish();
    }

    @Override
    public void onTime() {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                if (mTimer != null) {
                    mTvLauncher.setText(MessageFormat.format("跳过\n{0}s", mCounts));
                    mCounts--;
                    if (mCounts < 0) {
                        mTimer.cancel();
                        mTimer = null;
                        goToMain();
                    }
                }
            }
        });
    }
}
