package com.moviesapp.atdev.ui.moviedetails;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.moviesapp.atdev.pojo.models.CreditResponse;
import com.moviesapp.atdev.pojo.models.DetailsResponse;
import com.moviesapp.atdev.pojo.models.Movie;
import com.moviesapp.atdev.pojo.models.Videos;
import com.moviesapp.atdev.pojo.repos.RepoDetailsMovie;

import java.util.List;

public class DetailsMovieViewModel extends ViewModel {

    private MutableLiveData<CreditResponse> movieCredit;
    private MutableLiveData<DetailsResponse> movieDetail;
    private MutableLiveData<List<Movie>> similarMovies;
    private MutableLiveData<List<Movie>> recommendedMovies;
    private MutableLiveData<List<Videos>> movieVideos;


    public void init(Integer movieId) {

        RepoDetailsMovie mRepository = RepoDetailsMovie.getInstance(movieId);

        movieCredit = mRepository.getMovieCredit();
        movieDetail = mRepository.getMovieDetails();
        similarMovies = mRepository.getSimilarMovies();
        recommendedMovies = mRepository.getRecommendedMovies();
        movieVideos = mRepository.getMovieVideos();
    }

    MutableLiveData<CreditResponse> getMovieCredit() {
        return movieCredit;
    }

    MutableLiveData<DetailsResponse> getMovieDetails() {
        return movieDetail;
    }

    MutableLiveData<List<Movie>> getSimilarMovies() {
        return similarMovies;
    }

    MutableLiveData<List<Movie>> getRecommendedMovies() {
        return recommendedMovies;
    }

    MutableLiveData<List<Videos>> getMovieVideos() {
        return movieVideos;
    }
}
