package com.example.f21g4_minions;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.auth.FirebaseAuth;

public class RegistrationActivity extends AppCompatActivity {

    final String TAG_ERROR_REGISTER = "";
    final String TAG_DEBUG_REGISTER = "";

    EditText name, email, password;
    private FirebaseAuth auth;
    Button btnsignUpRegister;
    TextView txtsignInRegister;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        //getSupportActionBar().hide();

        auth = FirebaseAuth.getInstance();

        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);

        btnsignUpRegister = findViewById(R.id.signUpRegister);
        txtsignInRegister = findViewById(R.id.signInRegister);

        // listener on button
        btnsignUpRegister.setOnClickListener((View view) -> {
            String userName = name.getText().toString();
            String userEmail = email.getText().toString();
            String userPassword = password.getText().toString();


            if(TextUtils.isEmpty(userName)){
                Toast.makeText(this, "Enter Name!", Toast.LENGTH_SHORT).show();
            }else if(TextUtils.isEmpty(userEmail)){
                Toast.makeText(this, "Enter Email!", Toast.LENGTH_SHORT).show();
            }else if(TextUtils.isEmpty(userPassword)){
                Toast.makeText(this, "Enter Password!", Toast.LENGTH_SHORT).show();
            }else if(userPassword.length() < 7){
                Toast.makeText(this, "Password too short, enter minimum 7 characters!", Toast.LENGTH_SHORT).show();
            }else{
                auth.createUserWithEmailAndPassword(userEmail,userPassword).addOnCompleteListener(RegistrationActivity.this, task -> {
                    if(task.isSuccessful()){
                        Toast.makeText(RegistrationActivity.this, "Successfully Registered", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(RegistrationActivity.this, MainActivity.class));
                    }
                    else{
                        Toast.makeText(RegistrationActivity.this, "Registration Unsuccessful" + task.getException(), Toast.LENGTH_SHORT).show();
                        Log.e(TAG_ERROR_REGISTER, String.valueOf(task.getException()));
                    }
                });
            }
        });

        try{
            // clicking on sign in text
            Log.d(TAG_DEBUG_REGISTER, "Moved to Login Activity");
            txtsignInRegister.setOnClickListener((View view) -> startActivity(new Intent(RegistrationActivity.this, LoginActivity.class)));
        }catch(Exception e){
            Log.e(TAG_ERROR_REGISTER,e.getMessage());
        }

    }
    


}
