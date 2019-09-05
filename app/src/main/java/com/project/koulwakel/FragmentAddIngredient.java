package com.project.koulwakel;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.Toast;

import com.project.koulwakel.RecycleList.IngredientRecycle;
import com.project.koulwakel.entity.IngeridentRecycle;
import com.project.koulwakel.entity.Ingredient;
import com.project.koulwakel.service.ServiceIngredient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FragmentAddIngredient  extends Fragment {

   // static String categorie ;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // categorie =getArguments().getString("categorie");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.recycler_add_ingredient_firdge , null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
     //   Toast.makeText(getContext(), categorie, Toast.LENGTH_SHORT).show();

        // inisalisation retrofit
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://koulouwakelprojectb32.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();

        ServiceIngredient serviceIngredient = retrofit.create(ServiceIngredient.class);
        Call<List<Ingredient>>ingredientCall = serviceIngredient.getAllIngredient("Bearer "+MainActivity.dataBaseConfig.
                                                                               repositoryJwtResponse().
                                                                               LoadJwtResponseById(Long.valueOf(1)).getAccessToken());
        ingredientCall.enqueue(new Callback<List<Ingredient>>() {
            @Override
            public void onResponse(Call<List<Ingredient>> call, Response<List<Ingredient>> response) {
                Log.i("get all ingredinet",""+response.body().size());
            }

            @Override
            public void onFailure(Call<List<Ingredient>> call, Throwable t) {
              Log.i("fail get all ingredient","fail");
            }
        });

    }
}
