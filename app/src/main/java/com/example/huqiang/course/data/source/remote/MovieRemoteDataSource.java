package com.example.huqiang.course.data.source.remote;

import com.example.huqiang.course.data.MovieDataSource;
import com.example.huqiang.course.data.movie.Movie;
import com.example.huqiang.course.retrofit.ApiService;
import com.example.huqiang.course.retrofit.RetrofitClient;

import io.reactivex.Observable;

public class MovieRemoteDataSource implements MovieDataSource {
    private static MovieRemoteDataSource mDataSource;

    public static MovieRemoteDataSource getInstance() {
        if (mDataSource == null) {
            mDataSource = new MovieRemoteDataSource();
        }
        return mDataSource;
    }

    @Override
    public Observable<Movie> getHotMovie() {
        return RetrofitClient.getInstance()
                .create(ApiService.class)
                .getHotMovie();
    }
}
