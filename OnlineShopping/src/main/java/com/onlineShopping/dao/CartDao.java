package com.onlineShopping.dao;

import java.util.List;

import com.onlineShopping.pojo.Cart;

public interface CartDao {

	boolean addToCart(int pid ,String userEmail);
	List<Cart> getCartList(String userName);
	boolean deleteCart(int cartId);
	boolean clearCart(String userName);
}
