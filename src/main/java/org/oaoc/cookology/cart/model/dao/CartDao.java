package org.oaoc.cookology.cart.model.dao;


import org.mybatis.spring.SqlSessionTemplate;
import org.oaoc.cookology.cart.model.vo.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

    @Repository("cartDao")
    public class CartDao {

        @Autowired
        private SqlSessionTemplate session;
        // 카트에 상품 추가
        public int addToCart(Cart cart) {
            return session.insert("cartMapper.addToCart", cart);
        }

        // 카트 목록 조회
        public List<Cart> getCartList(String user_email) {
            return session.selectList("cartMapper.getCartList", user_email);
        }

        // 카트 상품 개수 수정
        public int updateCartItem(int cart_seq_id, int amount) {
            Cart cart = new Cart();
            cart.setCart_seq_id(cart_seq_id);
            cart.setAmount(amount);
            return session.update("cartMapper.updateCartItem", cart);
        }

        // 카트에서 상품 삭제
        public int removeCartItem(int cart_seq_id) {
            return session.delete("cartMapper.removeCartItem", cart_seq_id);
        }

        public ArrayList<Cart> getCartListWithProductInfo(String user_email) {
            List<Cart> list = session.selectList("cartMapper.getCartListWithProductInfo", user_email);
            return (ArrayList<Cart>)list;
        }
    }