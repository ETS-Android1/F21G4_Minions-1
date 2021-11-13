package com.example.f21g4_minions;

public class Product {
    private int ProductImg;
    private String ProductName;
    private String ProductCategory;
    private String ProductDescription;
    private String ProductPrice;

    public Product(int productImg, String productName, String productCategory, String productDescription, String productPrice) {
        ProductImg = productImg;
        ProductName = productName;
        ProductCategory = productCategory;
        ProductDescription = productDescription;
        ProductPrice = productPrice;
    }

    public int getProductImg() {
        return ProductImg;
    }

    public void setProductImg(int productImg) {
        ProductImg = productImg;
    }
    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public String getProductCategory() {
        return ProductCategory;
    }

    public void setProductCategory(String productCategory) {
        ProductCategory = productCategory;
    }

    public String getProductDescription() {
        return ProductDescription;
    }

    public void setProductDescription(String productDescription) {
        ProductDescription = productDescription;
    }

    public String getProductPrice() {
        return ProductPrice;
    }

    public void setProductPrice(String productPrice) {
        ProductPrice = productPrice;
    }
}
