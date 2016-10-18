package ru.handmug.Entity;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> cartItems;

    public Cart() {
        cartItems = new ArrayList<>();
    }

    public void addItem(CartItem cartItem) {
        for (CartItem item: cartItems) {
            if(item.getProductId() == cartItem.getProductId()) {
                int oldCount = item.getCount();
                item.setCount(oldCount + cartItem.getCount());
                return;
            }
        }

        cartItems.add(cartItem);
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }
}
