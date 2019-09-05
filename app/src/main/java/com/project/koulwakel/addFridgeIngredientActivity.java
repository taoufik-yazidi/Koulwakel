package com.project.koulwakel;

import android.content.SharedPreferences;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class addFridgeIngredientActivity extends AppCompatActivity {

    TextView cremerie ;
    TextView fruit;
    TextView legumes ;
    TextView epicerie ;
    TextView poisson ;
    TextView viande ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_fridge_ingredient);
        cremerie= (TextView)findViewById(R.id.cremerie_id);
        fruit = (TextView)findViewById(R.id.fruit_id);
        legumes= (TextView)findViewById(R.id.legumes_id);
        epicerie = (TextView)findViewById(R.id.epicerie_id);
        poisson= (TextView)findViewById(R.id.poisson_id);
        viande = (TextView)findViewById(R.id.viande_id);

       cremerie.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
           // Log.i("cremerie clicked","clicked");//Log.i("token data base storg", ""+MainActivity.dataBaseConfig.repositoryJwtResponse().LoadJwtResponseById(Long.valueOf(1)).getAccessToken());
               FragmentAddIngredient fragmentAddIngredient = new FragmentAddIngredient();
               if (fragmentAddIngredient != null) {
                   FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                   ft.replace(R.id.content_frame, fragmentAddIngredient);
                   ft.commit();
               }
           }
       });
    }
}
