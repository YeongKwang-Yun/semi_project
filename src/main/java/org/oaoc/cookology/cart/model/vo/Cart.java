package org.oaoc.cookology.cart.model.vo;

import org.oaoc.cookology.product.model.vo.Product;

import java.io.Serializable;

public class Cart implements Serializable {

	private static final long serialVersionUID = -2722983182502663838L;
	private int cart_seq_id;						// 장바구니 고유번호
	private String user_email;						// 유저 이메일
	private int product_seq_id;						// 상품 고유번호
	private int amount;					      	    // 상품 갯수
	private int price;					 	    // 상품 총 가격
	private Product product;

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cart(int cart_seq_id, String user_email,int product_seq_id, int amount, int price) {
		super();
		this.cart_seq_id = cart_seq_id;
		this.user_email = user_email;
		this.product_seq_id = product_seq_id;
		this.amount = amount;
		this.price = price;
	}

	public Cart(String user_email, int product_seq_id, int amount, int price) {
		super();
		this.user_email = user_email;
		this.product_seq_id = product_seq_id;
		this.amount = amount;
		this.price = price;
	}

	public int getCart_seq_id() {
		return cart_seq_id;
	}
	public String getUser_email() {
		return user_email;
	}
	public int getProduct_seq_id() {
		return product_seq_id;
	}
	public int getAmount() {
		return amount;
	}
	public int getPrice() {
		return price;
	}
	public Product getProduct() {
		return product;
	}
	public void setCart_seq_id(int cart_seq_id) {
		this.cart_seq_id = cart_seq_id;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public void setProduct_seq_id(int product_seq_id) {
		this.product_seq_id = product_seq_id;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "Cart [cart_seq_id=" + cart_seq_id + ", user_email=" + user_email + ", product_seq_id=" + product_seq_id
				+ ", amount=" + amount + ", price=" + price + "]";
	}
}