package ru.handmug.Entity;

/**
 * Created by user on 14.10.16.
 */
public class CartItem {
    private String product;
    private int count;

    public CartItem() {}

    public CartItem(String product, int count) {
        this.product = product;
        this.count = count;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }


}
