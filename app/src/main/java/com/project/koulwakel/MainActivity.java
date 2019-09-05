package com.project.koulwakel;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.project.koulwakel.config.DataBaseConfig;
import com.project.koulwakel.entity.JwtResponse;
import com.project.koulwakel.entity.LoginForm;
import com.project.koulwakel.entity.SignUpForm;
import com.project.koulwakel.service.ServiceRegister;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    EditText email ;
    EditText password ;
    TextView createAccount ;
    String emailIntent ;
    String passwordIntent ;
    Button buttonSignIn ;
    ServiceRegister serviceRegister ;
//    private  static  final  String NAME_FILE ="dataStorge.txt";
    //private  static  final  String ShARED_PREFENCE ="sharedPreferences";
    public  static DataBaseConfig dataBaseConfig ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createAccount = (TextView)findViewById(R.id.create_account);
        email = (EditText)findViewById(R.id.email_sign_in) ;

        password = (EditText)findViewById(R.id.password_sign_in);
        buttonSignIn =(Button)findViewById(R.id.button);

        dataBaseConfig = Room.databaseBuilder(getApplicationContext() ,DataBaseConfig.class ,"data").allowMainThreadQueries().fallbackToDestructiveMigration().build();

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://koulouwakelprojectb32.herokuapp.com/api/auth/")
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();

        serviceRegister = retrofit.create(ServiceRegister.class);
       buttonSignIn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
              // Toast.makeText(MainActivity.this, ""+emailIntent+""+passwordIntent, Toast.LENGTH_SHORT).show();
               LoginForm loginForm = new LoginForm(email.getText().toString() ,password.getText().toString());
               Call<JwtResponse> call = serviceRegister.Login(loginForm);
              call.enqueue(new Callback<JwtResponse>() {
                  @Override
                  public void onResponse(Call<JwtResponse> call, Response<JwtResponse> response) {
                      Log.i("response",""+response.code());
                      if(response.code()==200){
                          Toast.makeText(MainActivity.this, "login successful"+response.headers().get("accessToken"),Toast.LENGTH_SHORT).show();
                          Log.i("responseApi",""+response.body().getAccessToken());
                             JwtResponse jwtResponse = new JwtResponse();
                               jwtResponse.setId(Long.valueOf(1));
                               jwtResponse.setAccessToken(response.body().getAccessToken());
                               jwtResponse.setType(response.body().getType());
                               jwtResponse.setUsername(response.body().getUsername());
                               jwtResponse.setAuthorities(response.body().getAuthorities());

                               try {
                                   dataBaseConfig.repositoryJwtResponse().addResponse(jwtResponse);
                               }catch (Exception e){
                                   dataBaseConfig.repositoryJwtResponse().UpdateJwtResponse(jwtResponse);
                               }


                          Log.i("hahahhahahahahahah","weeeeeeeeeeeeeys");





                      }else {
                          Toast.makeText(MainActivity.this, "verify your account", Toast.LENGTH_SHORT).show();
                      }
                  }

                  @Override
                  public void onFailure(Call<JwtResponse> call, Throwable t) {

                  }

              });
           }
       });

        createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,HomeActivity.class);
                startActivity(intent);
            }
        });
    }
}
