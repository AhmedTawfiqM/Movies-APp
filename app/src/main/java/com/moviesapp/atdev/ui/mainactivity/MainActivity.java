package com.moviesapp.atdev.ui.mainactivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.moviesapp.atdev.R;
import com.moviesapp.atdev.databinding.ActivityMainBinding;
import com.moviesapp.atdev.ui.mainfragment.FragmentMovies;
import com.moviesapp.atdev.utils.Constants;

import static com.moviesapp.atdev.utils.Constants.Type_Category;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    //Vars
    ActivityMainBinding binding;
    BottomNavigationView bottomNavigationView;
    Toolbar toolbar;
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    //
    MainViewModel mainViewModel;
    //

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        //
        InitUI();
        SetBottomNavigationListener();

        //
//        if (savedInstanceState == null) {
//            navigateToFragment(Constants.now_playing);
//        }

        mainViewModel.getCategory().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String category) {

                //
                navigateToFragmentByCategory(category);
            }

        });

    }

    private void SetBottomNavigationListener() {

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                Log.d(TAG, "onNavigationItemSelected: Called " + menuItem.getTitle());
                switch (menuItem.getItemId()) {

                    case R.id.bottom_nav_nowPlaying:
                        mainViewModel.setCategory(Constants.now_playing);
                        break;
                    case R.id.bottom_nav_popular:
                        mainViewModel.setCategory(Constants.popular);
                        break;
                    case R.id.bottom_nav_topRated:
                        mainViewModel.setCategory(Constants.top_rated);
                        break;
                    case R.id.bottom_nav_upcoming:
                        mainViewModel.setCategory(Constants.upcoming);
                        break;
                    //
                    default:
                        mainViewModel.setCategory(Constants.now_playing);
                        break;

                }


                return true;
            }
        });
    }


    private void navigateToFragmentByCategory(String category) {


        //
        Bundle bundle = new Bundle();
        bundle.putString(Type_Category, category);

        //
        FragmentMovies fragmentMovies = new FragmentMovies();
        fragmentMovies.setArguments(bundle);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,
                fragmentMovies,
                "tag")
                .commit();
    }

    private void InitUI() {

        bottomNavigationView = binding.mainBottomNavigationView;
        toolbar = binding.mainToolBar;
        navigationView = binding.mainNavigationView;
        drawerLayout = binding.drawerLayout;

        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
    }
}
