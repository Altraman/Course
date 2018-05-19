package com.example.huqiang.course.mvp.movie;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.huqiang.course.R;
import com.example.huqiang.course.mvp.movie.hot.MovieHotFragment;
import com.example.huqiang.course.mvp.movie.top.MovieTopFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class MovieFragment extends Fragment {


    @BindView(R.id.tab_movie)
    TabLayout mTabMovie;
    @BindView(R.id.vw_movie)
    ViewPager mVwMovie;
    Unbinder unbinder;

    public static MovieFragment newInstance() {
        return new MovieFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_movie, container, false);
        unbinder = ButterKnife.bind(this, view);
        initViewPager();
        initTabLayout();
        return view;
    }

    private void initTabLayout() {
        mTabMovie.setupWithViewPager(mVwMovie);
    }

    private void initViewPager() {
        final List<Fragment> fragments = new ArrayList<>();
        fragments.add(MovieHotFragment.newInstance());
        fragments.add(MovieTopFragment.newInstance());

        final String[] titles = {"热销榜", "TOP250"};

        final MovieViewPagerAdapter adapter = new MovieViewPagerAdapter(getChildFragmentManager(), fragments, titles);
        mVwMovie.setAdapter(adapter);
        mVwMovie.setOffscreenPageLimit(2);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
