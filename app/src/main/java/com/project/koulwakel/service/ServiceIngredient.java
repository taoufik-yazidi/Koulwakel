package com.project.koulwakel.service;

import com.project.koulwakel.entity.Ingredient;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

public interface ServiceIngredient {

    @GET("application/ingredients")
    Call<List<Ingredient>>getAllIngredient(@Header("Authorization")String auth);

    @GET("application/pictures/{pictureId}")
    Call<Byte[]>getPictureIngredientById (@Path("pictureId") String pictureId,@Header("Authorization")String auth);
}
