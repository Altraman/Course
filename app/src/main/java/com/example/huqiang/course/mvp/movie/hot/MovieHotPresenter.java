package com.example.huqiang.course.mvp.movie.hot;

import com.example.huqiang.course.data.movie.Movie;
import com.example.huqiang.course.data.source.remote.MovieRemoteDataSource;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class MovieHotPresenter implements MovieHotContract.Presenter {

    private final MovieHotContract.View mView;
    private final MovieRemoteDataSource mDataSource;
    private final CompositeDisposable disposable;

    public MovieHotPresenter(MovieHotContract.View mView, MovieRemoteDataSource mDataSource) {
        this.mView = mView;
        this.mDataSource = mDataSource;
        this.mView.setPresenter(this);
        disposable = new CompositeDisposable();
    }


    @Override
    public void getHotMovie() {
        final Disposable d = mDataSource.getHotMovie()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<Movie>() {
                    @Override
                    public void onNext(Movie value) {
                        mView.showHotMovie(value.getSubjects());
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError();
                        mView.setLoadingIndicator(false);
                    }

                    @Override
                    public void onComplete() {
                        mView.setLoadingIndicator(false);
                    }
                });
        disposable.add(d);
    }

    @Override
    public void onSubscribe() {
        getHotMovie();
    }

    @Override
    public void unSubscribe() {
        disposable.clear();
    }
}
