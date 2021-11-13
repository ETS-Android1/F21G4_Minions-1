package com.example.f21g4_minions;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.core.content.res.ResourcesCompat;

import org.w3c.dom.Text;

import java.util.List;

public class ProductAdapter extends BaseAdapter {


    List<Product> Products;

    public ProductAdapter(List<Product> products) {
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


        imgProductImg.setImageResource(Products.get(position).getProductImg());



        txtProductName.setText(Products.get(position).getProductName());
        txtProductCategory.setText(Products.get(position).getProductCategory());
        txtProductDescription.setText(Products.get(position).getProductDescription());
        txtProductPrice.setText(Products.get(position).getProductPrice());


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
