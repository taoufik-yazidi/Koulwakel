package com.project.koulwakel;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.project.koulwakel.RecycleList.IngredientRecycle;
import com.project.koulwakel.entity.IngeridentRecycle;

import java.util.ArrayList;
import java.util.List;

public class FridgeFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return  inflater.inflate(R.layout.fragment_fridge , null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
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
