package com.example.f21g4_minions;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CartAdapter extends BaseAdapter {

    private ArrayList<Product> ProductsinCart;

    public CartAdapter(ArrayList<Product> productsinCart) {
        ProductsinCart = productsinCart;
    }

    @Override
    public int getCount() {
        return ProductsinCart.size();
    }

    @Override
    public Product getItem(int i) {
        return ProductsinCart.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.layout_cartitem, viewGroup, false);
        }

        TextView txtProductNameinCart = view.findViewById(R.id.txtProductNameinCart);
        TextView txtProductQtyinCart = view.findViewById(R.id.txtProductQtyinCart);
        TextView txtProductPriceinCart = view.findViewById(R.id.txtProductPriceinCart);

        txtProductNameinCart.setText(ProductsinCart.get(i).getProduct_name().toString());
        txtProductQtyinCart.setText("1");
        txtProductPriceinCart.setText(ProductsinCart.get(i).getProduct_price().toString());

        return view;
    }
}
