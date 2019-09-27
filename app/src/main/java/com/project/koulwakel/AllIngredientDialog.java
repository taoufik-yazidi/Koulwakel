package com.project.koulwakel;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

import android.view.LayoutInflater;
import android.view.View;

import android.view.ViewGroup;
import android.widget.TextView;

public class AllIngredientDialog extends DialogFragment  {
    TextView cremerie ;
    TextView fruit;
    TextView legumes ;
    TextView epicerie ;
    TextView poisson ;
    TextView viande ;


    public AllIngredientDialog( ) {
    }
    public static  AllIngredientDialog newInstance(){
          AllIngredientDialog allIngredientDialog = new AllIngredientDialog() ;
          // Bundle args = new Bundle();
        return allIngredientDialog ;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return  inflater.inflate(R.layout.all_ingredinet,container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        cremerie= (TextView)view.findViewById(R.id.cremerie_id);
        fruit = (TextView)view.findViewById(R.id.fruit_id);
        legumes= (TextView)view.findViewById(R.id.legumes_id);
        epicerie = (TextView)view.findViewById(R.id.epicerie_id);
        poisson= (TextView)view.findViewById(R.id.poisson_id);
        viande = (TextView)view.findViewById(R.id.viande_id);

        cremerie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Log.i("cremerie clicked","clicked");//Log.i("token data base storg", ""+MainActivity.dataBaseConfig.repositoryJwtResponse().LoadJwtResponseById(Long.valueOf(1)).getAccessToken());
                FragmentAddIngredient fragmentAddIngredient = new FragmentAddIngredient();
                FragmentManager ft = getChildFragmentManager();
                FragmentTransaction fragmentTransaction = ft.beginTransaction() ;
                fragmentTransaction.add(R.id.frame_layout_id, fragmentAddIngredient);
                Bundle args = new Bundle();
                args.putString("categorie", "cremerie");
                fragmentAddIngredient.setArguments(args);
                fragmentTransaction.commit();

//
            }
        });
        fruit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                  FragmentAddIngredient fragmentAddIngredient = new FragmentAddIngredient();
                FragmentManager ft = getChildFragmentManager();
                FragmentTransaction fragmentTransaction = ft.beginTransaction() ;
                fragmentTransaction.add(R.id.frame_layout_id, fragmentAddIngredient);
                Bundle args = new Bundle();
                args.putString("categorie", "fruit");
                fragmentAddIngredient.setArguments(args);
                fragmentTransaction.commit();
            }
        });

        legumes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                    FragmentAddIngredient fragmentAddIngredient = new FragmentAddIngredient();
                FragmentManager ft = getChildFragmentManager();
                FragmentTransaction fragmentTransaction = ft.beginTransaction() ;
                fragmentTransaction.add(R.id.frame_layout_id, fragmentAddIngredient);
                Bundle args = new Bundle();
                args.putString("categorie", "legumes");
                fragmentAddIngredient.setArguments(args);
                fragmentTransaction.commit();

            }
        });

        epicerie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                    FragmentAddIngredient fragmentAddIngredient = new FragmentAddIngredient();
                FragmentManager ft = getChildFragmentManager();
                FragmentTransaction fragmentTransaction = ft.beginTransaction() ;
                fragmentTransaction.add(R.id.frame_layout_id, fragmentAddIngredient);
                Bundle args = new Bundle();
                args.putString("categorie", "epicerie");
                fragmentAddIngredient.setArguments(args);
                fragmentTransaction.commit();

            }
        });
        poisson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentAddIngredient fragmentAddIngredient = new FragmentAddIngredient();
                FragmentManager ft = getChildFragmentManager();
                FragmentTransaction fragmentTransaction = ft.beginTransaction() ;
                fragmentTransaction.add(R.id.frame_layout_id, fragmentAddIngredient);
                Bundle args = new Bundle();
                args.putString("categorie", "possion");
                fragmentAddIngredient.setArguments(args);
                fragmentTransaction.commit();
            }
        });
        viande.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentAddIngredient fragmentAddIngredient = new FragmentAddIngredient();
                FragmentManager ft = getChildFragmentManager();
                FragmentTransaction fragmentTransaction = ft.beginTransaction() ;
                fragmentTransaction.add(R.id.frame_layout_id, fragmentAddIngredient);
                Bundle args = new Bundle();
                args.putString("categorie", "viande");
                fragmentAddIngredient.setArguments(args);
                fragmentTransaction.commit();
            }
        });

    }


}
