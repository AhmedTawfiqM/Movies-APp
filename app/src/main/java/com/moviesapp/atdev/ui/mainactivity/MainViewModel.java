package com.moviesapp.atdev.ui.mainactivity;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.moviesapp.atdev.utils.Constants;

public class MainViewModel extends ViewModel {


    private MutableLiveData<String> categoryLiveData;

    public MainViewModel() {

        categoryLiveData = new MutableLiveData<>();
    }

    public LiveData<String> getCategory() {

        if (categoryLiveData.getValue() == null) {
            categoryLiveData.setValue(Constants.now_playing);
        }
        return categoryLiveData;
    }

    public void setCategory(String category) {
        this.categoryLiveData.setValue(category);
        Log.d("MainActivity", "setCategory: in view model " + category);
    }
}
