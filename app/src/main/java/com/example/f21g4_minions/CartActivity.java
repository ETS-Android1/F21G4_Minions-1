package com.example.f21g4_minions;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {

//    private static ArrayList<Product> ProductsinCart;
//
//    ListView listViewProductsinCart;

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private Button nextProcessBtn;
    private TextView txtTotalAmount;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

//        ProductsinCart = Cart.getProductsinCart();
//        listViewProductsinCart = findViewById(R.id.listViewProductsinCart);
//
//        CartAdapter cartAdapter = new CartAdapter(ProductsinCart);
//        listViewProductsinCart.setAdapter(cartAdapter);


        recyclerView = findViewById(R.id.cart_list);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        nextProcessBtn = findViewById(R.id.next_process_btn);
        txtTotalAmount = findViewById(R.id.total_price);



    }
}