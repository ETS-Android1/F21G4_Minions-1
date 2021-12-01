package com.example.f21g4_minions.others;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.f21g4_minions.R;

import java.util.ArrayList;

public class WishlistActivity extends AppCompatActivity {

    private static ArrayList<Product> ProductsinWishlist;

    ListView listViewProductsinWishlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wishlist);


        ProductsinWishlist = Wishlist.getProductsinWishlist();
        listViewProductsinWishlist = findViewById(R.id.listViewProductsinWishlist);

        WishlistAdapter wishlistAdapter = new WishlistAdapter(ProductsinWishlist);
        listViewProductsinWishlist.setAdapter(wishlistAdapter);
    }
}