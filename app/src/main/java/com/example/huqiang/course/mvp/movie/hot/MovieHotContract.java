package com.example.huqiang.course.mvp.movie.hot;

import com.example.huqiang.course.data.movie.Subject;
import com.example.huqiang.course.mvp.BasePresenter;
import com.example.huqiang.course.mvp.BaseView;

import java.util.List;

public interface MovieHotContract {
    interface Presenter extends BasePresenter {
        void getHotMovie();
    }

    interface View extends BaseView<Presenter> {
        void showError();

        void setLoadingIndicator(boolean active);

        void showHotMovie(List<Subject> subjects);
    }
}
