package com.example.huqiang.course.data;

import com.example.huqiang.course.data.movie.Movie;

import io.reactivex.Observable;

public interface MovieDataSource {
    Observable<Movie> getHotMovie();
}
