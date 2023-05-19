package org.oaoc.cookology.cart.controller;

import org.oaoc.cookology.cart.model.service.CartService;
import org.oaoc.cookology.cart.model.vo.Cart;
import org.oaoc.cookology.product.model.service.ProductService;
import org.oaoc.cookology.product.model.vo.Product;
import org.oaoc.cookology.users.model.vo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
public class CartController {

    @Autowired
    private CartService cartService;
    @Autowired
    private ProductService productService;

    // 상품을 장바구니에 추가하기
    @RequestMapping(value="cartInsert.do", method={RequestMethod.GET, RequestMethod.POST})
    public ModelAndView  addToCart(@RequestParam("product_seq_id") int product_seq_id
                                , @RequestParam("amount") int amount
                                , HttpSession session) {
        // 1. 현재 세션에 저장된 사용자 정보를 가져옴
        Users loginUsers = (Users) session.getAttribute("loginUsers");

        // 2. 로그인되어 있지 않은 경우, 로그인 페이지로 이동
        if (loginUsers == null) {
            return new ModelAndView("redirect:/loginPage.do");
        }

        // 3. 로그인 되어있을 경우 상품을 장바구니에 추가함
        cartService.addToCart(loginUsers.getUser_email(), product_seq_id, amount);

        // 4. 상품 추가 후 장바구니 페이지로 이동
        return new ModelAndView("redirect:/cartList.do");
    }

    // 장바구니 페이지로 이동하기
    @RequestMapping(value="cartList.do" , method={ RequestMethod.GET , RequestMethod.POST })
    public ModelAndView moveCartListPage(HttpSession session) {

        // 1. 로그인된 사용자인지 체크 : 현재 세션에 저장된 사용자 정보를 가져옴
        Users loginUsers = (Users) session.getAttribute("loginUsers");

        // 2. 로그인되어 있지 않은 경우, 로그인 페이지로 이동
        if (loginUsers == null) {
            return new ModelAndView("redirect:/loginPage.do");
        }

        // 3. 로그인된 사용자의 장바구니 목록을 가져오기 : 사용자의 이메일로 장바구니 목록을 가져옴
        String user_email = loginUsers.getUser_email();

        ArrayList<Cart> cartList = cartService.getCartListWithProductInfo(user_email);
        // 4. 각 장바구니 항목에 대한 상품 정보 가져오기
        HashMap<Integer, Product> productList = new HashMap<>();
        for (Cart cart : cartList) {
            int product_seq_id = cart.getProduct_seq_id();
            Product product = productService.selectProduct(product_seq_id);
            productList.put(product_seq_id, product);
        }
        List<String> selectedProductNames = new ArrayList<>();
        for (Cart cart : cartList) {
            int product_seq_id = cart.getProduct_seq_id();
            Product product = productService.selectProduct(product_seq_id);
            selectedProductNames.add(product.getProduct_name());
        }
// 5. 선택된 상품 이름을 문자열로 변환
        String productNameList = String.join(", ", selectedProductNames);
// 6. 선택된 상품 이름을 ModelAndView 객체에 추가
        ModelAndView mv = new ModelAndView("order/cartList");
        mv.addObject("cartList", cartList);
        mv.addObject("productList", productList);
        mv.addObject("productNameList", productNameList); // 선택된 상품 이름 목록 추가
        mv.addObject("cartList", cartList);
        mv.addObject("productList", productList);
        mv.addObject("buyerEmail", loginUsers.getUser_email()); // 구매자 이메일 추가
        mv.addObject("buyerName", loginUsers.getUser_name()); // 구매자 이름 추가
        mv.addObject("buyerTel", loginUsers.getUser_phone()); // 구매자 전화번호 추가
        mv.addObject("buyerAddr1", loginUsers.getUser_address1()); // 구매자 주소 추가
        mv.addObject("buyerAddr2", loginUsers.getUser_address2()); // 구매자 주소 추가
        mv.addObject("buyerPostcode", loginUsers.getUser_post_code()); // 구매자 우편번호 추가
        return mv;
    }
    /*------------------------------------------------------------------------------*/

    // 장바구니에 등록된 상품 갯수 수정하기
    @RequestMapping(value="updateCartItem.do", method={RequestMethod.GET, RequestMethod.POST})
    public ModelAndView updateCartItem(@RequestParam("cart_seq_id") int cart_seq_id
            , @RequestParam("amount") int amount, HttpSession session) {
        cartService.updateCartItem(cart_seq_id, amount);

        // 장//바구니 페이지로 이동
        return new ModelAndView("redirect:/cartList.do");
        }
    // 장바구니에 등록된 상품 삭제하기
    @RequestMapping(value="removeCartItem.do", method={RequestMethod.GET, RequestMethod.POST})
    public ModelAndView removeCartItem(@RequestParam("cart_seq_id") int cart_seq_id, HttpSession session) {

        // 3. 장바구니에 있는 상품을 제거함
        cartService.removeCartItem(cart_seq_id);

        // 상품 삭제 후 장바구니 페이지로 이동
        return new ModelAndView("redirect:/cartList.do");
    }
}