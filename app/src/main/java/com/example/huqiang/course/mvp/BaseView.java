package com.example.huqiang.course.mvp;

import android.view.View;

public interface BaseView<T extends BasePresenter> {
    void initView(View view);

    void setPresenter(T presenter);
}
