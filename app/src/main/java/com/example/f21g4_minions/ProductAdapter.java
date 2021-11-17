package com.example.f21g4_minions;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class ProductAdapter extends BaseAdapter {


    List<Product> Products;
    private Context context;

    public ProductAdapter(List<Product> products) {
        Products = products;
    }

    //Creating this constructor to pass tha context
    public ProductAdapter(Context context, ArrayList<Product> products) {
        this.context = context;
        Products = products;
    }
    @Override
    public int getCount() {
        return Products.size();
    }

    @Override
    public Product getItem(int i) {
        return Products.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // is responsible for populating ith view in adapter using
        // data and external layout for each item

        if (convertView == null) {
            // inflate external layout and assign layout view to convertView
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            convertView = layoutInflater.inflate(R.layout.layout_product, parent, false);
        }
        ImageView imgProductImg = convertView.findViewById(R.id.imgProductImg);
        LinearLayout linearLayout = convertView.findViewById(R.id.linearViewProductDetails);
        TextView txtProductName = (TextView) linearLayout.getChildAt(0);
        TextView txtProductCategory = (TextView) linearLayout.getChildAt(1);
        TextView txtProductDescription = (TextView) linearLayout.getChildAt(2);
        TextView txtProductPrice = (TextView) linearLayout.getChildAt(3);


        //imgProductImg.setImageResource(Products.get(position).getProduct_imgUrl());

        //Using glide library to show the images
        Glide.with(context).load(Products.get(position).getProduct_img()).into(imgProductImg);


        txtProductName.setText(Products.get(position).getProduct_name());
        txtProductCategory.setText(Products.get(position).getProduct_category());
        txtProductDescription.setText(Products.get(position).getProduct_description());
        txtProductPrice.setText(Products.get(position).getProduct_price());


//        Drawable img = ResourcesCompat
//                .getDrawable(parent.getResources(),
//                        Products.get(position).getProductImg(),
//                        parent.getContext().getTheme());
//
//        img.setBounds(0,0,80,80);
//
//        // setting drawables for text view
//        txtViewSite.setCompoundDrawables(img,null,null,null);
//        txtViewSite.setCompoundDrawablePadding(8);
//        txtViewSite.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
        return convertView;
    }
}
