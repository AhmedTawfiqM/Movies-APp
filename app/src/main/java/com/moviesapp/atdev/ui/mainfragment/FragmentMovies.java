package com.moviesapp.atdev.ui.mainfragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.moviesapp.atdev.R;
import com.moviesapp.atdev.databinding.FragmentMainMoviesBinding;
import com.moviesapp.atdev.pojo.models.MovieResponse;
import com.moviesapp.atdev.pojo.network.APIClient;
import com.moviesapp.atdev.pojo.network.component.DaggerNetworkComp;
import com.moviesapp.atdev.pojo.network.component.NetworkComp;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentMovies extends Fragment {

    public static final String TAG = "FragmentMovies";

    //Vars
    private FragmentMainMoviesBinding binding;
    private NetworkComp daggernetworkcomp;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main_movies, container, false);
        //Log.d(TAG, "onViewCreated: Called in "+TAG);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        InitUI();

        APIClient apiClient = daggernetworkcomp.getApiClient();
        apiClient.getMovies("now_playing", 1).enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {

                Log.d("testa", "onResponse: " + response.body().getMovies());
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {

            }
        });

    }

    private void InitUI() {

        daggernetworkcomp = DaggerNetworkComp.create();
    }
}
