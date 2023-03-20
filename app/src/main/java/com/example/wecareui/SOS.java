package com.example.wecareui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class SOS extends AppCompatActivity {

    BottomNavigationView bnView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sos);

        bnView=findViewById(R.id.bnView);

        bnView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id=item.getItemId();
                if(id==R.id.nav_home){
                    loadFrag(new HomeFragment(),true);
                }
                else if (id==R.id.nav_Tips){
                    loadFrag(new TipsFragment(),false);
                }
                else if(id==R.id.nav_emergency){
                    loadFrag(new EmergencyFragment(),false);
                }
                else if(id==R.id.nav_setting){
                    loadFrag(new SettingsFragment(),false);
                }
                else{
                    loadFrag(new MyProfileFragment(),false);
                }
                return true;
            }
        });

        bnView.setSelectedItemId(R.id.nav_home);
    }
    public void loadFrag(Fragment fragment,boolean flag){
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        if(flag) {
            fragmentTransaction.add(R.id.Container, fragment);}
        else {
            fragmentTransaction.replace(R.id.Container,fragment);
            fragmentTransaction.commit();
        }

    }
}