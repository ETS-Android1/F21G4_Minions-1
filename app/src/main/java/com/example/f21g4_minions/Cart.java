package com.example.f21g4_minions;

import java.util.ArrayList;

public class Cart {
    private static ArrayList<Product> ProductsinCart = new ArrayList<>();

    public static ArrayList<Product> getProductsinCart() {
        return ProductsinCart;
    }

    public static void setProductsinCart(ArrayList<Product> productsinCart) {
        ProductsinCart = productsinCart;
    }

    public static void addItemToCart(Product product) {
        ProductsinCart.add(product);
    }
}
