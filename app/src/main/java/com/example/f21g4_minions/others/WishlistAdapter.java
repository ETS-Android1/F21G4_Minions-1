package com.example.f21g4_minions.others;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.f21g4_minions.R;
import com.example.f21g4_minions.others.Product;

import java.util.ArrayList;

public class WishlistAdapter extends BaseAdapter {

    private ArrayList<Product> ProductsinWishlist;

    public WishlistAdapter(ArrayList<Product> productsinWishlist) {
        ProductsinWishlist = productsinWishlist;
    }

    @Override
    public int getCount() {
        return ProductsinWishlist.size();
    }

    @Override
    public Product getItem(int i) {
        return ProductsinWishlist.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.layout_wishlistitem, viewGroup, false);
        }

        TextView txtProductNameinWishlist = view.findViewById(R.id.txtProductNameinWishlist);
        TextView txtProductQtyinWishlist = view.findViewById(R.id.txtProductQtyinWishlist);
        TextView txtProductPriceinWishlist = view.findViewById(R.id.txtProductPriceinWishlist);

        txtProductNameinWishlist.setText(ProductsinWishlist.get(i).getProduct_name().toString());
        txtProductQtyinWishlist.setText("1");
        txtProductPriceinWishlist.setText(ProductsinWishlist.get(i).getProduct_price().toString());

        return view;
    }
}
