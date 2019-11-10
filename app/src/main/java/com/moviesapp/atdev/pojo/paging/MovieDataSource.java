package com.moviesapp.atdev.pojo.paging;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.paging.PageKeyedDataSource;

import com.moviesapp.atdev.pojo.models.Movie;
import com.moviesapp.atdev.pojo.models.MovieResponse;
import com.moviesapp.atdev.pojo.network.APIClient;
import com.moviesapp.atdev.pojo.network.component.DaggerNetworkComp;
import com.moviesapp.atdev.pojo.network.component.NetworkComp;
import com.moviesapp.atdev.utils.Constants;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieDataSource extends PageKeyedDataSource<Integer, Movie> {

    private String categery;
    private APIClient apiClient;

    public MovieDataSource(String categery) {
        this.categery = categery;
        apiClient = DaggerNetworkComp.create().getApiClient();
    }

    // first Page
    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull final LoadInitialCallback<Integer, Movie> callback) {

        apiClient.getMovies(categery, Constants.FIRST_PAGE)
                .enqueue(new Callback<MovieResponse>() {
                    @Override
                    public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {

                        if (response.body() != null) {
                            callback.onResult(response.body().getMovies(), null, Constants.FIRST_PAGE);
                        }
                    }

                    @Override
                    public void onFailure(Call<MovieResponse> call, Throwable t) {

                        Log.d("CallF", "onFailure:loadInitial " + t.getMessage());
                    }
                });
    }

    // Before Page  // Previous Page
    @Override
    public void loadBefore(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, Movie> callback) {

    }


    // Load After SCrolling
    // Second Page //Next Page
    @Override
    public void loadAfter(@NonNull final LoadParams<Integer> params, @NonNull final LoadCallback<Integer, Movie> callback) {

        apiClient.getMovies(categery, params.key)
                .enqueue(new Callback<MovieResponse>() {
                    @Override
                    public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {


                        if (response.body() != null) {
                            Integer key = (params.key <= response.body().getTotalPages()) ? params.key + 1 : null;
                            callback.onResult(response.body().getMovies(), key);
                        }

                    }

                    @Override
                    public void onFailure(Call<MovieResponse> call, Throwable t) {
                        Log.d("CallF", "onFailure: loadAfter " + t.getMessage());
                    }
                });

    }
}
