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
//    Product product1 = new Product(R.drawable.gorilla,"Product1","ProductCategory1","ProductDescription1","ProductPrice1");
//    Product product2 = new Product(R.drawable.panda,"Product2","ProductCategory2","ProductDescription2","ProductPrice2");
//    Product product3 = new Product(R.drawable.bunnysplash,"Product3","ProductCategory3","ProductDescription3","ProductPrice3");
//    Product product4 = new Product(R.drawable.eagle,"Product4","ProductCategory4","ProductDescription4","ProductPrice4");
    // Create a storage reference from our app
    StorageReference storageRef = storage.getReference();
    ProgressDialog progressDialog;

    // Create a reference with an initial file path and name
   // StorageReference pathReference = storageRef.child("eagle.jpg");

//    // Create a reference to a file from a Google Cloud Storage URI
     //StorageReference gsReference = storage.getReferenceFromUrl("gs://minions-3175.appspot.com");

    // Create a reference from an HTTPS URL
// Note that in the URL, characters are URL escaped!
//    StorageReference httpsReference = storage.getReferenceFromUrl("https://firebasestorage.googleapis.com/b/bucket/o/images%20stars.jpg");
    List<Product> Products = new ArrayList<>();

    ListView listViewProduct;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog);

        listViewProduct = findViewById(R.id.listViewProduct);
        productAdapter = new ProductAdapter(Products);
        listViewProduct.setAdapter(productAdapter);
        progressDialog = new ProgressDialog(CatalogActivity.this);
        progressDialog.setMessage("Fetching image: ");
        progressDialog.setCancelable(false);
        progressDialog.show();


        storageRef = FirebaseStorage.getInstance().getReference("eagle.png");

        try{
            File localFile = File.createTempFile("tempfile", ".png");
            storageRef.getFile(localFile)
                    .addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                            if(progressDialog.isShowing()){
                                progressDialog.dismiss();
                                Bitmap bitmap = BitmapFactory.decodeFile(localFile.getAbsolutePath());
                                ImageView imgProductImg = (ImageView) findViewById(R.id.imgProductImg);
                                imgProductImg.setImageBitmap(bitmap);
                            }
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    if(progressDialog.isShowing()){
                        progressDialog.dismiss();
                    }

                    Toast.makeText(CatalogActivity.this, "Failed to retrieve", Toast.LENGTH_SHORT).show();
                }
            });
        } catch (IOException ex){
            ex.printStackTrace();
        }




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



//        final long ONE_MEGABYTE = 1024 * 1024;
//        gsReference.getBytes(ONE_MEGABYTE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
//            @Override
//            public void onSuccess(byte[] bytes) {
//                // Data for "images/island.jpg" is returns, use this as needed
//                Bitmap bmp = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
//                ImageView imgProductImg = (ImageView) findViewById(R.id.imgProductImg);
//                imgProductImg.setImageBitmap(Bitmap.createScaledBitmap(bmp, imgProductImg.getWidth(), imgProductImg.getHeight(), false));
//
////                for (Product product: Products) {
//////                    product.setProductImg();
////                }
//            }
//        }).addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull Exception exception) {
//                // Handle any errors
//            }
//        });




    }


}