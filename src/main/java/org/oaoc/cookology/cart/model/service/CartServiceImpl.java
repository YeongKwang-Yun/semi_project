package org.oaoc.cookology.cart.model.service;

import org.oaoc.cookology.cart.model.dao.CartDao;
import org.oaoc.cookology.cart.model.vo.Cart;
import org.oaoc.cookology.product.model.service.ProductService;
import org.oaoc.cookology.product.model.vo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("cartService")
public class CartServiceImpl implements CartService {

    @Autowired
    CartDao cartDao;
    @Autowired
    ProductService productService;

    @Override
    public void addToCart(String user_email, int product_seq_id, int amount) {
        // 상품 정보를 조회하여 가격을 가져옴
        Product product = productService.selectProduct(product_seq_id);
        int price = product.getProduct_price();

        // 장바구니에 상품 추가
        Cart cart = new Cart(user_email, product_seq_id, amount, price);
        cartDao.addToCart(cart);
    }


    @Override
    public ArrayList<Cart> getCartList(String user_email) {
        List<Cart> list = cartDao.getCartList(user_email);
        return (ArrayList<Cart>) list;
    }

    @Override
    public int updateCartItem(int cart_seq_id, int amount) {

        return cartDao.updateCartItem(cart_seq_id, amount);
    }

    @Override
    public int removeCartItem(int cart_seq_id) {

        return cartDao.removeCartItem(cart_seq_id);
    }
    @Override
    public ArrayList<Cart> getCartListWithProductInfo(String user_email) {
        return cartDao.getCartListWithProductInfo(user_email);
    }
}

