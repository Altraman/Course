package com.example.huqiang.course.ui.launcher;

import java.util.TimerTask;

public class BaseTimerTask extends TimerTask {
    private ITimer listener;

    public BaseTimerTask(ITimer listener) {
        this.listener = listener;
    }

    @Override
    public void run() {
        if (listener != null) {
            listener.onTime();
        }
    }
}
