package com.example.shop.model;

import com.example.shop.entity.Product;

import java.io.Serializable;

public class ShoppingCartItem implements Serializable {
    private static final long serialVersionUID = -7058697338554971170L;
    private Product product;
    private int count;
    public ShoppingCartItem() {
        super();
    }
    public ShoppingCartItem(Product product, int count) {
        super();
        this.product = product;
        this.count = count;
    }
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
    @Override
    public String toString() {
        return String.format("ShoppingCartItem [product=%s, count=%s]", product, count);
    }
}
