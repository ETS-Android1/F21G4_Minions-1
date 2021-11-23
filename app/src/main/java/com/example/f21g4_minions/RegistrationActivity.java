package com.example.f21g4_minions;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegistrationActivity extends AppCompatActivity {

    EditText name, email, password;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        getSupportActionBar().hide();

        name = findViewById(R.id.name);
        name = findViewById(R.id.email);
        password = findViewById(R.id.password);


    }


    public void signUp(View view){
        startActivity(new Intent(RegistrationActivity.this, MainActivity.class));


        String userName = name.getText().toString();
        String userEmail = email.getText().toString();
        String userPassword = password.getText().toString();


        if(TextUtils.isEmpty(userName)){
            Toast.makeText(this, "Enter Name!", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(userEmail)){
            Toast.makeText(this, "Enter Email!", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(userPassword)){
            Toast.makeText(this, "Enter Password!", Toast.LENGTH_SHORT).show();
            return;
        }

        if(userPassword.length() < 7){
            Toast.makeText(this, "Password too short, enter minimum 7 characters!", Toast.LENGTH_SHORT).show();
            return;
        }

    }

    public void signIn(View view){
        startActivity(new Intent(RegistrationActivity.this, LoginActivity.class));
    }


}
