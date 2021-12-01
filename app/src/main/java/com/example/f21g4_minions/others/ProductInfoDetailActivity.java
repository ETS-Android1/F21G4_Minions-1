package com.example.f21g4_minions.others;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.f21g4_minions.R;

public class ProductInfoDetailActivity extends AppCompatActivity {

    TextView txtViewProductName;
    TextView txtViewProductCategory;
    TextView txtViewProductPrice;

    Button btnAddToCart;
    Button btnAddToWishlist;
    Button btnTemp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_info_detail);


        try {
            Bundle bundle = getIntent().getExtras();
            String ProductName = bundle.getString("ProductName");
            String ProductCategory = bundle.getString("ProductCategory");
            String ProductPrice = bundle.getString("ProductPrice");

            txtViewProductName = findViewById(R.id.txtViewProductName);
            txtViewProductCategory = findViewById(R.id.txtViewProductCategory);
            txtViewProductPrice = findViewById(R.id.txtViewProductPrice);

            btnAddToCart = findViewById(R.id.btnAddToCart);
            btnAddToWishlist = findViewById(R.id.btnAddToWishlist);
// temp code begin
            btnTemp = findViewById(R.id.btnTemp);

            btnTemp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(ProductInfoDetailActivity.this, WishlistActivity.class));
                }
            });
// temp code ends
            txtViewProductName.setText(ProductName);
            txtViewProductCategory.setText(ProductCategory);
            txtViewProductPrice.setText(ProductPrice);

            btnAddToCart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Product productToAddToCart = new Product(txtViewProductName.getText().toString(),
                            txtViewProductCategory.getText().toString(),
                            txtViewProductPrice.getText().toString());
                    //Cart.addItemToCart(productToAddToCart);
                }
            });


            btnAddToWishlist.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Product productToAddToWishlist = new Product(txtViewProductName.getText().toString(),
                            txtViewProductCategory.getText().toString(),
                            txtViewProductPrice.getText().toString());
                    Wishlist.addItemToWishlist(productToAddToWishlist);
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}