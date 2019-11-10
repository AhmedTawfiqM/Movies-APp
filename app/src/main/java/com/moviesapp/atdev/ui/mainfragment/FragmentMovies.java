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
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.moviesapp.atdev.R;
import com.moviesapp.atdev.databinding.FragmentMainMoviesBinding;
import com.moviesapp.atdev.pojo.adapters.AdapterMovies;
import com.moviesapp.atdev.pojo.models.Movie;
import com.moviesapp.atdev.pojo.models.MovieResponse;
import com.moviesapp.atdev.pojo.network.APIClient;
import com.moviesapp.atdev.pojo.network.component.DaggerNetworkComp;
import com.moviesapp.atdev.pojo.network.component.NetworkComp;
import com.moviesapp.atdev.utils.Constants;
import com.moviesapp.atdev.utils.Helper;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentMovies extends Fragment {

    public static final String TAG = "FragmentMovies";

    //Vars
    private FragmentMainMoviesBinding binding;
    private RecyclerView recyclerView;
    private MoviesViewModel viewModel;
    private AdapterMovies adapterMovies;

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

        viewModel.getMovies(Constants.now_playing).observe(this, new Observer<PagedList<Movie>>() {
            @Override
            public void onChanged(PagedList<Movie> movies) {

                if (movies != null) {
                    adapterMovies.submitList(movies);
                }
            }
        });
        recyclerView.setAdapter(adapterMovies);

    }

    private void InitUI() {

        viewModel = ViewModelProviders.of(this).get(MoviesViewModel.class);
        //
        adapterMovies = new AdapterMovies(getActivity());

        //  Initila
        recyclerView = binding.recyclerviewMovies;
        int spanCount = Helper.getScreenOrientation(getActivity());
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), spanCount));
    }

}
