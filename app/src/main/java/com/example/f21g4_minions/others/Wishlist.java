package com.example.f21g4_minions.others;

import com.example.f21g4_minions.others.Product;

import java.util.ArrayList;

public class Wishlist {

    private static ArrayList<Product> ProductsinWishlist = new ArrayList<>();

    public static ArrayList<Product> getProductsinWishlist() {
        return ProductsinWishlist;
    }

    public static void addItemToWishlist(Product product) {
        ProductsinWishlist.add(product);
    }
}
