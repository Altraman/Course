package com.example.huqiang.course.utils;

import android.content.res.Resources;
import android.util.DisplayMetrics;

import com.example.huqiang.course.MyApplication;

public class ScreenUtils {
    public static int getScreenWidth() {
        final Resources resources = MyApplication.getContext().getResources();
        final DisplayMetrics dm = resources.getDisplayMetrics();
        return dm.widthPixels;
    }

    public static int getScreenHeight() {
        final Resources resources = MyApplication.getContext().getResources();
        final DisplayMetrics dm = resources.getDisplayMetrics();
        return dm.heightPixels;
    }

    private static float getScreenDensity() {
        final Resources resources = MyApplication.getContext().getResources();
        final DisplayMetrics dm = resources.getDisplayMetrics();
        return dm.density;
    }

    public static int dipToPx(int dip) {
        return (int) (dip * getScreenDensity() + 0.5f);
    }
}
