package com.project.koulwakel;


import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;


public class HomeActivity extends AppCompatActivity  {

   private BottomNavigationView bottomNavigationView ;
   private FrameLayout  frameLayout ;
   private TextView nameFragment ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        bottomNavigationView = (BottomNavigationView)findViewById(R.id.nav_main);

        frameLayout =(FrameLayout)findViewById(R.id.main_frame);
        nameFragment =(TextView)findViewById(R.id.name_fragment_id);
//           Toolbar toolbar =findViewById(R.id.toolbar_up);
//            setSupportActionBar(toolbar);
        FragmentRecette fragmentRecette = new FragmentRecette();
        setFragment(fragmentRecette);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                  switch (menuItem.getItemId()){
                      case R.id.frigo_menu_id :
                          nameFragment.setText("MonFrigo");
                          //bottomNavigationView.setItemBackgroundResource(R.color.colorPrimary);
                          FridgeFragment fridgeFragment = new FridgeFragment() ;
                          setFragment(fridgeFragment);
                          return true ;
                      case R.id.recherche_menu_id :
                          nameFragment.setText("Recherche");
                          //bottomNavigationView.setItemBackgroundResource(R.color.colorPrimary);
                          FragmentFilterRecherche fragmentFilterRecherche = new FragmentFilterRecherche();
                          setFragment(fragmentFilterRecherche);
                          return true ;



                      case R.id.recette_menu_id :
                        //  bottomNavigationView.setItemBackgroundResource(R.color.colorPrimary);
                          nameFragment.setText("Nos Recettes");
                           FragmentRecette fragmentRecette = new FragmentRecette();
                           setFragment(fragmentRecette);
                          return true ;

                          default:
                              return  false ;
                  }
            }
        });




    }

   private void setFragment(Fragment fragment){
       FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
       fragmentTransaction.replace(R.id.main_frame , fragment);
       fragmentTransaction.commit();
   }



}
