package com.example.f21g4_minions.ViewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.f21g4_minions.Interface.ItemClickListener;
import com.example.f21g4_minions.R;


public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView txtProductName;
    public TextView txtProductDescription;
    public TextView txtProductPrice;
    public TextView txtProductStatus;
    public ImageView imageView;
    public ItemClickListener listener;


    public ItemViewHolder(@NonNull View itemView) {
        super(itemView);


        imageView = itemView.findViewById(R.id.product_seller_image);
        txtProductName = itemView.findViewById(R.id.seller_product_name);
        txtProductDescription = itemView.findViewById(R.id.product_seller_description);
        txtProductPrice = itemView.findViewById(R.id.product_seller_price);
        txtProductStatus = itemView.findViewById(R.id.seller_product_state);


    }

    public void setItemClickListener(ItemClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View view) {
        listener.onClick(view, getAdapterPosition(), false);
    }
}
