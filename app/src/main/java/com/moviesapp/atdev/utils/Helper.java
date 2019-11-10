package com.moviesapp.atdev.utils;

import android.content.res.Configuration;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;
import androidx.fragment.app.FragmentActivity;

import com.bumptech.glide.Glide;
import com.moviesapp.atdev.R;

public class Helper {


    public static int getScreenOrientation(FragmentActivity activity) {
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


    public static String getPostUrl(String path) {
        return Constants.IMAGE_POSTER_PATH + path;
    }

    @BindingAdapter("loadImage")
    public static void loadImage(ImageView view, String url) {

        Glide.with(view.getContext())
                .load(url)
                .placeholder(R.drawable.placeholder)
                .into(view);

    }
}
