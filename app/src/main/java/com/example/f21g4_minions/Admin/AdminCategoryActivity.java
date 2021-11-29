package com.example.f21g4_minions.Admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.f21g4_minions.Buyers.HomeActivity;
import com.example.f21g4_minions.Buyers.MainActivity;
import com.example.f21g4_minions.R;

public class AdminCategoryActivity extends AppCompatActivity {

    private ImageView tShirts, sportsTshirts, femaleDresses, sweathers;
    private ImageView glasses, hats, laptops, purses_bags;
    private ImageView headphoness, shoes, watches, mobiles;

    private Button LogoutBtn, CheckOrderBtn, maintainProductsBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_category);

        LogoutBtn = findViewById(R.id.admin_logout_btn);
        CheckOrderBtn = findViewById(R.id.check_orders_btn);
        maintainProductsBtn = findViewById(R.id.maintain_btn);

        maintainProductsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminCategoryActivity.this, HomeActivity.class);
                intent.putExtra("Admin", "Admin");
                startActivity(intent);
            }
        });


        LogoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminCategoryActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();
            }
        });

        CheckOrderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminNewOrdersActivity.class);
                startActivity(intent);
                finish();
            }
        });

        //creating reference to all the product categories
        //Linear view 1
        tShirts = findViewById(R.id.t_shirts);
        sportsTshirts = findViewById(R.id.sports_t_shirts);
        femaleDresses = findViewById(R.id.female_dresses);
        sweathers = findViewById(R.id.sweather);
        //Linear view 2
        glasses = findViewById(R.id.glasses);
        hats = findViewById(R.id.hats);
        laptops = findViewById(R.id.laptops);
        purses_bags = findViewById(R.id.purses_bags);
        //Linear view 3
        headphoness = findViewById(R.id.headphoness);
        shoes = findViewById(R.id.shoes);
        watches = findViewById(R.id.watches);
        mobiles = findViewById(R.id.mobiles);





        tShirts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                //Now passing the data to different activity
                intent.putExtra("category", "tShirts");
                startActivity(intent);
            }
        });

        sportsTshirts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                //Now passing the data to different activity
                intent.putExtra("category", "sports Tshirts");
                startActivity(intent);
            }
        });

        femaleDresses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                //Now passing the data to different activity
                intent.putExtra("category", "female Dresses");
                startActivity(intent);
            }
        });

        sweathers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                //Now passing the data to different activity
                intent.putExtra("category", "sweathers");
                startActivity(intent);
            }
        });

        glasses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                //Now passing the data to different activity
                intent.putExtra("category", "glasses");
                startActivity(intent);
            }
        });

        hats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                //Now passing the data to different activity
                intent.putExtra("category", "hats");
                startActivity(intent);
            }
        });

        laptops.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                //Now passing the data to different activity
                intent.putExtra("category", "laptops");
                startActivity(intent);
            }
        });

        purses_bags.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                //Now passing the data to different activity
                intent.putExtra("category", "purses bags");
                startActivity(intent);
            }
        });

        headphoness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                //Now passing the data to different activity
                intent.putExtra("category", "headphoness");
                startActivity(intent);
            }
        });

        shoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                //Now passing the data to different activity
                intent.putExtra("category", "shoes");
                startActivity(intent);
            }
        });

        watches.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                //Now passing the data to different activity
                intent.putExtra("category", "watches");
                startActivity(intent);
            }
        });

        mobiles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                //Now passing the data to different activity
                intent.putExtra("category", "mobiles");
                startActivity(intent);
            }
        });






    }
}