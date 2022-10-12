package com.example.meditation;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.meditation.databinding.ActivityMainBinding;

public class Main extends AppCompatActivity {

    ActivityMainBinding bindingBottom;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindingBottom = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(bindingBottom.getRoot());
        replaceFragment(new HomeFragment());

        bindingBottom.bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.home:
                    replaceFragment(new HomeFragment());
                    break;
                case R.id.music:
                    replaceFragment(new MusicFragment());
                    break;
                case R.id.profile:
                    replaceFragment(new ProfileFragment());
                    break;
            }
            return true;
        });

        bindingBottom.topNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.hamburger:
                    replaceFragment(new humburgerFragment());
                    break;
                case R.id.user:
                    replaceFragment(new UserFragment());
                    break;
            }
            return true;
        });
    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout,fragment);
        fragmentTransaction.commit();
    }
}