package com.moviesapp.atdev.ui.mainactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.util.Log;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.moviesapp.atdev.R;
import com.moviesapp.atdev.databinding.ActivityMainBinding;
import com.moviesapp.atdev.ui.mainfragment.FragmentMovies;

public class MainActivity extends AppCompatActivity {

    private static final String TAG ="MainActivity" ;
    //Vars
    ActivityMainBinding binding;
    BottomNavigationView bottomNavigationView;
    Toolbar toolbar;
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    //

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        Log.d(TAG, "onViewCreated: Called in "+TAG);
        InitUI();

        //
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new FragmentMovies(), "movies")
                    .commit();
        }



    }

    private void InitUI() {

        bottomNavigationView = binding.mainBottomNavigationView;
        toolbar = binding.mainToolBar;
        navigationView = binding.mainNavigationView;
        drawerLayout = binding.drawerLayout;

    }
}
