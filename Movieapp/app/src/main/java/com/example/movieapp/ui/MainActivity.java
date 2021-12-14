package com.example.movieapp.ui;



import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.movieapp.R;
import com.example.movieapp.databinding.ActivityMainBinding;
import com.example.movieapp.ui.movies.MovieFragment;
import com.example.movieapp.ui.settings.SettingsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    private static final String FRAG_TAG_SETTINGS ="frag-settings" ;
    private FragmentManager fragmentManager;
    private Fragment fragment = null;
    public static final String FRAG_TAG_POPULAR = "frag-popular";
    public static final String FRAG_TAG_TOP_RATED = "frag-top-rated";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.bottomNavigation.setOnNavigationItemSelectedListener(this);

        fragmentManager = getSupportFragmentManager();
        loadPopularMoviesFragment();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_popular:
                loadPopularMoviesFragment();
                return true;
            case R.id.action_top_rated:
                loadTopRatedMoviesFragment();
                return true;
            case R.id.action_settings:
                loadSettingsFragment();
                return true;
        }
        return false;
    }

    private void loadSettingsFragment() {
        fragment = fragmentManager.findFragmentByTag(FRAG_TAG_SETTINGS);
        if (fragment != null) {
            //if fragment already exists, show the fragment
            fragmentManager.beginTransaction().show(fragment).commit();
        } else {
            //if it doesn't exists, create and add the fragment
            fragmentManager.beginTransaction().add(R.id.fragment_container, new SettingsFragment(), FRAG_TAG_SETTINGS).commit();
        }
        //hide rest of the fragments if they exist
        hideFragments(FRAG_TAG_TOP_RATED,FRAG_TAG_POPULAR);
    }

    private void loadPopularMoviesFragment() {
        fragment = fragmentManager.findFragmentByTag(FRAG_TAG_POPULAR);
        if (fragment != null) {
            //if fragment already exists, show the fragment
            fragmentManager.beginTransaction().show(fragment).commit();
        } else {
            //if it doesn't exists, create and add the fragment
            fragmentManager.beginTransaction().add(R.id.fragment_container, new MovieFragment(), FRAG_TAG_POPULAR).commit();
        }
        //hide rest of the fragments if they exist
        hideFragments(FRAG_TAG_TOP_RATED);
    }

    private void loadTopRatedMoviesFragment() {
        fragment = fragmentManager.findFragmentByTag(FRAG_TAG_TOP_RATED);
        if (fragment != null) {
            fragmentManager.beginTransaction().show(fragment).commit();
        } else {
            fragmentManager.beginTransaction().add(R.id.fragment_container, new MovieFragment(), FRAG_TAG_TOP_RATED).commit();
        }
        hideFragments(FRAG_TAG_POPULAR);
    }


    private void hideFragments(String... tags) {
        for (String tag : tags) {
            fragment = fragmentManager.findFragmentByTag(tag);
            if (fragment != null) {
                fragmentManager.beginTransaction().hide(fragment).commit();
            }
        }
    }
}