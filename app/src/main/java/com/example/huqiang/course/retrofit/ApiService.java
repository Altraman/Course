package com.example.huqiang.course.retrofit;

import com.example.huqiang.course.data.movie.Movie;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {
    @GET(Api.HOT_MOVIE)
    Observable<Movie> getHotMovie();

//    @GET(Api.HOT_MOVIE)
//    Observable<Movie> getTop(@Query("start") String start, @Query("count") String count);
//
//    @GET(Api.HOT_MOVIE)
//    Observable<Movie> get(@Path("id") String id);
}
