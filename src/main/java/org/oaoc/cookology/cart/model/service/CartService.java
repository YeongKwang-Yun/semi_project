package org.oaoc.cookology.cart.model.service;

import org.oaoc.cookology.cart.model.vo.Cart;

import java.util.ArrayList;
import java.util.List;

public interface CartService {
    void addToCart(String user_email, int product_seq_id, int amount);
    ArrayList<Cart> getCartList(String user_email);
    int updateCartItem(int cart_seq_id, int amount);
    int removeCartItem(int cart_seq_id);
    ArrayList<Cart> getCartListWithProductInfo(String user_email);
}

