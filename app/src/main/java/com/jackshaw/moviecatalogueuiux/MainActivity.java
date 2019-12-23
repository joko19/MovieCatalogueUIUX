package com.jackshaw.moviecatalogueuiux;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;


public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private PagerAdapter pagerAdapter;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //menambahkan menu ke action bar
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }



    public void onComposeAction(MenuItem mi){
        Intent SettingIntent = new Intent(MainActivity.this, SettingLanguage.class);
        startActivity(SettingIntent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tab_Layout);
        viewPager = findViewById(R.id.view_pager);
        pagerAdapter = new PagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);

        //tambahkan fragment
        pagerAdapter.AddFragment(new MoviesFragment(), "Movie");
        pagerAdapter.AddFragment(new TVShowFragment(), "TV Show");
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

}
