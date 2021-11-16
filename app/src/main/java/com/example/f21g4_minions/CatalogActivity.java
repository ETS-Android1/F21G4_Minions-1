package com.example.f21g4_minions;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CatalogActivity extends AppCompatActivity {

    ProductAdapter productAdapter;
    DatabaseReference database;

//    Product product1 = new Product(R.drawable.gorilla,"Product1","ProductCategory1","ProductDescription1","ProductPrice1");
//    Product product2 = new Product(R.drawable.panda,"Product2","ProductCategory2","ProductDescription2","ProductPrice2");
//    Product product3 = new Product(R.drawable.bunnysplash,"Product3","ProductCategory3","ProductDescription3","ProductPrice3");
//    Product product4 = new Product(R.drawable.eagle,"Product4","ProductCategory4","ProductDescription4","ProductPrice4");

    List<Product> Products = new ArrayList<>();

    ListView listViewProduct;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog);

        listViewProduct = findViewById(R.id.listViewProduct);
        productAdapter = new ProductAdapter(Products);
        listViewProduct.setAdapter(productAdapter);




        database = FirebaseDatabase.getInstance().getReference("products");
        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot: snapshot.getChildren()){
                    Product product = dataSnapshot.getValue(Product.class);
                    Products.add(product);
                }
                System.out.println(Products);
                productAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }

        });



    }


}