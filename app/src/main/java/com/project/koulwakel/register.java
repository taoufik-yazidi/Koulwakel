package com.project.koulwakel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.project.koulwakel.entity.SignUpForm;
import com.project.koulwakel.service.ServiceRegister;

import java.util.HashSet;
import java.util.Set;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class register extends AppCompatActivity {

    EditText email ;
    EditText name ;
    EditText userName ;
    EditText adresse ;
    EditText password ;
    EditText confirmedPassword ;
    Button submitButton ;
    ServiceRegister serviceRegister ;
    Set<String> role ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Rettofit initialitation
        setContentView(R.layout.activity_register);
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("http://41.226.28.96:8090/api/auth/")
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();

         serviceRegister = retrofit.create(ServiceRegister.class);
        //initialisation object if layout
        email = (EditText) findViewById(R.id.email_text);
        name = (EditText)findViewById(R.id.name_text);
        userName =(EditText)findViewById(R.id.user_name);
        adresse= (EditText)findViewById(R.id.adresse_text);
        password=(EditText)findViewById( R.id.password_text);
        confirmedPassword =(EditText)findViewById(R.id.confirm_password);
        submitButton =(Button)findViewById(R.id.button_submit);

        role = new HashSet<String>();
        role.add("ADMIN");
       /* final SignUpForm signUpForm =new SignUpForm("taoufik","yazidiTaoufik",
                "yazidiTaoufik@gamil.com","rades2040benarous",role
                ,"1234567890");*/

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              /*  Log.i("name",name.getText().toString());
                Log.i("email",email.getText().toString());
                Log.i("userName",userName.getText().toString());
                Log.i("adresse",adresse.getText().toString());
                Log.i("password",password.getText().toString());
                Log.i("confirmedPassword",confirmedPassword.getText().toString());*/
                if (!TextUtils.isEmpty(name.toString().trim())||!TextUtils.isEmpty(email.toString().trim())
                        ||!TextUtils.isEmpty(userName.toString().trim())||!TextUtils.isEmpty(adresse.toString().trim())
                        ||!TextUtils.isEmpty(password.toString().trim())||!TextUtils.isEmpty(confirmedPassword.toString().trim())
                ) {
                    Toast.makeText(register.this, "Ces informations sont nécessaires.\n", Toast.LENGTH_SHORT).show();
                }

                if (!password.getText().toString().equals(confirmedPassword.getText().toString())){
                    Toast.makeText(register.this, "vérifier votre mot de passe.\n", Toast.LENGTH_SHORT).show();
                }
                SignUpForm signUpForm = new SignUpForm(name.getText().toString(),userName.getText().toString(),email.getText().toString(),
                        adresse.getText().toString(),role ,password.getText().toString());
                Call<SignUpForm> call = serviceRegister.register(signUpForm);
                call.enqueue(new Callback<SignUpForm>() {
                    @Override
                    public void onResponse(Call<SignUpForm> call, Response<SignUpForm> response) {
                       // Log.i("ddddd",""+response.code());
                        if (response.code()==200){
                            Intent intent = new Intent(register.this,MainActivity.class);
                            /*intent.putExtra("EMAIL",email.getText().toString());
                            intent.putExtra("PASSWORD",password.getText().toString());*/
                            startActivity(intent);
                        }
                    }

                    @Override
                    public void onFailure(Call<SignUpForm> call, Throwable t) {

                    }
                });


            }
        });
    }
}
