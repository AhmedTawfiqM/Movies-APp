package com.moviesapp.atdev.utils;

import android.content.res.Configuration;

import androidx.fragment.app.FragmentActivity;

public class Helper {


    public static int getScreenOrientation(FragmentActivity activity){
        int spanCount = 0;
        if (activity.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            spanCount = 2;
        } else if (activity.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            spanCount = 4;
        } else if ((activity.getResources().getConfiguration().screenLayout
                & Configuration.SCREENLAYOUT_SIZE_MASK) >= Configuration.SCREENLAYOUT_SIZE_XLARGE) {
            spanCount = 5;
        }
        return spanCount;
    }
}
