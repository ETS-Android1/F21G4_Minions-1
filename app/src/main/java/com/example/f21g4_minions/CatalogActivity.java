package com.example.f21g4_minions;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CatalogActivity extends AppCompatActivity {

    ProductAdapter productAdapter;
    DatabaseReference database;
    FirebaseStorage storage = FirebaseStorage.getInstance();
 // Create a storage reference from our app
    StorageReference storageRef = storage.getReference();
    ProgressDialog progressDialog;

    ArrayList<Product> Products = new ArrayList<>();

    ListView listViewProduct;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog);

        listViewProduct = findViewById(R.id.listViewProduct);
        productAdapter = new ProductAdapter(this, Products);
        listViewProduct.setAdapter(productAdapter);


        //Uncomment this if all images do not show up
//        progressDialog = new ProgressDialog(CatalogActivity.this);
//        progressDialog.setMessage("Fetching image: ");
//        progressDialog.setCancelable(false);
//        progressDialog.show();


        //Code for fetching a single image from this line************************************
//        storageRef = FirebaseStorage.getInstance().getReference("eagle.png");
//
//        try{
//            File localFile = File.createTempFile("tempfile", ".png");
//            storageRef.getFile(localFile)
//                    .addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
//                        @Override
//                        public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
//                            if(progressDialog.isShowing()){
//                                progressDialog.dismiss();
//                                Bitmap bitmap = BitmapFactory.decodeFile(localFile.getAbsolutePath());
//                                ImageView imgProductImg = (ImageView) findViewById(R.id.imgProductImg);
//                                imgProductImg.setImageBitmap(bitmap);
//                            }
//                        }
//                    }).addOnFailureListener(new OnFailureListener() {
//                @Override
//                public void onFailure(@NonNull Exception e) {
//                    if(progressDialog.isShowing()){
//                        progressDialog.dismiss();
//                    }
//
//                    Toast.makeText(CatalogActivity.this, "Failed to retrieve", Toast.LENGTH_SHORT).show();
//                }
//            });
//        } catch (IOException ex){
//            ex.printStackTrace();
//        }
        //Code for fetching a single image to this line************************************




        //Code for fetching all images


        //path name to database
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