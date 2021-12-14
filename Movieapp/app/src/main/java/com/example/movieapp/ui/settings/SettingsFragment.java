package com.example.movieapp.ui.settings;



import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.preference.PreferenceFragmentCompat;
import androidx.fragment.app.Fragment;

import com.example.movieapp.R;

import org.jetbrains.annotations.NotNull;

public class SettingsFragment extends PreferenceFragmentCompat {
    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey){
        setPreferencesFromResource(R.xml.settings,rootKey);
    }
}
