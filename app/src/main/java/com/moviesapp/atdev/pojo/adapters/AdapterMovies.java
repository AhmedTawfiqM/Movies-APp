package com.moviesapp.atdev.pojo.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.moviesapp.atdev.R;
import com.moviesapp.atdev.databinding.MovieItemBinding;
import com.moviesapp.atdev.pojo.models.Movie;
import com.moviesapp.atdev.utils.ClickListener;

public class AdapterMovies extends PagedListAdapter<Movie, AdapterMovies.MovieViewHolder> {

    //Vars
    private Context context;
    private static ClickListener clickListener;

    public AdapterMovies(Context context) {
        super(diffCallback);
        this.context = context;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        MovieItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.single_movie_item, parent, false);

        return new MovieViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {

        Movie movie = getItem(position);
        if (movie != null)
            holder.bindMovie(movie);
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        MovieItemBinding itemBinding;

        public MovieViewHolder(MovieItemBinding movieItemBinding) {
            super(movieItemBinding.getRoot());
            this.itemBinding = movieItemBinding;
            itemView.setOnClickListener(this);
        }

        void bindMovie(Movie movie) {
            itemBinding.setMovie(movie);
        }


        @Override
        public void onClick(View view) {

            clickListener.OnItemClick(getAdapterPosition(), view);
        }


    }


    public void setOnItemClickListner(ClickListener clickListner) {
        clickListener = clickListner;
    }
    //
    private static DiffUtil.ItemCallback<Movie> diffCallback =
            new DiffUtil.ItemCallback<Movie>() {
                @Override
                public boolean areItemsTheSame(@NonNull Movie oldMovie, @NonNull Movie newMovie) {
                    return oldMovie.getId().equals(newMovie.getId());
                }

                @SuppressLint("DiffUtilEquals")
                @Override
                public boolean areContentsTheSame(@NonNull Movie oldMovie, @NonNull Movie newMovie) {
                    return oldMovie.equals(newMovie);
                }
            };
}
