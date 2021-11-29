package com.example.f21g4_minions;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.f21g4_minions.Prevalent.Prevalent;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Objects;

public class ResetPasswordActivity extends AppCompatActivity {

    private String check = "";
    private TextView pageTitle;
    private TextView titleQuestions;
    private EditText phoneNumber;
    private EditText question1;
    private EditText question2;
    private Button verifyButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        check = getIntent().getStringExtra("check");

        pageTitle = findViewById(R.id.page_title);
        titleQuestions = findViewById(R.id.title_questions);
        phoneNumber =  findViewById(R.id.find_phone_number);
        question1 = findViewById(R.id.question_1);
        question2 = findViewById(R.id.question_2);
        verifyButton = findViewById(R.id.verify_btn);
    }

    @Override
    public void onStart(){
        super.onStart();


        phoneNumber.setVisibility(View.GONE);

        if(check.equals("settings")){
            pageTitle.setText("Set Questions");
            titleQuestions.setText("Please set answers for the following Security Questions?");
            verifyButton.setText("Set");

            displayPreviousAnswers();

            verifyButton.setOnClickListener(view -> setAnswers());
            
        }else if(check.equals("login")){
            phoneNumber.setVisibility(View.VISIBLE);
        }
    }

    private void setAnswers(){
        String answer1 = question1.getText().toString().toLowerCase();
        String answer2 = question2.getText().toString().toLowerCase();

        if(answer1.equals("") && answer2.equals("")){
            Toast.makeText(ResetPasswordActivity.this, "Please answer both questions", Toast.LENGTH_SHORT).show();
        }else{
            DatabaseReference ref = FirebaseDatabase.getInstance()
                    .getReference()
                    .child("Users")
                    .child(Prevalent.currentOnlineUser.getPhone());


            HashMap<String, Object> userdataMap = new HashMap<>();
            userdataMap.put("answer1", answer1);
            userdataMap.put("answer2", answer2);

            ref.child("Security Questions").updateChildren(userdataMap)
                    .addOnCompleteListener(task -> {
                        if(task.isSuccessful()){
                            Toast.makeText(ResetPasswordActivity.this, "You have answered the security questions successfully", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(ResetPasswordActivity.this, HomeActivity.class);
                            startActivity(intent);
                        }
                    });

        }
    }


    private void displayPreviousAnswers(){
        DatabaseReference ref = FirebaseDatabase.getInstance()
                .getReference()
                .child("Users")
                .child(Prevalent.currentOnlineUser.getPhone());

        ref.child("Security Questions").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    // Objects.requireNonNull handles Null Pointer Exception
                    String ans1 = Objects.requireNonNull(snapshot.child("answer1").getValue()).toString();
                    String ans2 = Objects.requireNonNull(snapshot.child("answer2").getValue()).toString();


                    question1.setText(ans1);
                    question2.setText(ans2);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}