package com.example.f21g4_minions.others;

public class Product {
    private String product_img;
    private String product_name;
    private String product_category;
    private String product_description;
    private String product_price;


    public Product(String product_name, String product_category, String product_price) {
        this.product_name = product_name;
        this.product_category = product_category;
        this.product_price = product_price;
    }

    public Product(){

    }

    public Product(String productimgUrl, String productname, String productcategory, String productdescription, String productprice) {
        product_img = productimgUrl;
        product_name = productname;
        product_category = productcategory;
        product_description = productdescription;
        product_price = productprice;
    }

    public String getProduct_img() {
        return product_img;
    }

    public void setProduct_img(String product_img) {
        this.product_img = product_img;
    }
    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_category() {
        return product_category;
    }

    public void setProduct_category(String product_category) {
        this.product_category = product_category;
    }

    public String getProduct_description() {
        return product_description;
    }

    public void setProduct_description(String product_description) {
        this.product_description = product_description;
    }

    public String getProduct_price() {
        return product_price;
    }

    public void setProduct_price(String product_price) {
        this.product_price = product_price;
    }
}
