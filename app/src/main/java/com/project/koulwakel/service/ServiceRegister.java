package com.project.koulwakel.service;

import com.project.koulwakel.entity.LoginForm;
import com.project.koulwakel.entity.SignUpForm;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ServiceRegister {
    @POST("register")
    Call<SignUpForm> register (@Body SignUpForm signUpForm);
    @POST("signin")
    Call<LoginForm>Login (@Body LoginForm loginForm);
}
