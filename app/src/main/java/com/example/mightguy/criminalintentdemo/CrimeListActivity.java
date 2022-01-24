package com.example.mightguy.criminalintentdemo;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import java.util.UUID;

public class CrimeListActivity extends SingleFragmentActivity{

    @Override
    public Fragment createFragment() {
        return new CrimeListFragment();
    }
}
