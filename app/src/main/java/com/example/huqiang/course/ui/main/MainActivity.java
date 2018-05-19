package com.example.huqiang.course.ui.main;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.huqiang.course.R;
import com.example.huqiang.course.mvp.book.BookFragment;
import com.example.huqiang.course.mvp.movie.MovieFragment;
import com.example.huqiang.course.mvp.music.MusicFragment;

import java.util.LinkedList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.rg_main)
    RadioGroup mRgMain;
    @BindView(R.id.tb_main)
    Toolbar mTbMain;
    @BindView(R.id.vp_main)
    ViewPager mVpMain;

    private int mCurrentItem = 0;

    private static final long WAIT_TIME = 2000L;
    private static long TOUCH_TIME;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initToolBar();
        initRadioGroup();
        initViewPager();
    }

    private void initRadioGroup() {
        mRgMain.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int checkId) {
                switch (checkId) {
                    case R.id.rb_movie:
                        mCurrentItem = 0;
                        break;
                    case R.id.rb_book:
                        mCurrentItem = 1;
                        break;
                    case R.id.rb_music:
                        mCurrentItem = 2;
                        break;
                    default:
                        break;
                }
                mVpMain.setCurrentItem(mCurrentItem, false);
            }
        });
    }

    private void initToolBar() {
        setSupportActionBar(mTbMain);
        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(false);
        }
    }

    private void initViewPager() {
        final LinkedList<Fragment> fragments = new LinkedList<>();
        fragments.add(MovieFragment.newInstance());
        fragments.add(BookFragment.newInstance());
        fragments.add(MusicFragment.newInstance());

        final MainViewPagerAdapter adapter = new MainViewPagerAdapter(getSupportFragmentManager(), fragments);
        mVpMain.setAdapter(adapter);
        mVpMain.setOffscreenPageLimit(3);

        mVpMain.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        mRgMain.check(R.id.rb_movie);
                        break;
                    case 1:
                        mRgMain.check(R.id.rb_book);
                        break;
                    case 2:
                        mRgMain.check(R.id.rb_music);
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void onBackPressed() {
        if (System.currentTimeMillis() - TOUCH_TIME < WAIT_TIME) {
            finish();
        } else {
            TOUCH_TIME = System.currentTimeMillis();
            Toast.makeText(this, "再按一次退出" + getString(R.string.app_name), Toast.LENGTH_SHORT).show();
        }
    }
}
