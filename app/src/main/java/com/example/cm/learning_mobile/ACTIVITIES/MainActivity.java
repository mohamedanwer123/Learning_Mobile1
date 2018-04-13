package com.example.cm.learning_mobile.ACTIVITIES;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.cm.learning_mobile.FRAGMENTS_TRACKS.BlankFragment;
import com.example.cm.learning_mobile.FRAGMENTS_TRACKS.androidfragment;
import com.example.cm.learning_mobile.FRAGMENTS_TRACKS.iosfragment;
import com.example.cm.learning_mobile.FRAGMENTS_TRACKS.javafragment;
import com.example.cm.learning_mobile.R;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navigationView;
    FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        default_fragment();
        load_fragment();
    }

    public void init()
    {
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.vn);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (actionBarDrawerToggle.onOptionsItemSelected(item))
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void default_fragment()
    {
        Fragment blankFragment = new BlankFragment();
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.popBackStack();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout,blankFragment);
        fragmentTransaction.commit();
    }

    public void load_fragment()
    {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                switch (id)
                {
                    case R.id.homeee :
                        default_fragment();
                        drawerLayout.closeDrawers();
                        break;

                    case R.id.java :
                        Fragment fragment1 = new javafragment();
                        load(fragment1);
                        drawerLayout.closeDrawers();
                        break;

                    case R.id.android :
                        Fragment fragment2 = new androidfragment();
                        load(fragment2);
                        drawerLayout.closeDrawers();
                        break;

                    case R.id.ios :
                        Fragment fragment3 = new iosfragment();
                        load(fragment3);
                        drawerLayout.closeDrawers();
                        break;


                }
                return false;
            }
        });
    }

    public void load(Fragment fragment)
    {
        FragmentManager fragmentManager = getFragmentManager();
       // fragmentManager.popBackStack();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout,fragment);
        fragmentTransaction.commit();
    }

    long time=0;
    @Override
    public void onBackPressed() {

        if(time+2000>System.currentTimeMillis())
        {
            super.onBackPressed();
        }else
        {
            Toast toast = Toast.makeText(this,"Dubble click to exist",Toast.LENGTH_LONG);

            toast.show();
            time = System.currentTimeMillis();
        }
    }
}
