package com.project.koulwakel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.project.koulwakel.entity.LoginForm;
import com.project.koulwakel.entity.SignUpForm;
import com.project.koulwakel.service.ServiceRegister;

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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createAccount = (TextView)findViewById(R.id.create_account);
        email = (EditText)findViewById(R.id.email_sign_in) ;

        password = (EditText)findViewById(R.id.password_sign_in);
        buttonSignIn =(Button)findViewById(R.id.button);


        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("http://41.226.28.96:8090/api/auth/")
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();

        serviceRegister = retrofit.create(ServiceRegister.class);
       buttonSignIn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
              // Toast.makeText(MainActivity.this, ""+emailIntent+""+passwordIntent, Toast.LENGTH_SHORT).show();
               LoginForm loginForm = new LoginForm(email.getText().toString() ,password.getText().toString());
               Call<LoginForm> call = serviceRegister.Login(loginForm);
              call.enqueue(new Callback<LoginForm>() {
                  @Override
                  public void onResponse(Call<LoginForm> call, Response<LoginForm> response) {
                      Log.i("response",""+response.code());
                      if(response.code()==200){
                          Toast.makeText(MainActivity.this, "login successful", Toast.LENGTH_SHORT).show();
                      }else {
                          Toast.makeText(MainActivity.this, "verify your account", Toast.LENGTH_SHORT).show();
                      }
                  }

                  @Override
                  public void onFailure(Call<LoginForm> call, Throwable t) {

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
