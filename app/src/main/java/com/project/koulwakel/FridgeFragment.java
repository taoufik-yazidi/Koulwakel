package com.project.koulwakel;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.project.koulwakel.RecycleList.IngredientRecycle;
import com.project.koulwakel.entity.IngeridentRecycle;
import com.project.koulwakel.entity.Ingredient;

import java.util.ArrayList;
import java.util.List;

public class FridgeFragment extends Fragment {

    Button addIngredient ;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return  inflater.inflate(R.layout.fragment_fridge , null);
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {

        addIngredient = (Button)view.findViewById(R.id.add_ingredient_button);
        addIngredient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addIngeredientActivity = new Intent(getContext(), addFridgeIngredientActivity.class);
                startActivity(addIngeredientActivity);
            }
        });


       List<IngeridentRecycle>ingeridentRecycles = new ArrayList<>();
          ingeridentRecycles.add(new IngeridentRecycle("batata",R.drawable.batata));
        ingeridentRecycles.add(new IngeridentRecycle("bsal",R.drawable.bsal));
        ingeridentRecycles.add(new IngeridentRecycle("kares",R.drawable.kares ));
        ingeridentRecycles.add(new IngeridentRecycle("tmatem",R.drawable.tmatm));
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycle_ingredient_id);
        IngredientRecycle ingredientRecycle = new IngredientRecycle(getContext() , ingeridentRecycles);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        recyclerView.setAdapter(ingredientRecycle);


    }


}
