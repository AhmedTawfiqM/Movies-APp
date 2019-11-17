package com.moviesapp.atdev.pojo.repos;

import androidx.lifecycle.MutableLiveData;

import com.moviesapp.atdev.pojo.models.CreditResponse;
import com.moviesapp.atdev.pojo.models.DetailsResponse;
import com.moviesapp.atdev.pojo.models.Movie;
import com.moviesapp.atdev.pojo.models.MovieResponse;
import com.moviesapp.atdev.pojo.models.MovieVideos;
import com.moviesapp.atdev.pojo.models.Videos;
import com.moviesapp.atdev.pojo.network.component.DaggerNetworkComp;
import com.moviesapp.atdev.pojo.network.component.NetworkComp;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RepoDetailsMovie {

    private static Integer movieId;
    private MutableLiveData<CreditResponse> movieCredit = new MutableLiveData<>();
    private MutableLiveData<DetailsResponse> movieDetail = new MutableLiveData<>();
    private MutableLiveData<List<Movie>> similarMovies = new MutableLiveData<>();
    private MutableLiveData<List<Movie>> recommendedMovies = new MutableLiveData<>();
    private MutableLiveData<List<Videos>> movieVideos = new MutableLiveData<>();
    private NetworkComp networkComp = DaggerNetworkComp.create();


    static RepoDetailsMovie getInstance(Integer MmovieId) {
        movieId = MmovieId;
        return new RepoDetailsMovie();
    }

    MutableLiveData<CreditResponse> getMovieCredit() {

        networkComp.getApiClient()
                .getMovieCreditsResponse(movieId)
                .enqueue(new Callback<CreditResponse>() {
                    @Override
                    public void onResponse(Call<CreditResponse> call, Response<CreditResponse> response) {

                        if (response.body() != null) {
                            movieCredit.setValue(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<CreditResponse> call, Throwable t) {

                    }
                });

        return movieCredit;
    }

    MutableLiveData<DetailsResponse> getMovieDetails() {

        networkComp.getApiClient()
                .getMovieDetails(movieId)
                .enqueue(new Callback<DetailsResponse>() {
                    @Override
                    public void onResponse(Call<DetailsResponse> call, Response<DetailsResponse> response) {

                        if (response.body() != null) {
                            movieDetail.setValue(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<DetailsResponse> call, Throwable t) {

                    }
                });

        return movieDetail;
    }

    MutableLiveData<List<Movie>> getSimilarMovies() {

        networkComp.getApiClient()
                .getSimilarResponse(movieId)
                .enqueue(new Callback<MovieResponse>() {
                    @Override
                    public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                        if (response.body() != null) {
                            similarMovies.setValue(response.body().getMovies());
                        }
                    }

                    @Override
                    public void onFailure(Call<MovieResponse> call, Throwable t) {

                    }
                });
        return similarMovies;
    }

    MutableLiveData<List<Movie>> getRecommendedMovies() {

        networkComp.getApiClient()
                .getRecommendationResponse(movieId)
                .enqueue(new Callback<MovieResponse>() {
                    @Override
                    public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {

                        if (response.body() != null) {
                            recommendedMovies.setValue(response.body().getMovies());
                        }
                    }

                    @Override
                    public void onFailure(Call<MovieResponse> call, Throwable t) {

                    }
                });
        return recommendedMovies;
    }

    MutableLiveData<List<Videos>> getMovieVideos() {

        networkComp.getApiClient()
                .getMovieVideosResponse(movieId)
                .enqueue(new Callback<MovieVideos>() {
                    @Override
                    public void onResponse(Call<MovieVideos> call, Response<MovieVideos> response) {

                        if (response.body() != null) {
                            movieVideos.setValue(response.body().getVideos());
                        }
                    }

                    @Override
                    public void onFailure(Call<MovieVideos> call, Throwable t) {

                    }
                });
        return movieVideos;
    }
}
