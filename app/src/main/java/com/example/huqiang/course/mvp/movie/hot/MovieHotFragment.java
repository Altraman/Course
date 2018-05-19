package com.example.huqiang.course.mvp.movie.hot;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.huqiang.course.MyApplication;
import com.example.huqiang.course.R;
import com.example.huqiang.course.data.movie.Subject;
import com.example.huqiang.course.data.source.remote.MovieRemoteDataSource;
import com.example.huqiang.course.interfaze.OnRecyclerViewItemClickListener;
import com.example.huqiang.course.utils.ScreenUtils;
import com.example.huqiang.course.widgets.SpacesItemDecorate;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class MovieHotFragment extends Fragment implements MovieHotContract.View, OnRecyclerViewItemClickListener {

    @BindView(R.id.rv_hot_movie)
    RecyclerView mRvHotMovie;
    @BindView(R.id.sw_hot_movie)
    SwipeRefreshLayout mSwHotMovie;

    private MovieHotContract.Presenter presenter;
    Unbinder unbinder;

    public static MovieHotFragment newInstance() {
        return new MovieHotFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_movie_hot, container, false);
        new MovieHotPresenter(this, MovieRemoteDataSource.getInstance());
        initView(view);
        return view;
    }

    private void initRecyclerView() {
        final GridLayoutManager manager = new GridLayoutManager(getContext(), 3);
        mRvHotMovie.setLayoutManager(manager);

        final SpacesItemDecorate decorate = new SpacesItemDecorate(ScreenUtils.dipToPx(10), ScreenUtils.dipToPx(10),
                ScreenUtils.dipToPx(10), 0);
        mRvHotMovie.addItemDecoration(decorate);
    }

    private void initRefreshLayout() {
        mSwHotMovie.setColorSchemeColors(MyApplication.getContext().getResources()
                .getColor(R.color.colorPrimary));
        mSwHotMovie.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                presenter.getHotMovie();
            }
        });
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initRefreshLayout();
        initRecyclerView();
        mSwHotMovie.setRefreshing(true);
        presenter.onSubscribe();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onPause() {
        super.onPause();
        presenter.unSubscribe();
    }

    @Override
    public void showError() {
        Toast.makeText(getContext(), "网络出错了", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setLoadingIndicator(final boolean active) {
        mSwHotMovie.post(new Runnable() {
            @Override
            public void run() {
                mSwHotMovie.setRefreshing(active);
            }
        });
    }

    @Override
    public void showHotMovie(List<Subject> subjects) {
        final MovieHotAdapter adapter = new MovieHotAdapter(getContext(), subjects);
        mRvHotMovie.setAdapter(adapter);
        adapter.setListener(this);
    }

    @Override
    public void initView(View view) {
        unbinder = ButterKnife.bind(this, view);
    }

    @Override
    public void setPresenter(MovieHotContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void onItemClick(View view, int position) {
        Log.d("--------", String.valueOf(position));
    }
}
