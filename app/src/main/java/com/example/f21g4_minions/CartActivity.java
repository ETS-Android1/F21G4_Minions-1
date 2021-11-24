package com.example.f21g4_minions;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {

    private static ArrayList<Product> ProductsinCart;

    ListView listViewProductsinCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        ProductsinCart = Cart.getProductsinCart();
        listViewProductsinCart = findViewById(R.id.listViewProductsinCart);

        CartAdapter cartAdapter = new CartAdapter(ProductsinCart);
        listViewProductsinCart.setAdapter(cartAdapter);

    }
}