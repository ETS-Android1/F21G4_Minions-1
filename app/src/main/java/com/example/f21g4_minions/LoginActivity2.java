package com.example.f21g4_minions;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity2 extends AppCompatActivity {

    final String TAG_ERROR_LOGIN = "";
    final String TAG_DEBUG_LOGIN = "";
    EditText email, password;
    private FirebaseAuth auth;
    Button btnsignInLogin;
    TextView txtsignUpLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

       // getSupportActionBar().hide();

        auth = FirebaseAuth.getInstance();
        btnsignInLogin = findViewById(R.id.signInLogin);
        txtsignUpLogin = findViewById(R.id.signUpLogin);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);


        // clicking on sign in
        btnsignInLogin.setOnClickListener((View view) -> {
            String userEmail = email.getText().toString();
            String userPassword = password.getText().toString();

            if(TextUtils.isEmpty(userEmail)){
                Toast.makeText(this, "Enter Email!", Toast.LENGTH_SHORT).show();
                Log.e(TAG_ERROR_LOGIN, "Email is empty");
            }else if(TextUtils.isEmpty(userPassword)){
                Toast.makeText(this, "Enter Password!", Toast.LENGTH_SHORT).show();
                Log.e(TAG_ERROR_LOGIN, "Password is empty");
            }else if(userPassword.length() < 7){
                Toast.makeText(this, "Password too short, enter minimum 7 characters!", Toast.LENGTH_SHORT).show();
                Log.e(TAG_ERROR_LOGIN, "Password length is less than the minimum 7 characters");
            }else{
                auth.signInWithEmailAndPassword(userEmail, userPassword).addOnCompleteListener(LoginActivity2.this, task -> {
                    if(task.isSuccessful()){
                        Toast.makeText(LoginActivity2.this, "Login Successful", Toast.LENGTH_SHORT).show();
                        //startActivity(new Intent(LoginActivity2.this, MainActivity.class));
                    } else {
                        Toast.makeText(LoginActivity2.this, "Login Failed" + task.getException(), Toast.LENGTH_SHORT).show();
                        Log.e(TAG_ERROR_LOGIN, String.valueOf(task.getException()));
                    }
                });
            }
        });

        try{
            // clicking on sign in text
            Log.d(TAG_DEBUG_LOGIN, "Moved to Registration Activity");
            //txtsignUpLogin.setOnClickListener((View view) -> startActivity(new Intent(LoginActivity2.this, RegistrationActivity.class)));
        }catch(Exception e){
            Log.e(TAG_ERROR_LOGIN, e.getMessage());
        }

    }

}