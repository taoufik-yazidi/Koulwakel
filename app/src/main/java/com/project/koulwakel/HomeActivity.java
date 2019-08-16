package com.project.koulwakel;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
//import android.util.Log;
import android.view.MenuItem;
//import android.widget.Toast;


public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout ;
    ActionBarDrawerToggle drawerToggle ;
    Toolbar toolbar ;
    NavigationView navigationView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        toolbar = findViewById(R.id.appBar);
        setSupportActionBar(toolbar);
        navigationView = findViewById(R.id.navigation_bar);
        drawerLayout = findViewById(R.id.draw);
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout,toolbar,R.string.open_drawer,R.string.close_drawer);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white));
        drawerToggle.setDrawerIndicatorEnabled(true);
        drawerToggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
      //  Log.i("log selected",""+menuItem.getItemId());
       // Toast.makeText(HomeActivity.this, ""+menuItem.getItemId(), Toast.LENGTH_SHORT).show();

        Fragment fragment = null ;
         switch (menuItem.getItemId()){
            case R.id.id_frigo :
               /* Intent intent = new Intent(HomeActivity.this,FridgeActivity.class);
                startActivity(intent);*/
               fragment = new FridgeFragment() ;
                break;

        }
        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragment);
            ft.commit();
        }

        return false;
    }
}
