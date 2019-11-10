package com.moviesapp.atdev.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.databinding.BindingAdapter;
import androidx.fragment.app.FragmentActivity;

import com.bumptech.glide.Glide;
import com.google.android.material.snackbar.Snackbar;
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



    public static void showSnackBarNoInternet(Activity activity){
        Snackbar.make(activity.findViewById(android.R.id.content),
                "You currently have limited or no connectivity. Try connecting to a Wi-Fi network.", Snackbar.LENGTH_LONG).show();
    }

    public static void showToast(Context context, String toastMessage){
        Toast.makeText(context, ""+toastMessage, Toast.LENGTH_SHORT).show();
    }


    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE));
        return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnected();
    }
}
