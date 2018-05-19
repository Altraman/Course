package com.example.huqiang.course.mvp.movie.top;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.huqiang.course.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MovieTopFragment extends Fragment {


    public static MovieTopFragment newInstance() {
        return new MovieTopFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie_top, container, false);
    }

}
