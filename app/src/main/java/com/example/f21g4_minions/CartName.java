package com.example.f21g4_minions;

import java.util.ArrayList;

public class CartName {
    private static ArrayList<Product> ProductsinCart = new ArrayList<>();

    public static ArrayList<Product> getProductsinCart() {
        return ProductsinCart;
    }

    public static void addItemToCart(Product product) {
        ProductsinCart.add(product);
    }
}
