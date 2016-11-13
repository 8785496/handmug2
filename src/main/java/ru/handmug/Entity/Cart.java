package ru.handmug.Entity;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> cartItems;

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    private int totalQuantity;
    private int totalPrice;

    public Cart() {
        cartItems = new ArrayList<>();
        totalQuantity = 0;
        totalPrice = 0;
    }

    public void addItem(CartItem cartItem, int price) {
        totalQuantity += cartItem.getQuantity();
        totalPrice += price * cartItem.getQuantity();

        for (CartItem item: cartItems) {
            if(item.getProductId() == cartItem.getProductId()) {
                int oldCount = item.getQuantity();
                item.setQuantity(oldCount + cartItem.getQuantity());
                return;
            }
        }

        cartItems.add(cartItem);
    }

    public void removeItem(int id) {
        for (int i = 0; i < cartItems.size(); i++) {
            if(cartItems.get(id).getProductId() == id) {
                cartItems.remove(id);

                return;
            }
        }
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }
}
