package com.example.f21g4_minions.Sellers;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.f21g4_minions.Buyers.CartActivity;
import com.example.f21g4_minions.Buyers.HomeActivity;
import com.example.f21g4_minions.Buyers.MainActivity;
import com.example.f21g4_minions.Buyers.SearchProductsActivity;
import com.example.f21g4_minions.Buyers.SettingsActivity;
import com.example.f21g4_minions.R;
import com.example.f21g4_minions.databinding.ActivitySellerHomeBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

public class SellerHomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private ActivitySellerHomeBinding binding;

    private TextView mTextMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitySellerHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);


        navView.setOnNavigationItemSelectedListener(this::onNavigationItemSelected);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
//        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
//                R.id.navigation_home, R.id.navigation_add, R.id.navigation_notifications)
//                .build();

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id==R.id.navigation_home) {
//            mTextMessage.setText(R.string.title_home);



        } else if (id==R.id.navigation_add) {

//            mTextMessage.setText(R.string.title_add);


        } else if (id==R.id.navigation_logout) {
            final FirebaseAuth mAuth;
            mAuth = FirebaseAuth.getInstance();
            mAuth.signOut();

            Intent intent = new Intent(SellerHomeActivity.this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
            return true;


        }

        return false;

    }

}