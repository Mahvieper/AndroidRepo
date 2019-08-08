package com.example.myuserapplication.Application;

public class Cart {
    private Product product;
    private int productCount;

    public Cart() {

    }

    public Cart(Product product, int productCount) {
        this.product = product;
        this.productCount = productCount;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

}
